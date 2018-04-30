package com.louisgeek.myarch.http.okhttp;

import com.louisgeek.myarch.http.IHttpManager;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Map;

@Deprecated
public class OkHttpManager implements IHttpManager {
    @Override
    public String get(String url, Map<String, String> headersMap) {
        try {
            return OkHttpManager2.getInstance().get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String post(String url, Map<String, String> headersMap,
                       Map<String, String> paramsMap) {
        try {
            return OkHttpManager2.getInstance().postJson(url, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
