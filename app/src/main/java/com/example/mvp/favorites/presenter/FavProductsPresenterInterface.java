package com.example.mvp.favorites.presenter;

import androidx.lifecycle.LifecycleOwner;

import com.example.mvp.model.Product;

public interface FavProductsPresenterInterface {
    void getFavoritesProducts();
    void delProduct(Product product);

}
