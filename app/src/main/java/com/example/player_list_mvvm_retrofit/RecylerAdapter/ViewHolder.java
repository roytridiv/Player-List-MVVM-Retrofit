package com.example.player_list_mvvm_retrofit.RecylerAdapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.player_list_mvvm_retrofit.R;
import com.example.player_list_mvvm_retrofit.Model.Player;

import java.util.ArrayList;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private  ArrayList<Player> playersList ;
    private Context context;
    TextView name, role;


    public ViewHolder(@NonNull View itemView, ArrayList<Player> playersList, Context context) {
        super(itemView);
        this.playersList = playersList;
        this.context = context;
        itemView.setOnClickListener(this);
        name = itemView.findViewById(R.id.name);
        role = itemView.findViewById(R.id.role);
    }

    @Override
    public void onClick(View v) {

    }
}
