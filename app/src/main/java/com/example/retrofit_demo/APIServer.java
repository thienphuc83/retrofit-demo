package com.example.retrofit_demo;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

// Cấu hình retrofit
public interface APIServer {

    APIServer apiServer = new Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIServer.class);

    // hàm call api - link api ở đây đang là phương thức GET
    @GET("movie/550")
    Call<Example> getExample(@Query("api_key") String api_key);
}
