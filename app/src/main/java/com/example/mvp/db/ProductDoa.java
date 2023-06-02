package com.example.mvp.db;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mvp.model.Product;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface ProductDoa {
    @Query("SELECT * FROM product")
    Single<List<Product>> getFavorites();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Product products);

    @Delete
    void delete(Product product);


}
