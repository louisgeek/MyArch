package com.louisgeek.myarch.json;

public interface IJsonParser {
    String toJson(Object src);

    <T> BaseJson fromJson(String json, Class<T> tClass);
}
