package com.example.player_list_mvvm_retrofit.Network;

import androidx.annotation.NonNull;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {

    private static  final String BASE_URL = "https://tridivroy.xyz/test.json/";

    private static Retrofit mInstance;

    private retrofit2.Retrofit retrofit;

    private Retrofit() {
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @NonNull
    public static synchronized Retrofit getInstance(){
        if(mInstance == null){
            mInstance = new Retrofit();
        }
        return mInstance;
    }

    public API getApi(){
        return retrofit.create(API.class);
    }
}
