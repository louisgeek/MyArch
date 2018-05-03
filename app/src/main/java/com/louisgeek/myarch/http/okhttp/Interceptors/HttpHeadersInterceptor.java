package com.louisgeek.myarch.http.okhttp.Interceptors;

import android.util.Log;

import java.io.IOException;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by louisgeek on 2017/6/5.
 */

public class HttpHeadersInterceptor implements Interceptor {
    private static final String TAG = "HttpHeadersInterceptor";

    public HttpHeadersInterceptor(Map<String, String> commonHeaderMap) {
        this.mCommonHeaderMap = commonHeaderMap;
    }

    private Map<String, String> mCommonHeaderMap;

    @Override
    public Response intercept(Chain chain) throws IOException {
        //请求
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        //newBuilder.addHeader("Accept", "Application/JSON");
        for (Map.Entry<String, String> entry : mCommonHeaderMap.entrySet()) {
            newBuilder.addHeader(entry.getKey(), entry.getValue());
            Log.i(TAG, "intercept: addHeader: " + entry.getKey() + "=" + entry.getValue());
        }
        Request newRequest = newBuilder.build();
        //响应
        Response response = chain.proceed(newRequest);
        return response;
    }
}
