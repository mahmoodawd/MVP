package com.example.mvp.allproducts.presenter;


import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.nfc.Tag;
import android.util.Log;

import com.example.mvp.allproducts.view.AllProductsFragment;
import com.example.mvp.allproducts.view.AllProductsViewInterface;
import com.example.mvp.model.Product;
import com.example.mvp.model.Repository;
import com.example.mvp.model.RepositoryInterface;
import com.example.mvp.network.NetworkDelegate;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AllProductsPresenter implements AllProductsPresenterInterface, NetworkDelegate {
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

    @Override
    public void onSuccess(List<Product> productList) {
        _view.displayProducts(productList);
    }

    @Override
    public void onFailure(Throwable t) {

    }
}
