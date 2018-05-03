package com.louisgeek.myarch.json.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.louisgeek.myarch.json.BaseJson;

import java.lang.reflect.Type;


public class MyGson {
    private Gson mGson;

    public MyGson() {
        if (mGson == null) {
            mGson = new Gson();
        }
    }
    //fixme 2018-5-3 18:12:50
    public <T> T fromJson(String json, Type typeOfT) {
        return mGson.fromJson(json, typeOfT);
    }

    public <T> BaseJson fromJson(String json, Class<T> classOfT) {
        Gson myGson = new GsonBuilder()
                .registerTypeAdapter(BaseJson.class, new GsonBaseJsonDataDeserializer(classOfT))
//                .enableComplexMapKeySerialization()
                .serializeNulls()
                .create();
        return myGson.fromJson(json, BaseJson.class);
    }

    public String toJson(Object src) {
        return mGson.toJson(src);
    }
}
