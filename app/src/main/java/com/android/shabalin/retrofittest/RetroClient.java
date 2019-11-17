package com.android.shabalin.retrofittest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {

    private static final String ROOT_URL = "http://www.omdbapi.com";

    private static Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static ApiService getApiService(){
        return getRetrofitInstance().create(ApiService.class);
    }
}
