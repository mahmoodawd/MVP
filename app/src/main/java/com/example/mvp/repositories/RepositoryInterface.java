package com.example.mvp.repositories;

import androidx.lifecycle.LiveData;

import com.example.mvp.model.Product;
import com.example.mvp.model.productsResponse;

import java.util.List;

import io.reactivex.Single;

public interface RepositoryInterface {
    Single<productsResponse> getAllProducts();

    Single<List<Product>> getStoredProducts();

    void insert(Product product);

    void delete(Product product);
}
