package com.louisgeek.myarch.json;


import com.louisgeek.myarch.json.fastjson.FastBaseJsonParser;
import com.louisgeek.myarch.json.gson.GsonBaseJsonParser;

public class BaseJsonParserFactory {
    private static IBaseJsonParser getInstance() {
        return Inner.sInstance;
    }

    private static class Inner {
        private static IBaseJsonParser sInstance = new GsonBaseJsonParser();
        private static IBaseJsonParser sInstance_FastJson = new FastBaseJsonParser();
    }

    public static IBaseJsonParser getGson() {
        return Inner.sInstance;
    }
    public static IBaseJsonParser getFastJson() {
        return Inner.sInstance_FastJson;
    }
}
