package com.tommisaarnio.lutemonfighter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomeListAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    private static int i = 0;

    private Context context;
    private ArrayList<Lutemon> lutemonsHome = new ArrayList<>();
    private ArrayList<Lutemon> selectedLutemons = new ArrayList<>();

    public HomeListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        if (i == 0) {
            this.lutemonsHome = Storage.getInstance().getLutemons();
            for (Lutemon l : lutemonsHome){
                Storage.getInstance().addLutemonToHome(l);
            }
            i = 1;
        } else {
            this.lutemonsHome = Storage.getInstance().getLutemonsHome();
        }
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutInflater.from(context).inflate(R.layout.moving_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        Lutemon lutemon = lutemonsHome.get(position);
        holder.checkBox.setText(lutemonsHome.get(position).getName() + " (" + lutemonsHome.get(position).getColor() + ")");

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                CheckBox checkBox = (CheckBox) v;
                if (checkBox.isChecked()) {
                    selectedLutemons.add(lutemon);
                } else {
                    selectedLutemons.remove(lutemon);
                }
                for (Lutemon l : selectedLutemons){
                    Storage.getInstance().addMovingLutemon(l);
                    lutemonsHome.remove(l);
                }
                selectedLutemons.clear();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lutemonsHome.size();
    }

}
