package com.example.mvp.favorites.presenter;


import android.util.Log;

import com.example.mvp.favorites.view.FavProductsViewInterface;
import com.example.mvp.model.Product;
import com.example.mvp.repositories.RepositoryInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FavProductsPresenter implements FavProductsPresenterInterface {
    private FavProductsViewInterface _view;
    private RepositoryInterface _repo;
    private String TAG = "FavProductsPresenter";

    public FavProductsPresenter(FavProductsViewInterface favProductsView, RepositoryInterface repo) {
        this._view = favProductsView;
        this._repo = repo;
    }

    @Override
    public void getFavoritesProducts() {
        _repo.getStoredProducts().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(favorites -> _view.displayProducts(favorites),
                        throwable -> Log.i(TAG, "GetRM: " + throwable.getMessage()));
    }

    @Override
    public void delProduct(Product product) {
        _repo.delete(product);
    }





}
