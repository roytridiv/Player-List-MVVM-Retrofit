package com.example.player_list_mvvm_retrofit.JsonParser;

import android.content.Context;
import android.os.AsyncTask;

import androidx.recyclerview.widget.RecyclerView;

import com.example.player_list_mvvm_retrofit.Model.Player;
import com.example.player_list_mvvm_retrofit.RecylerAdapter.RecyclerAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class JsonParserActivity extends AsyncTask<Void,Void,Void> {

    private ArrayList<Player> playerArrayList = new ArrayList<>();

    private Context context;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
private String data = "";

    public JsonParserActivity(ArrayList<Player> playerArrayList, Context context, RecyclerView recyclerView, RecyclerAdapter recyclerAdapter) {
        this.playerArrayList = playerArrayList;
        this.context = context;
        this.recyclerView = recyclerView;
        this.recyclerAdapter = recyclerAdapter;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            String name, role = null;
            URL url = new URL("http://tridivroy.xyz/test.json");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                data = data + line;
            }


            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("teamData");

            for(int i=0 ; i<jsonArray.length() ; i++){
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                name = jsonObject1.getString("name");
                role = jsonObject1.getString("role");

                playerArrayList.add(new Player(name ,role));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        recyclerAdapter = new RecyclerAdapter(context,playerArrayList);
        recyclerView.setAdapter(recyclerAdapter);
    }

}
