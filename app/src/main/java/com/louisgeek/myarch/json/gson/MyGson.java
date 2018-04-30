package com.louisgeek.myarch.json.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.louisgeek.myarch.json.BaseJson;


public class MyGson {
    private Gson mGson;

    public MyGson() {
        if (mGson == null) {
            mGson = new Gson();
        }
    }

    public <T> BaseJson fromJson(String json, Class<T> tClass) {
        Gson myGson = new GsonBuilder()
                .registerTypeAdapter(BaseJson.class, new GsonBaseJsonDataDeserializer(tClass))
//                .enableComplexMapKeySerialization()
                .serializeNulls()
                .create();
        return myGson.fromJson(json, BaseJson.class);
    }

    public String toJson(Object src) {
        return mGson.toJson(src);
    }
}
