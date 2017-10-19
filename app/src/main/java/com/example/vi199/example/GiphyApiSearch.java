package com.example.vi199.example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface GiphyApiSearch {

    @GET("/v1/gifs/search")
    Call<GifData> getModel(@Query("q") String resourceName,@Query("api_key") String apiKey);
}
