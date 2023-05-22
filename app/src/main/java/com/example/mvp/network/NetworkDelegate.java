package com.example.mvp.network;

import com.example.mvp.model.Product;

import java.util.List;

public interface NetworkDelegate {
    void onSuccess(List<Product> productList);

    void onFailure(Throwable t);
}
