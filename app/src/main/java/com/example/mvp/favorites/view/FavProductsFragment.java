package com.example.mvp.favorites.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp.R;
import com.example.mvp.db.ConcreteLocalSource;
import com.example.mvp.favorites.presenter.FavProductsPresenter;
import com.example.mvp.model.Product;
import com.example.mvp.repositories.Repository;
import com.example.mvp.network.API_Client;

import java.util.ArrayList;
import java.util.List;


public class FavProductsFragment extends Fragment implements FavProductsViewInterface, OnDelFABClickListener {
    RecyclerView allProductsRecyclerView;
    FavoritesProductsAdapter productsAdapter;
    FavProductsPresenter productsPresenter;


    public FavProductsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_products, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
    }

    private void initUI(@NonNull View view) {
        allProductsRecyclerView = view.findViewById(R.id.allProductsRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        productsAdapter = new FavoritesProductsAdapter(getContext(), new ArrayList<>(), this);
        productsPresenter = new FavProductsPresenter(this,
                Repository.getInstance(this.getContext(), API_Client.getInstance(), ConcreteLocalSource.getInstance(this.getContext())));
        allProductsRecyclerView.setHasFixedSize(true);
        allProductsRecyclerView.setLayoutManager(layoutManager);
        allProductsRecyclerView.setAdapter(productsAdapter);
        productsPresenter.getFavoritesProducts();
    }


    @Override
    public void onDelFABClickListener(Product product) {
        delFromFavorites(product);
        productsAdapter.notifyDataSetChanged();


    }

    @Override
    public void displayProducts(List<Product> products) {
        productsAdapter.setProductsList(products);
        productsAdapter.notifyDataSetChanged();
    }

    @Override
    public void delFromFavorites(Product product) {
        productsPresenter.delProduct(product);
    }
}