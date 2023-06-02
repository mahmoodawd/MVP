package com.example.mvp.db;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.mvp.model.Product;

import java.util.List;

import io.reactivex.Single;

public class ConcreteLocalSource implements LocalSource {
    private Context context;
    ProductDoa productDoa;
    LiveData<List<Product>> storedProducts;
    LiveData<List<Product>> targetProduct;
    private static ConcreteLocalSource instance = null;


    private ConcreteLocalSource(Context context) {
        this.context = context;
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
    public LiveData<List<Product>> searchProduct(String productName) {
        return targetProduct;
    }

    @Override
    public void insert(Product product) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                productDoa.insertAll(product);
            }
        }).start();
    }

    @Override
    public void delete(Product product) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                productDoa.delete(product);
            }
        }).start();
    }


}
