package com.louisgeek.myarch.json.gson;

import com.google.gson.Gson;
import com.louisgeek.myarch.json.BaseJson;
import com.louisgeek.myarch.json.IBaseJsonParser;

import java.lang.reflect.Type;
@Deprecated
public class GsonBaseJsonParser implements IBaseJsonParser {
    private MyGson mMyGson = new MyGson();

    @Override
    public String toJson(Object src) {
        return mMyGson.toJson(src);
    }

    @Override
    public <T> BaseJson fromJson(String json, Class<T> tClass) {
        return mMyGson.fromJson(json, tClass);
    }

    @Override
    public BaseJson fromJson(String json, Type typeOfT) {
        return mMyGson.fromJson(json, typeOfT);
    }
}
