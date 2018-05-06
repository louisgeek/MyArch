package com.louisgeek.myarch.json.fastjson.custom;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import com.louisgeek.myarch.json.base.BaseJson;
import com.louisgeek.myarch.json.base.DataType;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FastBaseJsonDataObjectDeserializer implements ObjectDeserializer {
    private Class mClass;

    public FastBaseJsonDataObjectDeserializer(Class mClass) {
        this.mClass = mClass;
    }

    @Override
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {

        BaseJson baseJson = new BaseJson();
        Object object = parser.parse();
        if (object == null) {
            return null;
        }
        if (object instanceof JSONArray) {
            return null;
        }
        JSONObject jsonObject = null;
        String jsonStr;
        if (object instanceof String) {
            jsonStr = (String) object;
            // 服务端带首尾引号导致的生成转义字符
            jsonStr = jsonStr.replaceAll("\\\\", "");
            if ("".equals(jsonStr.trim())) {
                return null;
            }
            if ("null".equals(jsonStr.toLowerCase().trim())) {
                return null;
            }
            if ("{}".equals(jsonStr.trim())) {
                return null;
            }
            if ("[]".equals(jsonStr.trim())) {
                return null;
            }
            //重新转化成对象处理
            object = JSON.parseObject(jsonStr);
        }
        if (object instanceof JSONObject) {
            jsonObject = (JSONObject) object;
        }
        if (jsonObject == null) {
            return null;
        }
        //======================== code =====================
        if (jsonObject.get("code") instanceof Number) {
            //e.g. { "data": null, "code": 1,"msg": "信息" }
            Number number = (Number) jsonObject.get("code");
            int code = number.intValue();
            baseJson.setCode(code);
        }
        if (jsonObject.get("code") instanceof String) {
            //e.g. { "data": null, "code": "1","msg": "信息" }
            String codeStr = (String) jsonObject.get("code");
            int code = TextUtils.isEmpty(codeStr) ? 0 : Integer.valueOf(codeStr);
            baseJson.setCode(code);
        }
        //======================== msg =====================
        if (jsonObject.get("msg") instanceof String) {
            baseJson.setMsg((String) jsonObject.get("msg"));
        }
        //======================== data =====================
        //e.g. { "data": null, "code": 1,"msg": "信息" }
        if (jsonObject.get("data") == null) {
            baseJson.setDataType(DataType.NULL);
            return (T) baseJson;
        }
        //e.g. { "data": "", "code": 1,"msg": "信息" }
        if (jsonObject.get("data") instanceof String) {
            jsonStr = (String) jsonObject.get("data");
            if ("".equals(jsonStr.trim())) {
                baseJson.setData("");
                baseJson.setDataType(DataType.STRING);
                return (T) baseJson;
            }
            if ("null".equals(jsonStr.toLowerCase().trim())) {
                baseJson.setDataType(DataType.NULL);
                return (T) baseJson;
            }
        }
        //e.g.  { "data": [{"uid":"u123"},{"uid":"u456"}], "code": 1,"msg": "信息" }
        if (jsonObject.get("data") instanceof JSONArray) {
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            jsonStr = jsonArray.toJSONString();
            baseJson.setData(fromJsonArray(jsonStr, mClass));
            baseJson.setDataType(DataType.ARRAY);
            return (T) baseJson;
        }
        //e.g.  { "data": {"uid":"u123"}, "code": 1,"msg": "信息" }
        if (jsonObject.get("data") instanceof JSONObject) {
            JSONObject jsonObjectTemp = jsonObject.getJSONObject("data");
            jsonStr = jsonObjectTemp.toJSONString();
            baseJson.setData(fromJsonObject(jsonStr, mClass));
            baseJson.setDataType(DataType.OBJECT);
            return (T) baseJson;
        }
        return (T) baseJson;
    }

    /**
     * 用来解析对象
     */
    private <T> T fromJsonObject(String json, Class<T> classOfT) {
        return JSON.parseObject(json, classOfT);
    }

    /**
     * 用来解析集合
     */
    private <T> List<T> fromJsonArray(String json, Class<T> classOfT) {
        return JSON.parseArray(json, classOfT);
    }
}
