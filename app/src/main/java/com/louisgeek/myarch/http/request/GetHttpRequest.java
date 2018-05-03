package com.louisgeek.myarch.http.request;

import android.text.TextUtils;

import okhttp3.Headers;
import okhttp3.Request;

public class GetHttpRequest extends BaseParamsHttpRequest<GetHttpRequest> {

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
        return builder.build();
    }
}
