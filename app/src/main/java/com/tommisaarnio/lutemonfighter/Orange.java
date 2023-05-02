package com.tommisaarnio.lutemonfighter;

import java.io.Serializable;

public class Orange extends Lutemon implements Serializable {
    public Orange(String name, String color, int attack, int defense, int experience, int health, int maxHealth, int id) {
        super(name, color, attack, defense, experience, health, maxHealth, id, R.drawable.orange_lutemon);
    }
}
