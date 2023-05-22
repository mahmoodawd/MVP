package com.example.mvp.network;

import com.example.mvp.model.Product;

import java.util.List;

public class MyResponse {
    private int total;
    private int skip;
    private int limit;
    private List<Product> products;

    public MyResponse(int total, int skip, int limit, List<Product> products) {
        this.total = total;
        this.skip = skip;
        this.limit = limit;
        this.products = products;
    }

    public int getTotal() {
        return total;
    }

    public int getSkip() {
        return skip;
    }

    public int getLimit() {
        return limit;
    }

    public List<Product> getProductList() {
        return products;
    }
}
