package com.louisgeek.myarch.json.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.louisgeek.myarch.json.base.BaseJson;
import com.louisgeek.myarch.json.IBaseJsonParser;
import com.louisgeek.myarch.json.gson.custom.GsonBaseJsonDataDeserializer;

import java.lang.reflect.Type;

public class GsonBaseJsonParser implements IBaseJsonParser {

    @Override
    public String toJson(Object src) {
        return new Gson().toJson(src);
    }

    @Override
    public <T> BaseJson fromJson(String json, Class<T> typeOfT) {
        Gson myGson = new GsonBuilder()
                .registerTypeAdapter(BaseJson.class, new GsonBaseJsonDataDeserializer(typeOfT))
//                .enableComplexMapKeySerialization()
                .serializeNulls()
                .create();
        return myGson.fromJson(json, BaseJson.class);
    }
}
