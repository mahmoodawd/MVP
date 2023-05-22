package com.example.mvp.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mvp.model.Product;

@Database(entities = {Product.class}, version = 1)
public abstract class FavoritesDB extends RoomDatabase {
    private static FavoritesDB instance = null;

    public abstract ProductDoa productDoa();

    public static synchronized FavoritesDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    FavoritesDB.class, "favorites-db").build();
        }

        return instance;
    }
}
