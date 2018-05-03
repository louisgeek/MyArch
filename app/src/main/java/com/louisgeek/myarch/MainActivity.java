package com.louisgeek.myarch;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.louisgeek.myarch.db.MyDatabase;
import com.louisgeek.myarch.http.callback.GsonCallback;
import com.louisgeek.myarch.http.callback.StringCallback;
import com.louisgeek.myarch.http.okhttp.OkHttpManager;
import com.louisgeek.myarch.image.ImageLoaderFactory;
import com.louisgeek.myarch.json.JsonParserFactory;
import com.louisgeek.myarch.model.bean.NewsBean;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Response response = OkHttpManager.get().url("").tag(this).execute();
            response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        OkHttpManager.post().url("").tag(this).enqueue(new StringCallback() {
            @Override
            public void onSuccessUi(String result, int code) {

            }

            @Override
            public void onError(String msg, int code) {

            }
        });

        OkHttpManager.post().url("").tag(this).enqueue(new GsonCallback<NewsBean>() {
            @Override
            public void onSuccessUi(NewsBean result, int code) {

            }

            @Override
            public void onError(String msg, int code) {

            }
        });
        OkHttpManager.post().url("").tag(this).enqueue(new GsonCallback<List<NewsBean>>() {
            @Override
            public void onSuccessUi(List<NewsBean> result, int code) {

            }

            @Override
            public void onError(String msg, int code) {

            }
        });
        OkHttpManager.post().url("").tag(this).enqueue(new GsonCallback<Map<String, NewsBean>>() {
            @Override
            public void onSuccessUi(Map<String, NewsBean> result, int code) {

            }

            @Override
            public void onError(String msg, int code) {

            }
        });

        Room.databaseBuilder(this, MyDatabase.class, "myDatabase").build();
    }
}
