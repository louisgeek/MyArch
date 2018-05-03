package com.louisgeek.myarch.http.request;

import com.louisgeek.myarch.http.okhttp.OkHttpManager;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;


public abstract class BaseHttpRequest<T> {
    protected String mUrl;
    protected Object mTag;
    protected Map<String, String> mHeaders;

    public T url(String url) {
        this.mUrl = url;
        return (T) this;
    }

    public T tag(Object tag) {
        this.mTag = tag;
        return (T) this;
    }

    public T headers(Map<String, String> headers) {
        this.mHeaders = headers;
        return (T) this;
    }

    public T addHeader(String key, String value) {
        if (mHeaders == null) {
            mHeaders = new LinkedHashMap<>();
        }
        mHeaders.put(key, value);
        return (T) this;
    }

    public Response execute() throws IOException {
        Request request = buildRequest();
        return OkHttpManager.getInstance().getOkHttpClient().newCall(request).execute();
    }

    public void enqueue(Callback responseCallback) {
        Request request = buildRequest();
        OkHttpManager.getInstance().getOkHttpClient().newCall(request).enqueue(responseCallback);
    }

    abstract Request buildRequest();
}
