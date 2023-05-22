package com.example.mvp.network;


import retrofit2.Call;
import retrofit2.http.GET;

public interface API_Service {
    @GET("products")
    Call<MyResponse> getAllProducts();
}
