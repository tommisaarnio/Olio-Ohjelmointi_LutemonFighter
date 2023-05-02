package com.tommisaarnio.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        Storage.getInstance().loadLutemon(context);
    }


    public void switchToAddLutemon(View view) {
        Intent intent = new Intent(this, AddLutemon.class);
        startActivity(intent);
    }

    public void switchToListLutemons(View view) {
        Intent intent = new Intent(this, LutemonListActivity.class);
        startActivity(intent);
    }
    public void switchToMovingLutemon(View view) {
        Intent intent = new Intent(this, MovingLutemon.class);
        startActivity(intent);
    }

    public void switchToFighting(View view) {
        Intent intent = new Intent(this, FightingActivity.class);
        startActivity(intent);
    }

}