package com.example.player_list_mvvm_retrofit.RecylerAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.player_list_mvvm_retrofit.R;
import com.example.player_list_mvvm_retrofit.Model.Player;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    private Context context;
    private ArrayList<Player> playersList;
    TextView name , role;

    public RecyclerAdapter(Context context, ArrayList<Player> playersList) {
        this.context = context;
        this.playersList = playersList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view, playersList, context);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Player player = playersList.get(position);
        name = holder.name;
        role = holder.role;
        name.setText("Name: "+player.getName());
        role.setText("Role: "+player.getRole());

    }


    @Override
    public int getItemCount() {
        return playersList.size();
    }
}