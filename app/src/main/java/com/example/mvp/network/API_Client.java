package com.example.mvp.network;

import com.example.mvp.model.productsResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class API_Client implements RemoteSource {
    private static final String BASE_URL = "https://dummyjson.com/";
    private static final String TAG = "API_Client";
    private static API_Client instance = null;
    API_Service apiService;

    private API_Client() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
        apiService = retrofit.create(API_Service.class);
    }

    public static API_Client getInstance() {
        if (instance == null) {
            instance = new API_Client();
        }
        return instance;
    }


    @Override
    public Single<productsResponse> getAllProducts() {
        return apiService.getAllProducts();
    }
}