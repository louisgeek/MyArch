package com.louisgeek.myarch.json;


import com.louisgeek.myarch.json.gson.GsonJsonParser;

public class JsonParserFactory {
    public static IJsonParser getInstance() {
        return Inner.sInstance;
    }

    private static class Inner {
        private static IJsonParser sInstance = new GsonJsonParser();
//        private static IJsonParser sInstance = new JacksonJsonParser();
    }
}
