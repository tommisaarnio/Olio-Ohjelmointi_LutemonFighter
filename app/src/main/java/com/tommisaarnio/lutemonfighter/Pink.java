package com.tommisaarnio.lutemonfighter;

import java.io.Serializable;

public class Pink extends Lutemon implements Serializable {
    public Pink(String name, String color, int attack, int defense, int experience, int health, int maxHealth, int id) {
        super(name, color, attack, defense, experience, health, maxHealth, id, R.drawable.pink_lutemon);
    }
}
