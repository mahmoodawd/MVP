package com.example.mvp.network;


import com.example.mvp.model.productsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface API_Service {
    @GET("products")
    Single<productsResponse> getAllProducts();
}
