package com.louisgeek.myarch.http.request;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BaseParamsHttpRequest<T> extends BaseHttpRequest<T> {
    protected Map<String, String> mParams;

    public T params(Map<String, String> params) {
        this.mParams = params;
        return (T) this;
    }

    public T addParam(String key, String value) {
        if (mParams == null) {
            mParams = new LinkedHashMap<>();
        }
        mParams.put(key, value);
        return (T) this;
    }
}
