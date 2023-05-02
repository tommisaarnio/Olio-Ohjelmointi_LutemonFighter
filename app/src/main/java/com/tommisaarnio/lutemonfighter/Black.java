package com.tommisaarnio.lutemonfighter;

import java.io.Serializable;

public class Black extends Lutemon implements Serializable {


    public Black(String name, String color, int attack, int defense, int experience, int health, int maxHealth, int id) {
        super(name, color, attack, defense, experience, health, maxHealth, id, R.drawable.black_lutemon);
    }
}
