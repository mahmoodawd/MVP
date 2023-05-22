package com.example.mvp.db;

import androidx.lifecycle.LiveData;

import com.example.mvp.model.Product;

import java.util.List;

public interface LocalSource {
    LiveData<List<Product>> getStoredProducts();

    LiveData<List<Product>> searchProduct(String productName);

    void insert(Product product);

    void delete(Product product);
}
