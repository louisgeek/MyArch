package com.louisgeek.myarch.json;

import com.louisgeek.myarch.json.base.BaseJson;

import java.lang.reflect.Type;

public interface IBaseJsonParser {
    String toJson(Object src);

    <T> BaseJson fromJson(String json, Class<T> classOfT);

//    BaseJson fromJson(String json, Type typeOfT);
}
