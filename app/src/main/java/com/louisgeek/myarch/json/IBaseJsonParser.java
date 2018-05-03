package com.louisgeek.myarch.json;

import java.lang.reflect.Type;
@Deprecated
public interface IBaseJsonParser {
    String toJson(Object src);

    <T> BaseJson fromJson(String json, Class<T> classOfT);

    BaseJson fromJson(String json, Type typeOfT);
}
