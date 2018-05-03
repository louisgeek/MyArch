package com.louisgeek.myarch.http.okhttp;

import android.text.TextUtils;
import android.util.Log;

import com.louisgeek.myarch.http.okhttp.Interceptors.HttpCookiesInterceptor;
import com.louisgeek.myarch.http.okhttp.Interceptors.HttpHeadersInterceptor;
import com.louisgeek.myarch.http.request.GetHttpRequest;
import com.louisgeek.myarch.http.request.PostHttpRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpManager {
    private static final String TAG = "OkHttpManager";
    private OkHttpClient mOkHttpClient;
    //OkHttp的是否单例影响着CookieJar的工作
    private CookieJar mMyCookieJar = new CookieJar() {
        private Map<String, List<Cookie>> cookiesMap = new HashMap<>();

        @Override
        public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
            Log.i("zfq", "OkHttpManager saveFromResponse " + url);
            cookiesMap.put(url.host(), cookies);
            if (cookies != null && !cookies.isEmpty()) {
                for (Cookie cookie : cookies) {
                    Log.i("zfq", "OkHttpManager saveFromResponse: " + cookie.value());
                }
            }
        }

        @Override
        public List<Cookie> loadForRequest(HttpUrl url) {
            Log.i("zfq", "OkHttpManager loadForRequest " + url);
            List<Cookie> cookies = cookiesMap.get(url.host());
            if (cookies != null && !cookies.isEmpty()) {
                for (Cookie cookie : cookies) {
                    Log.i("zfq", "OkHttpManager saveFromResponse: " + cookie.value());
                }
            }
            return cookies != null ? cookies : new ArrayList<Cookie>();
        }
    };
    private OkHttpManager() {
        HttpLoggingInterceptor httpLoggingInterceptor =
                new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        //CLog.i(message);
                        Log.i(TAG, "HttpLogging: " + message);
                    }
                });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //
//        HttpHeadersInterceptor httpHeadersInterceptor = new HttpHeadersInterceptor(mHeaderMap);
        //
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10_000, TimeUnit.MILLISECONDS)
                .readTimeout(10_000, TimeUnit.MILLISECONDS)
                .writeTimeout(10_000, TimeUnit.MILLISECONDS)
                //失败重连
//                .retryOnConnectionFailure(true)
                //日志
                .addNetworkInterceptor(httpLoggingInterceptor)
                .addInterceptor(httpLoggingInterceptor)
                //
//                .addNetworkInterceptor(httpHeadersInterceptor)
//                .addInterceptor(httpHeadersInterceptor)
                //
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
    public static GetHttpRequest get() {
        return new GetHttpRequest();
    }
    public static PostHttpRequest post() {
        return new PostHttpRequest();
    }
}
