package com.louisgeek.myarch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.louisgeek.myarch.http.callback.StringCallback;
import com.louisgeek.myarch.http.okhttp.OkHttpManager;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OkHttpManager.post().url("http://baidu.com").tag(this).enqueue(new StringCallback() {
            @Override
            public void onSuccessUi(String result, int code) {

            }

            @Override
            public void onError(String msg, int code) {

            }
        });
        Log.i(TAG, "onCreate: enqueue end ============");

        OkHttpManager.post().url("http://baidu.com").tag(this).enqueue(new StringCallback() {
            @Override
            public void onSuccessUi(String result, int code) {

            }

            @Override
            public void onError(String msg, int code) {

            }
        });
        OkHttpManager.getInstance().addCommonHeader("testHeader", "testHeader");
        OkHttpManager.getInstance().addCommonHeader("testHeader2", "testHeader2");
        OkHttpManager.getInstance().addCommonParam("testParams", "testParams");
        OkHttpManager.getInstance().addCommonParam("testParams2", "testParams2");
        Log.i(TAG, "onCreate: enqueue end after addCommonHeader ============");

        OkHttpManager.post().url("http://baidu.com").tag(this).enqueue(new StringCallback() {
            @Override
            public void onSuccessUi(String result, int code) {

            }

            @Override
            public void onError(String msg, int code) {

            }
        });
        OkHttpManager.getInstance().addCommonHeader("testHeader_again", "testHeader_again");
        OkHttpManager.getInstance().addCommonHeader("testHeader2_again", "testHeader2_again");
        OkHttpManager.getInstance().addCommonParam("testParams_again", "testParams_again");
        OkHttpManager.getInstance().addCommonParam("testParams2_again", "testParams2_again");

        Log.i(TAG, "onCreate: enqueue end after addCommonHeader  Again ============");

        OkHttpManager.post().url("http://baidu.com").tag(this).enqueue(new StringCallback() {
            @Override
            public void onSuccessUi(String result, int code) {

            }

            @Override
            public void onError(String msg, int code) {

            }
        });

    }
}
