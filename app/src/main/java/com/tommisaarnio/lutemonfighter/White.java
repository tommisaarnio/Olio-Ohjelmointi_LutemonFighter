package com.tommisaarnio.lutemonfighter;

import java.io.Serializable;

public class White extends Lutemon implements Serializable {
    public White(String name, String color, int attack, int defense, int experience, int health, int maxHealth, int id) {
        super(name, color, attack, defense, experience, health, maxHealth, id, R.drawable.white_lutemon);
    }
}
