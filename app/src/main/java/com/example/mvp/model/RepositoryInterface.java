package com.example.mvp.model;

import androidx.lifecycle.LiveData;

import com.example.mvp.network.MyResponse;
import com.example.mvp.network.NetworkDelegate;

import java.util.List;

import io.reactivex.Single;

public interface RepositoryInterface {
    Single<MyResponse> getAllProducts();

    Single<List<Product>> getStoredProducts();

    LiveData<List<Product>> searchProduct(String productName);

    void insert(Product product);

    void delete(Product product);
}
