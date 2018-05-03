package com.louisgeek.myarch.json;

import java.lang.reflect.Type;

public interface IJsonParser {
    String toJson(Object src);

    <T> T fromJson(String json, Class<T> classOfT);

    <T> T fromJson(String json, Type typeOfT);
}
