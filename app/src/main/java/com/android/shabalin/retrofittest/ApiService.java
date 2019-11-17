package com.android.shabalin.retrofittest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/?s=spider&apikey=7936df86")
    Call<Pojo> getMyJSON();
}
