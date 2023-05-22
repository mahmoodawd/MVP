package com.example.mvp.favorites.presenter;


import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.mvp.favorites.view.FavProductsViewInterface;
import com.example.mvp.model.Product;
import com.example.mvp.model.RepositoryInterface;

import java.util.List;

public class FavProductsPresenter implements FavProductsPresenterInterface {
    private FavProductsViewInterface _view;
    private RepositoryInterface _repo;

    public FavProductsPresenter(FavProductsViewInterface favProductsView, RepositoryInterface repo) {
        this._view = favProductsView;
        this._repo = repo;
    }

    @Override
    public LiveData<List<Product>> getProducts() {
        return _repo.getStoredProducts();
    }

    @Override
    public void delProduct(Product product) {
        _repo.delete(product);
    }

    @Override
    public void informView(LifecycleOwner lifecycleOwner) {
        _repo.getStoredProducts().observe( lifecycleOwner, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                _view.displayProducts(products);
            }
        });
    }


}
