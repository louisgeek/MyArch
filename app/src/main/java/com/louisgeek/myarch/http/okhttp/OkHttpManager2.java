package com.louisgeek.myarch.http.okhttp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpManager2 {
    private OkHttpClient mOkHttpClient;

    private OkHttpManager2() {
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(30_000, TimeUnit.MILLISECONDS)
                .readTimeout(30_000, TimeUnit.MILLISECONDS)
                .build();
    }

    public static OkHttpManager2 getInstance() {
        return Inner.sInstance;
    }

    private static class Inner {
        private static OkHttpManager2 sInstance = new OkHttpManager2();
    }

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    public String postJson(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = mOkHttpClient.newCall(request).execute();
        return response.body().string();

    }

    public String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = mOkHttpClient.newCall(request).execute();
        return response.body().string();
    }

}
