package com.louisgeek.myarch.api;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DoubanApi {
    @GET("/v2/movie/in_theaters")
    Observable<String> in_theaters();

    @GET("/v2/movie/coming_soon")
    Observable<String> coming_soon();

    @GET("/v2/movie/top250")
    Observable<String> top250();


}
