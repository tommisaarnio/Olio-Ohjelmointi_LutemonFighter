package com.tommisaarnio.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class LutemonListActivity extends AppCompatActivity {

    private Storage storage;
    private RecyclerView recyclerView;

    private Context context;

    private ArrayList<Lutemon> startLutemons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = LutemonListActivity.this;
        setContentView(R.layout.activity_lutemon_list);
        storage = Storage.getInstance();
        recyclerView = findViewById(R.id.rvList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonListAdapter(getApplicationContext(), storage.getLutemons()));
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}