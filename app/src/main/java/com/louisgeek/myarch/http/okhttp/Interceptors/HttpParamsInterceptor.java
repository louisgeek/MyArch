package com.louisgeek.myarch.http.okhttp.Interceptors;

import android.util.Log;

import java.io.IOException;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by louisgeek on 2017/6/5.
 */

public class HttpParamsInterceptor implements Interceptor {
    private static final String TAG = "HttpParamsInterceptor";

    public HttpParamsInterceptor(Map<String, String> commonParamsMap) {
        this.mCommonParamsMap = commonParamsMap;
    }

    private Map<String, String> mCommonParamsMap;

    @Override
    public Response intercept(Chain chain) throws IOException {
        //请求
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        if (mCommonParamsMap != null && !mCommonParamsMap.isEmpty()) {
            FormBody.Builder paramBuilder = new FormBody.Builder();
            for (Map.Entry<String, String> entry : mCommonParamsMap.entrySet()) {
                paramBuilder.add(entry.getKey(), entry.getValue());
                Log.i(TAG, "intercept: addParam: " + entry.getKey() + "=" + entry.getValue());

            }
            FormBody paramsBody = paramBuilder.build();
            newBuilder.post(paramsBody);
        }
        Request newRequest = newBuilder.build();
        //响应
        Response response = chain.proceed(newRequest);
        return response;
    }
}
