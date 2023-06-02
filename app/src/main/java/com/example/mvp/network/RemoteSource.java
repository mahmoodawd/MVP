package com.example.mvp.network;

import com.example.mvp.model.productsResponse;

import io.reactivex.Single;

public interface RemoteSource {
    Single<productsResponse> getAllProducts();
}
