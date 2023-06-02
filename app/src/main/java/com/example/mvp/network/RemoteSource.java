package com.example.mvp.network;

import io.reactivex.Single;

public interface RemoteSource {
    Single<MyResponse> getAllProducts();
}
