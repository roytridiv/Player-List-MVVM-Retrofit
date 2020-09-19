package com.example.player_list_mvvm_retrofit.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.player_list_mvvm_retrofit.R;
import com.example.player_list_mvvm_retrofit.Model.Player;
import com.example.player_list_mvvm_retrofit.ViewModel.ShowPlayers;

public class MainActivity extends AppCompatActivity {

    Button fetch;
    TextView t1, t2;
    ShowPlayers model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fetch = findViewById(R.id.fet);
        t1 = findViewById(R.id.text1);
        t2 = findViewById(R.id.text2);

        // Get the ViewModel.
        model = ViewModelProviders.of(this).get(ShowPlayers.class);

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.getPlayerObject().observe(this, nameObserver);

        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.getData();
            }
        });

    }

    // Create the observer which updates the UI.
        final Observer<Player> nameObserver = new Observer<Player>() {
        @Override
        public void onChanged(@Nullable final Player player) {
            t1.setText(player.getName());
            t2.setText(player.getRole());
        }
    };
}
