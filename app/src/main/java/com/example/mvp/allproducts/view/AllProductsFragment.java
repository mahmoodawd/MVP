package com.example.mvp.allproducts.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp.R;
import com.example.mvp.allproducts.presenter.AllProductsPresenter;
import com.example.mvp.db.ConcreteLocalSource;
import com.example.mvp.model.Product;
import com.example.mvp.model.Repository;
import com.example.mvp.network.API_Client;

import java.util.ArrayList;
import java.util.List;


public class AllProductsFragment extends Fragment implements AllProductsViewInterface, OnFABClickListener {
    RecyclerView allProductsRecyclerView;
    AllProductsAdapter allProductsAdapter;
    AllProductsPresenter allProductsPresenter;


    public AllProductsFragment() {

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
        allProductsRecyclerView = view.findViewById(R.id.allProductsRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        allProductsAdapter = new AllProductsAdapter(getContext(), new ArrayList<>(), this);
        allProductsPresenter = new AllProductsPresenter(this,
                Repository.getInstance(this.getContext(), API_Client.getInstance(), ConcreteLocalSource.getInstance(this.getContext())));
        allProductsRecyclerView.setHasFixedSize(true);
        allProductsRecyclerView.setLayoutManager(layoutManager);
        allProductsRecyclerView.setAdapter(allProductsAdapter);
        allProductsPresenter.getProducts();

    }


    @Override
    public void onFABClickListener(Product product) {
        addToFavorites(product);


    }

    @Override
    public void displayProducts(List<Product> productList) {
        allProductsAdapter.setProductsList(productList);
        allProductsAdapter.notifyDataSetChanged();
    }

    @Override
    public void addToFavorites(Product product) {
        allProductsPresenter.addProduct(product);
    }
}