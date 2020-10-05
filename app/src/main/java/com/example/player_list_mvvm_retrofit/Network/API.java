package com.example.player_list_mvvm_retrofit.Network;

import androidx.annotation.NonNull;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;


public interface API {

    @NonNull
    @GET(".")
    Call<ResponseBody>data();
}
