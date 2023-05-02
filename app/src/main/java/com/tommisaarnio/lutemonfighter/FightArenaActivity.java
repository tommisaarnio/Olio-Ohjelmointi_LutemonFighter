package com.tommisaarnio.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FightArenaActivity extends AppCompatActivity {

    ImageView fighterImage;

    private TextView textView;
    private String fightText;
    private ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_arena);
        imageView1 = findViewById(R.id.imageViewA);
        imageView2 = findViewById(R.id.imageViewB);
        textView = findViewById(R.id.BattleTextView);
        Lutemon a = Storage.getInstance().movingLutemon.get(0);
        imageView1.setImageResource(a.getImage());
        Lutemon b = Storage.getInstance().movingLutemon.get(1);
        imageView2.setImageResource(b.getImage());
        int x = 1;
        int y = 2;
        int temp1 = 0;
        fightText = "";
        while (b.getHealth() > 0){
            b.defense(a.attack());
            if (b.getHealth() > 0){
                fightText = fightText + (x + ": " + a.getName() +  "(" + a.getColor() + ") hyökkäys: " + a.getAttack() + "; puolustus: " + a.getDefense() + "; kokemus: " + a.getExperience() + "; elämät: " + a.getHealth() + "\n");
                fightText = fightText + (y + ": " + b.getName() +  "(" + b.getColor() + ") hyökkäys: " + b.getAttack() + "; puolustus: " + b.getDefense() + "; kokemus: " + b.getExperience() + "; elämät: " + b.getHealth() + "\n");
                fightText = fightText + (a.getName() +  "(" + a.getColor() + ") hyökkää!!\n");
                if (b.getHealth() > 1) {
                    fightText = fightText + (b.getName() + "(" + b.getColor() + ") puolustautuu!\n");
                    fightText = fightText + (b.getName() + "(" + b.getColor() + ") onnistuu välttämään kuoleman!\n\n");
                    Lutemon temp = a;
                    a = b;
                    b = temp;
                }

                temp1 = x;
                x = y;
                y = temp1;
            }else {
                fightText = fightText + (b.getName() +  "(" + b.getColor() + ") kuolee iskussa!!\n");
                fightText = fightText + ("Taistelu on Loppunut.");
                textView.setText(fightText);
                a.addExperience(5);
                b.setHealthToZero();
                Storage.getInstance().addLutemonToHome(a);
                Storage.getInstance().addDeadLutemon(b);
                Storage.getInstance().movingLutemon.remove(0);
                Storage.getInstance().movingLutemon.remove(0);
                Storage.getInstance().lutemonsFighting.remove(a);
                Storage.getInstance().lutemonsFighting.remove(b);
                Storage.getInstance().addLutemon(a);
                Storage.getInstance().addLutemon(b);
                Storage.getInstance().saveLutemon(getApplicationContext());
            }
        }
    }


    public void switchBack(View view) {
        Intent intent = new Intent(this, FightingActivity.class);
        startActivity(intent);
    }
}