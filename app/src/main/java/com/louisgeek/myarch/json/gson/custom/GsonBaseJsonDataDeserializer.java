package com.louisgeek.myarch.json.gson.custom;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import com.louisgeek.myarch.json.base.BaseJson;
import com.louisgeek.myarch.json.base.DataType;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonBaseJsonDataDeserializer implements JsonDeserializer<BaseJson> {
    private static final String TAG = "GsonBaseJsonDataDeserializer";
    private Class mClass;
    private final Gson mGson = new Gson();

    public GsonBaseJsonDataDeserializer(Class mClass) {
        this.mClass = mClass;
    }

    /**
     * //4个例子对比【 "" "foo"  42  {"foo":"bar","foo2":42}】
     * // String jsonStrHasQuotation  = jsonObject.toString();
     * //4个例子对比【 空字符串 foo  42  java.lang.UnsupportedOperationException: JsonObject】
     * String jsonStr = jsonObject.getAsString();
     *
     * @param json
     * @param typeOfT
     * @param context
     * @return
     * @throws JsonParseException
     */
    @Override
    public BaseJson deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        BaseJson baseJson = new BaseJson();
        JsonObject jsonObject;
        //
        String jsonStr = json.toString();
        if (jsonStr == null || "".equals(jsonStr.trim())) {
            return null;
        }
        //isJsonPrimitive Java 基本类型/包装类/String
        if (json.isJsonPrimitive()) {
            //getAsString 可以去掉 服务端带首尾引号、以及导致的生成转义字符
            jsonStr = json.getAsString();
            if ("".equals(jsonStr.trim())) {
                return null;
            }
            if ("null".equals(jsonStr.toLowerCase().trim())) {
                return null;
            }
        }
        if ("{}".equals(jsonStr.trim())) {
            return null;
        }
        if ("[]".equals(jsonStr.trim())) {
            return null;
        }
        //重新转化成对象处理
        jsonObject = mGson.fromJson(jsonStr, JsonElement.class).getAsJsonObject();
        if (jsonObject == null) {
            return null;
        }
        //======================== code =====================
        if (jsonObject.get("code").isJsonPrimitive()) {
            JsonPrimitive codeJsonPrimitive = jsonObject.get("code").getAsJsonPrimitive();
            int code;
            if (codeJsonPrimitive.isNumber()) {
                //e.g. { "data": null, "code": 1,"msg": "信息" }
                code = jsonObject.get("code").getAsNumber().intValue();
            } else {
                //e.g. { "data": null, "code": "1","msg": "信息" }
                String codeStr = jsonObject.get("code").getAsString();
                code = TextUtils.isEmpty(codeStr) ? 0 : Integer.valueOf(codeStr);
            }
            baseJson.setCode(code);
        }
        //======================== msg =====================
        if (jsonObject.get("msg").isJsonPrimitive()) {
            baseJson.setMsg(jsonObject.get("msg").getAsString());
        }
        //======================== data =====================
        //e.g. { "data": null, "code": 1,"msg": "信息" }
        if (jsonObject.get("data").isJsonNull()) {
            baseJson.setDataType(DataType.NULL);
            return baseJson;
        }
        //e.g. { "data": "", "code": 1,"msg": "信息" }
        if (jsonObject.get("data").isJsonPrimitive()) {
            //getAsString
            jsonStr = jsonObject.get("data").getAsString();
            if ("".equals(jsonStr.trim())) {
                baseJson.setData("");
                baseJson.setDataType(DataType.STRING);
                return baseJson;
            }
            if ("null".equals(jsonStr.toLowerCase().trim())) {
                baseJson.setDataType(DataType.NULL);
                return baseJson;
            }
        }
        //e.g.  { "data": [{"uid":"u123"},{"uid":"u456"}], "code": 1,"msg": "信息" }
        if (jsonObject.get("data").isJsonArray()) {
            //toString
            jsonStr = jsonObject.get("data").toString();
            baseJson.setData(fromJsonArray(jsonStr, mClass));
            baseJson.setDataType(DataType.ARRAY);
            return baseJson;
        }
        //e.g.  { "data": {"uid":"u123"}, "code": 1,"msg": "信息" }
        if (jsonObject.get("data").isJsonObject()) {
            //toString
            jsonStr = jsonObject.get("data").toString();
            baseJson.setData(fromJsonObject(jsonStr, mClass));
            baseJson.setDataType(DataType.OBJECT);
            return baseJson;
        }
        return baseJson;
    }

    /**
     * 用来解析对象
     */
    private <T> T fromJsonObject(String json, Class<T> type) {
        return mGson.fromJson(json, type);
    }

    /**
     * 用来解析集合
     */
    private <T> List<T> fromJsonArray(String json, Class<T> clazz) {
        Type type = new TypeToken<List<JsonObject>>() {
        }.getType();
        List<JsonObject> jsonObjects = mGson.fromJson(json, type);
        List<T> list = new ArrayList<>();
        for (JsonObject jsonObject : jsonObjects) {
            list.add(mGson.fromJson(jsonObject, clazz));
        }
        return list;
    }
}
