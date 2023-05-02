package com.tommisaarnio.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddLutemon extends AppCompatActivity {

    private RadioGroup radioGroup;
    private EditText name;

    private String color;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemon);
        name = findViewById(R.id.txtLutemonName);
        context = AddLutemon.this;
    }


    public void addLutemon(View view){
        int id = 0;
        String lutemonName = name.getText().toString();
        RadioGroup lutemonType = findViewById(R.id.rgLutemonType);
        switch (lutemonType.getCheckedRadioButtonId()) {
            case R.id.rbWhite:
                Lutemon newWhite = new Lutemon(lutemonName, "Valkoinen", 5, 4, 0, 20, 20, id, R.drawable.white_lutemon);
                Storage.getInstance().addLutemon(newWhite);
                break;
            case R.id.rbGreen:
                Lutemon newGreen = new Lutemon(lutemonName, "Vihreä", 6, 3, 0, 19, 19, id, R.drawable.green_lutemon);
                Storage.getInstance().addLutemon(newGreen);
                break;
            case R.id.rbPink:
                Lutemon newPink = new Lutemon(lutemonName, "Pinkki", 7, 2, 0, 18, 18, id, R.drawable.pink_lutemon);
                Storage.getInstance().addLutemon(newPink);
                break;
            case R.id.rbOrange:
                Lutemon newOrange = new Lutemon(lutemonName, "Oranssi", 8, 1, 0, 17, 17, id, R.drawable.orange_lutemon);
                Storage.getInstance().addLutemon(newOrange);
                break;
            case R.id.rbBlack:
                Lutemon newBlack = new Lutemon(lutemonName, "Musta", 9, 0, 0, 16, 16, id, R.drawable.black_lutemon);
                Storage.getInstance().addLutemon(newBlack);
                break;
            default:
                break;
        }
        Storage.getInstance().saveLutemon(context);
        id++;
    }

    public void switchToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}