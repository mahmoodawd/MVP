package com.example.mvp.allproducts.presenter;


import com.example.mvp.allproducts.view.AllProductsFragment;
import com.example.mvp.allproducts.view.AllProductsViewInterface;
import com.example.mvp.model.Product;
import com.example.mvp.model.Repository;
import com.example.mvp.model.RepositoryInterface;
import com.example.mvp.network.NetworkDelegate;

import java.util.List;

public class AllProductsPresenter implements AllProductsPresenterInterface, NetworkDelegate {
    private AllProductsViewInterface _view;
    private RepositoryInterface _repo;

    public AllProductsPresenter(AllProductsViewInterface allProductsView, RepositoryInterface repo) {
        this._view = allProductsView;
        this._repo = repo;
    }

    @Override
    public void getProducts() {
        _repo.getAllProducts(this);
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
