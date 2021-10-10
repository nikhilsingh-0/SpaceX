package com.mk.nk.spacex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mk.nk.spacex.Room.Crew;
import com.mk.nk.spacex.Room.CrewDatabase;
import com.mk.nk.spacex.Room.CrewRoomAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Context context;
    private Button refresh, deleteAll;
    List<CrewModel> roomList;
    String url = "https://api.spacexdata.com/v4/";
    CrewDatabase database;
    Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle_view);
        refresh = findViewById(R.id.refresh);
        deleteAll = findViewById(R.id.deleteAll);
        database = Room.databaseBuilder(MainActivity.this, CrewDatabase.class, "crewDB")
                .allowMainThreadQueries().build();

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        if (isInternet()) {
            onlineData();
        } else {
            roomData();
        }


        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.dao().deleteAll();
            }
        });

    }

    private void onlineData() {
        MyApi api = retrofit.create(MyApi.class);
        Call<List<CrewModel>> call = api.getModels();

        call.enqueue(new Callback<List<CrewModel>>() {
            @Override
            public void onResponse(Call<List<CrewModel>> call, Response<List<CrewModel>> response) {
                roomList = response.body();
                database.dao().deleteAll();
                CrewAdapter adapter = new CrewAdapter(MainActivity.this, roomList);
                LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(manager);
                insert();
            }

            @Override
            public void onFailure(Call<List<CrewModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to Load Data", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void roomData() {
        List<Crew> list = database.dao().readAll();
        CrewRoomAdapter adapter = new CrewRoomAdapter(MainActivity.this, list);
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
    }

    void insert() {
        for (int i = 0; i < roomList.size(); i++) {
            Crew crew = new Crew(roomList.get(i).getName(), roomList.get(i).getAgency(), roomList.get(i).getStatus(), roomList.get(i).getWikipedia(), roomList.get(i).getImage());
            database.dao().crewInsert(crew);
        }

    }


    private boolean isInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }

}