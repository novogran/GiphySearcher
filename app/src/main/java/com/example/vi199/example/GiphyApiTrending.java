package com.example.vi199.example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


interface GiphyApiTrending {

    @GET("/v1/gifs/trending")
    Call<GifData> getModel(@Query("api_key") String apiKey);
}
