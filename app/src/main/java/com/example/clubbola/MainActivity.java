package com.example.clubbola;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvclub;

    private ArrayList<club> list= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvclub = findViewById(R.id.rv_club);
        rvclub.setHasFixedSize(true);

        list.addAll(clubdata.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvclub.setLayoutManager(new LinearLayoutManager(this));
        listclubadapter listclubadapter = new listclubadapter(list);
        rvclub.setAdapter(listclubadapter);

        listclubadapter.setOnItemClickCallback(new listclubadapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(club club) {
                Intent move = new Intent(MainActivity.this,detailclub.class);
                move.putExtra(detailclub.ITEM_EXTRA, club);
                startActivity(move);
            }
        });

    }
}