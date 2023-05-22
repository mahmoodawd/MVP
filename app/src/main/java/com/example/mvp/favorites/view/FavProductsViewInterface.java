package com.example.mvp.favorites.view;

import com.example.mvp.model.Product;

import java.util.List;

public interface FavProductsViewInterface {
    void displayProducts(List<Product> products);
    void delFromFavorites(Product product);
}
