package com.example.mvp.favorites.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvp.R;
import com.example.mvp.allproducts.view.OnFABClickListener;
import com.example.mvp.model.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class FavoritesProductsAdapter extends RecyclerView.Adapter<FavoritesProductsAdapter.ViewHolder> {
    private final Context context;
    private List<Product> products;
    private OnDelFABClickListener fabClickListener;
    private static final String TAG = "RecyclerView";

    public FavoritesProductsAdapter(Context context, List<Product> values, OnDelFABClickListener fabClickListener) {
        this.fabClickListener = fabClickListener;
        products = new ArrayList<>();
        this.context = context;
        this.products = values;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup recyclerView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
        View v = inflater.inflate(R.layout.favorite_product_layout, recyclerView, false);
        ViewHolder viewHolder = new ViewHolder(v);
        Log.i(TAG, "onCreateViewHolder");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Product product = products.get(position);
        holder.titleTxt.setText(product.getTitle());
        holder.productRating.setRating(product.getRating());
        Glide.with(context).load(product.getThumbnail()).into(holder.imageView);
        holder.delFromFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(context, "Removed to Favorites", Toast.LENGTH_SHORT).show();

                fabClickListener.onDelFABClickListener(product);


            }
        });

        Log.i(TAG, "onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setProductsList(List<Product> productList) {
        this.products = productList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTxt;
        public ImageView imageView;
        public RatingBar productRating;
        public FloatingActionButton delFromFav;
        public ConstraintLayout constraintLayout;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            titleTxt = v.findViewById(R.id.favProductTitle);
            productRating = v.findViewById(R.id.favProductRatingBar);
            imageView = v.findViewById(R.id.favProductImage);
            delFromFav = v.findViewById(R.id.deleteFAB);
            constraintLayout = v.findViewById(R.id.favProductsLayout);
        }
    }
}

