package com.example.mvp.model;

import androidx.annotation.NonNull;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {
    @NonNull
    @PrimaryKey
    private String id;
    @ColumnInfo(name = "TITLE")
    private String title;
    @ColumnInfo(name = "DESCRIPTION")
    private String description;
    @ColumnInfo(name = "PRICE")
    private float price;
    @ColumnInfo(name = "RATING")
    private float rating;
    @ColumnInfo(name = "BRAND")
    private String brand;
    @ColumnInfo(name = "THUMBNAIL")
    private String thumbnail;



    public Product(String id, String title, String description, float price, float rating, String brand, String thumbnail) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.brand = brand;
        this.thumbnail = thumbnail;
    }

    public Product(String title, String description, float price, float rating, String brand, String imageUrl) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.brand = brand;
        this.thumbnail = imageUrl;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public float getRating() {
        return rating;
    }

    public String getBrand() {
        return brand;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
