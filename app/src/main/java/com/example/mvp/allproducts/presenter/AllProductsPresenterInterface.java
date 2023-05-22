package com.example.mvp.allproducts.presenter;

import com.example.mvp.model.Product;

public interface AllProductsPresenterInterface {
    void getProducts();
    void addProduct(Product product);
}
