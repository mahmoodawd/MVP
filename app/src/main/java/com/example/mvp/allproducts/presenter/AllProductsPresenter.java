package com.example.mvp.allproducts.presenter;


import android.util.Log;

import com.example.mvp.allproducts.view.AllProductsViewInterface;
import com.example.mvp.model.Product;
import com.example.mvp.repositories.RepositoryInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AllProductsPresenter implements AllProductsPresenterInterface {
    private AllProductsViewInterface _view;
    private RepositoryInterface _repo;
    private String TAG = "AllProductsPresenter";

    public AllProductsPresenter(AllProductsViewInterface allProductsView, RepositoryInterface repo) {
        this._view = allProductsView;
        this._repo = repo;
    }

    @Override
    public void getProducts() {
        _repo.getAllProducts().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(myResponse -> _view.displayProducts(myResponse.getProductList()),
                        throwable -> Log.i(TAG, "GetRM: " + throwable.getMessage()));


    }

    @Override
    public void addProduct(Product product) {
        _repo.insert(product);
    }

}
