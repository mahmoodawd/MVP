package com.example.mvp.network;


import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface API_Service {
    @GET("products")
    Single<MyResponse> getAllProducts();
}
