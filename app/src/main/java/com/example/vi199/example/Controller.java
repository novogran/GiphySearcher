package com.example.vi199.example;


import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class Controller extends Application {

    private static GiphyApiTrending giphyApiTrending;
    private static GiphyApiSearch giphyApiSearch;

    @Override
    public void onCreate() {
        super.onCreate();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.giphy.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        giphyApiTrending = retrofit.create(GiphyApiTrending.class);
        giphyApiSearch = retrofit.create(GiphyApiSearch.class);

    }

    public static GiphyApiTrending getTrendingApi() {
        return giphyApiTrending;
    }

    public static GiphyApiSearch getSearchApi(){
        return giphyApiSearch;
    }
}
