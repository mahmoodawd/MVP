package com.example.mvp.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.mvp.db.ConcreteLocalSource;
import com.example.mvp.model.Product;
import com.example.mvp.model.productsResponse;
import com.example.mvp.network.RemoteSource;

import java.util.List;

import io.reactivex.Single;

public class Repository implements RepositoryInterface {
    private Context context;
    RemoteSource remoteSource;
    ConcreteLocalSource concreteLocalSource;
    private static Repository instance = null;


    private Repository(Context context, RemoteSource remoteSource, ConcreteLocalSource concreteLocalSource) {
        this.context = context;
        this.remoteSource = remoteSource;
        this.concreteLocalSource = concreteLocalSource;
    }

    public static Repository getInstance(Context context, RemoteSource remoteSource, ConcreteLocalSource concreteLocalSource) {
        if (instance == null) {
            instance = new Repository(context, remoteSource, concreteLocalSource);
        }
        return instance;
    }

    @Override
    public Single<productsResponse> getAllProducts() {
        return remoteSource.getAllProducts();
    }

    @Override
    public Single<List<Product>> getStoredProducts() {
        return concreteLocalSource.getStoredProducts();
    }


    @Override
    public void insert(Product product) {
        concreteLocalSource.insert(product);
    }


    @Override
    public void delete(Product product) {
        concreteLocalSource.delete(product);
    }
}
