package com.tommisaarnio.lutemonfighter;

import java.io.Serializable;

public class Lutemon implements Serializable {

    protected String name;
    protected String color;
    protected int attack;
    protected int defense;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected int id;
    protected int image;

    private int idCounter;

    protected static final long serialVersionUID = 823975;


    public Lutemon(String name, String color, int attack, int defense, int experience, int health, int maxHealth, int id, int image) {

        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
        this.id = id;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void restoreHealth(){

        this.health = maxHealth;
    }

    public void setHealthToZero(){
        health = 0;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

    public void defense(int damage) {
        health -= damage;
    }
    public int attack() {
        return attack + experience;
    }
    public void addExperience(int points) {
        experience += points;
    }
    public void addHealth(int boost) {
        health += boost;
    }

    public void addMaxHealth(int boost){
        maxHealth += boost;
    }


}
