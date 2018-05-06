package com.louisgeek.myarch.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.louisgeek.myarch.json.IJsonParser;
import com.louisgeek.myarch.json.base.BaseJson;
import com.louisgeek.myarch.json.fastjson.custom.FastBaseJsonDataObjectDeserializer;

import java.lang.reflect.Type;


public class FastJsonParser implements IJsonParser {
    private static final String TAG = "FastJsonParser";

    @Override
    public String toJson(Object src) {
        return JSON.toJSONString(src);
    }

    @Override
    public <T> T fromJson(String json, Class<T> classOfT) {
        return JSON.parseObject(json, classOfT);
    }

    @Override
    public <T> T fromJson(String json, Type typeOfT) {
        return JSON.parseObject(json, typeOfT);
    }
}
