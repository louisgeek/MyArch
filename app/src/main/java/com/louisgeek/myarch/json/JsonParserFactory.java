package com.louisgeek.myarch.json;


import com.louisgeek.myarch.json.gson.GsonJsonParser;

public class JsonParserFactory {
    private static IJsonParser getInstance() {
        return Inner.sInstance;
    }

    private static class Inner {
        private static IJsonParser sInstance = new GsonJsonParser();
//        private static IJsonParser sInstance_FastJson = new FastJsonParser();
    }

    public static IJsonParser getGson() {
        return Inner.sInstance;
    }

   /* public static IJsonParser getFastJson() {
        return Inner.sInstance_FastJson;
    }*/
}
