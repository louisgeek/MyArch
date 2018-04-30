package com.louisgeek.myarch.json.gson;

import com.louisgeek.myarch.json.BaseJson;
import com.louisgeek.myarch.json.IJsonParser;

public class GsonJsonParser implements IJsonParser {
    private MyGson mMyGson = new MyGson();

    @Override
    public String toJson(Object src) {
        return mMyGson.toJson(src);
    }

    @Override
    public <T> BaseJson fromJson(String json, Class<T> tClass) {
        return mMyGson.fromJson(json, tClass);
    }
}
