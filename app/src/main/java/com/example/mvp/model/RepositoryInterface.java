package com.example.mvp.model;

import androidx.lifecycle.LiveData;

import com.example.mvp.network.NetworkDelegate;

import java.util.List;

public interface RepositoryInterface {
    void getAllProducts(NetworkDelegate networkDelegate);

    LiveData<List<Product>> getStoredProducts();

    LiveData<List<Product>> searchProduct(String productName);

    void insert(Product product);

    void delete(Product product);
}
