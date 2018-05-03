package com.louisgeek.myarch.http.callback;


import com.louisgeek.myarch.tool.ThreadTool;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public abstract class StringCallback extends BaseCallback<String> {
    @Override
    public void onResponse(Call call, final Response response) throws IOException {
        if (response.isSuccessful()) {
            final String result = response.toString();
            this.onSuccess(result, response.code());
            //主线程
            ThreadTool.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    onSuccessUi(result, response.code());
                }
            });
        } else {
            this.onError(response.message(), response.code());
        }
        //
        this.onFinish();
    }
}
