package com.example.player_list_mvvm_retrofit.ViewModel;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.player_list_mvvm_retrofit.JsonParser.JsonParserActivity;
import com.example.player_list_mvvm_retrofit.Model.Player;
import com.example.player_list_mvvm_retrofit.Network.Retrofit;
import com.example.player_list_mvvm_retrofit.RecylerAdapter.RecyclerAdapter;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowPlayers extends ViewModel {
    private MutableLiveData<Player> playerMutableLiveData;
    ArrayAdapter arrayAdapter;
//private RecyclerView recyclerView;
//private RecyclerAdapter recyclerAdapter;
    JsonParserActivity jsonParserActivity;
    ArrayList<Player> playerArrayList;
    Context context;

    public ShowPlayers() {
        playerMutableLiveData = new MutableLiveData<>();
    }

    public LiveData<Player> getPlayerObject() {
        return playerMutableLiveData;
    }

    public void getData(RecyclerAdapter recyclerAdapter , RecyclerView recyclerView) {
//        Player player = new Player();
//        player.setName("Tamim");
//        player.setRole("Batsman");
//        playerMutableLiveData.setValue(player);
        FetchDataFromServer(recyclerAdapter, recyclerView);


    }

    public void FetchDataFromServer(RecyclerAdapter recyclerAdapter , RecyclerView recyclerView) {
//        Call<ResponseBody> call = Retrofit
//                .getInstance()
//                .getApi().data();
//
//
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    if (response.body() != null) {
//                        Log.d("debug", "test json -> " + response.body().toString());
//                    } else {
//                        Log.d("debug", "test json");
//                    }
//                } catch (Exception exception) {
//                    Log.d("debug", "Error -> " + exception);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.d("debug", "-------------json fail korse---------"+t.getMessage());
//            }
//        });

        jsonParserActivity = new JsonParserActivity(playerArrayList, context , recyclerView,recyclerAdapter);
        jsonParserActivity.execute();

    }
}
