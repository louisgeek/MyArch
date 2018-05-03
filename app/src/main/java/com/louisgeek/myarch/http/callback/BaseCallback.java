package com.louisgeek.myarch.http.callback;

import com.louisgeek.myarch.http.HttpConstant;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;

public abstract class BaseCallback<T> implements Callback {
    public void onSuccess(T result, int code) {

    }

    public void onFinish() {
    }

    public abstract void onSuccessUi(T result, int code);

    public abstract void onError(String msg, int code);

    @Override
    public void onFailure(Call call, IOException e) {
        if (call.isCanceled()) {
            this.onError("GsonOkHttpCallback call is canceled,call:" + call.toString()
                    + ";message:" + e.getMessage(), HttpConstant.CALL_CANCEL);
        } else {
            this.onError(e.getMessage(), HttpConstant.CALL_ERROR);
        }
        //
        this.onFinish();
    }
}
