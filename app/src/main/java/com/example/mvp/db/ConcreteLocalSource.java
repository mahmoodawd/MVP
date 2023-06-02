package com.example.mvp.db;

import android.content.Context;


import com.example.mvp.model.Product;

import java.util.List;

import io.reactivex.Single;

public class ConcreteLocalSource implements LocalSource {
    ProductDoa productDoa;
    private static ConcreteLocalSource instance = null;


    private ConcreteLocalSource(Context context) {
        FavoritesDB db = FavoritesDB.getInstance(context.getApplicationContext());
        productDoa = db.productDoa();
    }

    public static ConcreteLocalSource getInstance(Context context) {
        if (instance == null) {
            instance = new ConcreteLocalSource(context);
        }
        return instance;
    }

    @Override
    public Single<List<Product>> getStoredProducts() {
        return productDoa.getFavorites();
    }


    @Override
    public void insert(Product product) {
        new Thread(() -> productDoa.insertAll(product)).start();
    }

    @Override
    public void delete(Product product) {

        new Thread(() -> productDoa.delete(product)).start();
    }


}
