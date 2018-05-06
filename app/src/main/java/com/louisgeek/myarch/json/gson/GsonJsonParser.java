package com.louisgeek.myarch.json.gson;

import android.util.Log;

import com.google.gson.Gson;
import com.louisgeek.myarch.json.IJsonParser;

import java.lang.reflect.Type;


public class GsonJsonParser implements IJsonParser {
    private static final String TAG = "GsonJsonParser";
    private Gson mGson = new Gson();

    @Override
    public String toJson(Object src) {
        return mGson.toJson(src);
    }

    @Override
    public <T> T fromJson(String json, Class<T> classOfT) {
        try {
            return mGson.fromJson(json, classOfT);
        } catch (RuntimeException e) {
            Log.e(TAG, "fromJson: ", e);
            return null;
        }
    }

    @Override
    public <T> T fromJson(String json, Type typeOfT) {
        try {
            return mGson.fromJson(json, typeOfT);
        } catch (RuntimeException e) {
            Log.e(TAG, "fromJson: ", e);
            return null;
        }
    }
}
