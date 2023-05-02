package com.tommisaarnio.lutemonfighter;

import android.content.Context;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {
    ArrayList<Lutemon> lutemons = new ArrayList<>();
    ArrayList<Lutemon> lutemonsHome = new ArrayList<>();
    ArrayList<Lutemon> lutemonsTraining = new ArrayList<>();
    ArrayList<Lutemon> lutemonsFighting = new ArrayList<>();
    ArrayList<Lutemon> lutemonsDead = new ArrayList<>();

    ArrayList<Lutemon> movingLutemon = new ArrayList<>();

    public Storage() {
    }

    private Context context;

    public static Storage storage = null;


    public static Storage getInstance() {
        if (storage == null){
            storage = new Storage();
        }
        return storage;
    }

    public ArrayList<Lutemon> getMovingLutemon() {
        return movingLutemon;
    }


    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }


    public void removeHomeLutemon(Lutemon lutemon){
        lutemonsHome.remove(lutemon);
    }

    public void addLutemonToHome(Lutemon lutemon) {
        lutemonsHome.add(lutemon);
    }

    public void addMovingLutemon(Lutemon lutemon) {
        movingLutemon.add(lutemon);
    }

    public void addLutemonToTraining(Lutemon lutemon) {
        lutemonsTraining.add(lutemon);
    }
    public void addLutemonToFighting(Lutemon lutemon) {
        lutemonsFighting.add(lutemon);
        lutemonsHome.remove(lutemon);
    }

    public ArrayList<Lutemon> getLutemonsHome() {
        return lutemonsHome;
    }

    public void removeLutemon(int id){
        lutemons.remove(id);
    }

    public ArrayList<Lutemon> getLutemonsTraining() {
        return lutemonsTraining;
    }

    public ArrayList<Lutemon> getLutemonsFighting() {
        return lutemonsFighting;
    }

    public ArrayList<Lutemon> getLutemonsDead() {
        return lutemonsDead;
    }

    public void addDeadLutemon(Lutemon lutemon) {
        lutemonsDead.add(lutemon);
    }


    public void saveLutemon(Context context) {
        try {
            ObjectOutputStream lutemonWriter = new ObjectOutputStream(context.openFileOutput("lutemon.data", Context.MODE_PRIVATE));
            lutemonWriter.writeObject(lutemons);
            lutemonWriter.close();
        }   catch (IOException e){
            System.out.println("Virhe tiedoston käsittelyssä");
        }
    }

    public void loadLutemon(Context context){
        try {
            ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("lutemon.data"));
            lutemons = (ArrayList<Lutemon>) userReader.readObject();
            userReader.close();
        }   catch (IOException e){
            System.out.println("Listaa ei ole olemassa. Luo ensin lutemon,");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}