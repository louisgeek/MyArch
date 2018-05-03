package com.louisgeek.myarch.http.okhttp;

import android.util.Log;

import com.louisgeek.myarch.http.HttpConstant;
import com.louisgeek.myarch.http.okhttp.Interceptors.HttpHeadersInterceptor;
import com.louisgeek.myarch.http.okhttp.Interceptors.HttpParamsInterceptor;
import com.louisgeek.myarch.http.request.GetHttpRequest;
import com.louisgeek.myarch.http.request.PostHttpRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpManager {
    private static final String TAG = "OkHttpManager";
    private OkHttpClient mOkHttpClient;
    //OkHttp的是否单例影响着CookieJar的工作
    private CookieJar mMyCookieJar = new CookieJar() {
        private Map<String, List<Cookie>> mCookiesMap = new LinkedHashMap<>();

        @Override
        public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
            Log.d("zfq", "OkHttpManager saveFromResponse:url " + url);
            mCookiesMap.put(url.host(), cookies);
            if (cookies != null && !cookies.isEmpty()) {
                for (Cookie cookie : cookies) {
                    Log.d("zfq", "OkHttpManager saveFromResponse:cookie: " + cookie.value());
                }
            }
        }

        @Override
        public List<Cookie> loadForRequest(HttpUrl url) {
            Log.d("zfq", "OkHttpManager loadForRequest:url " + url);
            List<Cookie> cookies = mCookiesMap.get(url.host());
            if (cookies != null && !cookies.isEmpty()) {
                for (Cookie cookie : cookies) {
                    Log.d("zfq", "OkHttpManager saveFromResponse:cookie " + cookie.value());
                }
            }
            return cookies != null ? cookies : new ArrayList<Cookie>();
        }
    };
    private Map<String, String> mCommonHeaderMap = new LinkedHashMap<>();
    private Map<String, String> mCommonParamsMap = new LinkedHashMap<>();

    private OkHttpManager() {
        //log
        HttpLoggingInterceptor httpLoggingInterceptor =
                new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        //CLog.i(message);
                        Log.d(TAG, "HttpLogging: " + message);
                    }
                });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //common headers
        HttpHeadersInterceptor httpHeadersInterceptor =
                new HttpHeadersInterceptor(mCommonHeaderMap);
        //common params
        HttpParamsInterceptor httpParamsInterceptor =
                new HttpParamsInterceptor(mCommonParamsMap);
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(HttpConstant.CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .readTimeout(HttpConstant.READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .writeTimeout(HttpConstant.WRITE_TIME_OUT, TimeUnit.MILLISECONDS)
                //失败重连
//                .retryOnConnectionFailure(true)
                //日志
                .addNetworkInterceptor(httpLoggingInterceptor)
                .addInterceptor(httpLoggingInterceptor)
                //headers
                .addNetworkInterceptor(httpHeadersInterceptor)
                .addInterceptor(httpHeadersInterceptor)
                //params
                .addNetworkInterceptor(httpParamsInterceptor)
                .addInterceptor(httpParamsInterceptor)
                // .addInterceptor(httpCookiesInterceptor)
                .cookieJar(mMyCookieJar)
                .build();
    }

    public static OkHttpManager getInstance() {
        return Inner.sInstance;
    }

    private static class Inner {
        private static OkHttpManager sInstance = new OkHttpManager();
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }

    public void setOkHttpClient(OkHttpClient okHttpClient) {
        this.mOkHttpClient = okHttpClient;
    }

    public void addCommonHeaders(Map<String, String> commonHeaderMap) {
        this.mCommonHeaderMap.putAll(commonHeaderMap);
    }

    public void addCommonHeader(String key, String value) {
        this.mCommonHeaderMap.put(key, value);
    }

    public void addCommonParam(String key, String value) {
        this.mCommonParamsMap.put(key, value);
    }

    public void addCommonParams(Map<String, String> commonParamMap) {
        this.mCommonParamsMap.putAll(commonParamMap);
    }


    public static GetHttpRequest get() {
        return new GetHttpRequest();
    }

    public static PostHttpRequest post() {
        return new PostHttpRequest();
    }


    /**
     * 通过 Tag 取消请求
     */
    public void cancel(Object tag) {
        if (mOkHttpClient == null || tag == null) {
            return;
        }
        for (Call call : mOkHttpClient.dispatcher().queuedCalls()) {
            if (tag.equals(call.request().tag())) {
                call.cancel();
            }
        }
        for (Call call : mOkHttpClient.dispatcher().runningCalls()) {
            if (tag.equals(call.request().tag())) {
                call.cancel();
            }
        }
    }

    /**
     * 取消所有请求请求
     */
    public void cancelAll() {
        if (mOkHttpClient == null) {
            return;
        }
        for (Call call : mOkHttpClient.dispatcher().queuedCalls()) {
            call.cancel();
        }
        for (Call call : mOkHttpClient.dispatcher().runningCalls()) {
            call.cancel();
        }
    }
}
