package com.example.player_list_mvvm_retrofit.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.player_list_mvvm_retrofit.Network.Retrofit;
import com.example.player_list_mvvm_retrofit.R;
import com.example.player_list_mvvm_retrofit.Model.Player;
import com.example.player_list_mvvm_retrofit.RecylerAdapter.RecyclerAdapter;
import com.example.player_list_mvvm_retrofit.ViewModel.ShowPlayers;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button fetch;
    ShowPlayers model;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fetch = findViewById(R.id.fet);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);


        // Get the ViewModel.
        model = ViewModelProviders.of(this).get(ShowPlayers.class);

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.getPlayerObject().observe(this, nameObserver);

        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.getData(recyclerAdapter,recyclerView);
            }
        });

    }

    // Create the observer which updates the UI.
        final Observer<Player> nameObserver = new Observer<Player>() {
        @Override
        public void onChanged(@Nullable final Player player) {

        }
    };


}
