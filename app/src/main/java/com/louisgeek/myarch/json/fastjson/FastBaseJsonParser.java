package com.louisgeek.myarch.json.fastjson;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.google.gson.Gson;
import com.louisgeek.myarch.json.IBaseJsonParser;
import com.louisgeek.myarch.json.IJsonParser;
import com.louisgeek.myarch.json.base.BaseJson;
import com.louisgeek.myarch.json.fastjson.custom.FastBaseJsonDataObjectDeserializer;

import java.lang.reflect.Type;


public class FastBaseJsonParser implements IBaseJsonParser {
    private static final String TAG = "FastBaseJsonParser";

    @Override
    public String toJson(Object src) {
        return JSON.toJSONString(src);
    }

    @Override
    public <T> BaseJson fromJson(String json, Class<T> classOfT) {
        ParserConfig parserConfig = ParserConfig.getGlobalInstance();
        parserConfig.putDeserializer(BaseJson.class, new FastBaseJsonDataObjectDeserializer(classOfT));
        return JSON.parseObject(json, BaseJson.class);
    }
}
