package com.example.player_list_mvvm_retrofit.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.player_list_mvvm_retrofit.Model.Player;

public class ShowPlayers extends ViewModel {
    private MutableLiveData<Player> playerMutableLiveData;

    public ShowPlayers() {
        playerMutableLiveData = new MutableLiveData<>();
    }

    public LiveData<Player> getPlayerObject(){
        return playerMutableLiveData;
    }

    public void getData(){
        Player player = new Player();
        player.setName("Tamim");
        player.setRole("Batsman");
        playerMutableLiveData.setValue(player);
    }
}
