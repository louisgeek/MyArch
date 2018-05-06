package com.louisgeek.myarch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.fastjson.TypeReference;
import com.google.gson.reflect.TypeToken;
import com.louisgeek.myarch.http.callback.GsonCallback;
import com.louisgeek.myarch.http.callback.StringCallback;
import com.louisgeek.myarch.http.okhttp.OkHttpManager;
import com.louisgeek.myarch.json.BaseJsonParserFactory;
import com.louisgeek.myarch.json.JsonParserFactory;
import com.louisgeek.myarch.json.base.BaseJson;
import com.louisgeek.myarch.model.bean.NewsBean;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NewsBean newsBean = new NewsBean();
        newsBean.newsID = 1;
        newsBean.title = "懂";
        newsBean.content = "厕所";
        String json = JsonParserFactory.getFastJson().toJson(newsBean);
        Log.d(TAG, "onCreate: json:" + json);
        NewsBean tx1 = JsonParserFactory.getFastJson().fromJson(json, NewsBean.class);
        Log.d(TAG, "onCreate: tx1:" + tx1);
        Type type = new TypeReference<NewsBean>() {
        }.getType();
        NewsBean tx2 = JsonParserFactory.getFastJson().fromJson(json, type);
        Log.d(TAG, "onCreate: tx2:" + tx2);
        //
        String json2 = JsonParserFactory.getGson().toJson(newsBean);
        Log.d(TAG, "onCreate: json2:" + json2);
        NewsBean nb = JsonParserFactory.getGson().fromJson(json2, NewsBean.class);
        Log.d(TAG, "onCreate: nb:" + nb);
        Type type2 = new TypeToken<NewsBean>() {
        }.getType();
        NewsBean nb2 = JsonParserFactory.getGson().fromJson(json2, type2);
        Log.d(TAG, "onCreate: nb2:" + nb2);



        BaseJson<NewsBean> beanBaseJson=new BaseJson<>();
        beanBaseJson.setCode(11);
        beanBaseJson.setData(newsBean);
        beanBaseJson.setMsg("中国");
        String json3 = BaseJsonParserFactory.getFastJson().toJson(beanBaseJson);
        Log.d(TAG, "onCreate: json3:" + json3);
        BaseJson<NewsBean> tx3 = BaseJsonParserFactory.getFastJson().fromJson(json3, NewsBean.class);
        Log.d(TAG, "onCreate: tx3:" + tx3);
        Type type3 = new TypeReference<NewsBean>() {
        }.getType();
        BaseJson<NewsBean> tx4 = BaseJsonParserFactory.getFastJson().fromJson(json3, type3);
        Log.d(TAG, "onCreate: tx4:" + tx4);
        //
        String json4 = BaseJsonParserFactory.getGson().toJson(beanBaseJson);
        Log.d(TAG, "onCreate: json4:" + json4);
        BaseJson<NewsBean> nb4 = BaseJsonParserFactory.getGson().fromJson(json4, NewsBean.class);
        Log.d(TAG, "onCreate: nb4:" + nb4);
        Type type4 = new TypeToken<NewsBean>() {
        }.getType();
        BaseJson<NewsBean> nb5 = BaseJsonParserFactory.getGson().fromJson(json4, type4);
        Log.d(TAG, "onCreate: nb5:" + nb5);
        BaseJson<List<NewsBean>> beanBaseJsonList=new BaseJson<>();
        List<NewsBean> newsBeanList = new ArrayList<>();
        for (int i = 0; i <6 ; i++) {
            newsBean.newsID = 1+i;
            newsBean.title = "懂"+i;
            newsBean.content = "厕所"+i;
            newsBeanList.add(newsBean);
        }
        beanBaseJsonList.setData(newsBeanList);
        beanBaseJsonList.setMsg("dsd");
        beanBaseJsonList.setCode(22);
        String json5 = BaseJsonParserFactory.getGson().toJson(beanBaseJsonList);
        Log.d(TAG, "onCreate: json5:" + json5);
        BaseJson<List<NewsBean>> nb55 = BaseJsonParserFactory.getFastJson().fromJson(json5, NewsBean.class);
        Log.d(TAG, "onCreate: nb55:" + nb55);

        BaseJson<List<NewsBean>> nb6 = BaseJsonParserFactory.getGson().fromJson(json5, NewsBean.class);
        Log.d(TAG, "onCreate: nb6:" + nb6);

/*

        OkHttpManager.post().tag(this)
                .url("http://www.wanandroid.com/tools/mockapi/1914/test_api_empty")
                .enqueue(new StringCallback() {
                    @Override
                    public void onSuccessUi(String result, int code) {
                        Log.d(TAG, "onSuccessUi: result:" + result);
                    }

                    @Override
                    public void onError(String msg, int code) {
                        Log.d(TAG, "onError: code:" + msg);
                    }
                });

        OkHttpManager.post().tag(this)
                .url("http://www.wanandroid.com/tools/mockapi/1914/test_api_empty")
                .enqueue(new GsonCallback<BaseJson>() {

                    @Override
                    public void onSuccessUi(BaseJson result, int code) {
                        Log.d(TAG, "onSuccessUi: result:" + result);
                    }

                    @Override
                    public void onError(String msg, int code) {
                        Log.d(TAG, "onError: code:" + msg);
                    }
                });


        OkHttpManager.post().tag(this)
                .url("http://www.wanandroid.com/tools/mockapi/1914/test_api_null")
                .enqueue(new GsonCallback<BaseJson>() {

                    @Override
                    public void onSuccessUi(BaseJson result, int code) {
                        Log.d(TAG, "onSuccessUi: result:" + result);
                    }

                    @Override
                    public void onError(String msg, int code) {
                        Log.d(TAG, "onError: code:" + msg);
                    }
                });

        OkHttpManager.post().tag(this)
                .url("http://www.wanandroid.com/tools/mockapi/1914/test_api_comm")
                .enqueue(new GsonCallback<BaseJson>() {

                    @Override
                    public void onSuccessUi(BaseJson result, int code) {
                        Log.d(TAG, "onSuccessUi: result:" + result);
                    }

                    @Override
                    public void onError(String msg, int code) {
                        Log.d(TAG, "onError: code:" + msg);
                    }
                });
*/

    }
}
