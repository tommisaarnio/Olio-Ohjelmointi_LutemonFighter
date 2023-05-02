package com.tommisaarnio.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FightingActivity extends AppCompatActivity {

    private Storage storage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighting);
        storage = Storage.getInstance();
        recyclerView = findViewById(R.id.rvSelectFight);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new FightingListAdapter(getApplicationContext(), storage.getLutemonsFighting()));
    }

    public void goToArena(View view) {
        Intent intent = new Intent(this, FightArenaActivity.class);
        startActivity(intent);
    }

    public void switchToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}