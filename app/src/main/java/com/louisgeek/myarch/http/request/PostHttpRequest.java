package com.louisgeek.myarch.http.request;

import android.text.TextUtils;


import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Request;

public class PostHttpRequest extends BaseParamsHttpRequest<PostHttpRequest> {
    @Override
    Request buildRequest() {
        Request.Builder builder = new Request.Builder();
        if (TextUtils.isEmpty(mUrl)) {
            throw new IllegalArgumentException("url can not be empty!");
        }
        builder.url(mUrl);
        if (mTag != null) {
            builder.tag(mTag);
        }
        if (mHeaders != null && !mHeaders.isEmpty()) {
            builder.headers(Headers.of(mHeaders));
        }
        if (mParams != null && !mParams.isEmpty()) {
            FormBody.Builder paramBuilder = new FormBody.Builder();
            for (Map.Entry<String, String> entry : mParams.entrySet()) {
                paramBuilder.add(entry.getKey(), entry.getValue());
            }
            FormBody paramsBody = paramBuilder.build();
            builder.post(paramsBody);
        }
        return builder.build();
    }
}
