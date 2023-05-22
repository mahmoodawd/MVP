package com.example.mvp.favorites.presenter;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.mvp.model.Product;

import java.util.List;

public interface FavProductsPresenterInterface {
    LiveData<List<Product>> getProducts();
    void delProduct(Product product);
    void informView(LifecycleOwner lifecycleOwner);

}
