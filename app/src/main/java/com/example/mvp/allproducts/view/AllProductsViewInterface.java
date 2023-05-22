package com.example.mvp.allproducts.view;

import com.example.mvp.model.Product;

import java.util.List;

public interface AllProductsViewInterface {
    void displayProducts(List<Product> productList);
    void addToFavorites(Product product);
}
