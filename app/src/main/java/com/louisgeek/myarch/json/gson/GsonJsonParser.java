package com.louisgeek.myarch.json.gson;

import com.google.gson.Gson;
import com.louisgeek.myarch.json.BaseJson;
import com.louisgeek.myarch.json.IBaseJsonParser;
import com.louisgeek.myarch.json.IJsonParser;

import java.lang.reflect.Type;


public class GsonJsonParser implements IJsonParser {
    private Gson mGson = new Gson();
    @Override
    public String toJson(Object src) {
        return mGson.toJson(src);
    }

    @Override
    public <T> T fromJson(String json, Class<T> classOfT) {
        return mGson.fromJson(json, classOfT);
    }

    @Override
    public <T> T fromJson(String json, Type typeOfT) {
        return mGson.fromJson(json, typeOfT);
    }
}
