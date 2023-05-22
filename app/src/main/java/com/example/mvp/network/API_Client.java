package com.example.mvp.network;

import android.util.Log;

import com.example.mvp.model.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class API_Client implements RemoteSource {
    private static final String BASE_URL = "https://dummyjson.com/";
    private static final String TAG = "API_Client";
private static API_Client instance = null;
    private API_Client() {

    }
    public static API_Client getInstance(){
        if(instance == null){
            instance = new API_Client();
        }
        return instance;
    }

    @Override
    public void startCall(NetworkDelegate callback) {
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        API_Service apiService = retrofit.create(API_Service.class);
        Call<MyResponse> products = apiService.getAllProducts();
        products.enqueue(new retrofit2.Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                Log.i(TAG, "onResponse");
                Log.i(TAG, String.valueOf(response.body().getTotal()));
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body().getProductList());

                }
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {
                Log.i(TAG, "onFailure");
                Log.e(TAG, t.getMessage());
                t.printStackTrace();
                callback.onFailure(t);
            }
        });
    }
}