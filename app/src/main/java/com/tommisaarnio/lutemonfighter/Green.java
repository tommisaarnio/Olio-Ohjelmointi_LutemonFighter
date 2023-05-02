package com.tommisaarnio.lutemonfighter;

import java.io.Serializable;

public class Green extends Lutemon implements Serializable {
    public Green(String name, String color, int attack, int defense, int experience, int health, int maxHealth, int id) {
        super(name, color, attack, defense, experience, health, maxHealth, id, R.drawable.green_lutemon);
    }
}
