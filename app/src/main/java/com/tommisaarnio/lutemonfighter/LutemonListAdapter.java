package com.tommisaarnio.lutemonfighter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = Storage.getInstance().getLutemons();
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        holder.lutemonName.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");
        holder.lutemonAttack.setText("Hyökkäys: " + String.valueOf(lutemons.get(position).getAttack()));
        holder.lutemonDefense.setText("Puolustus: " + String.valueOf(lutemons.get(position).getDefense()));
        holder.lutemonHitpoints.setText("Elämä: " + String.valueOf(lutemons.get(position).getHealth() + "/" + lutemons.get(position).getMaxHealth()));
        holder.lutemonXp.setText("Kokemus: " + String.valueOf(lutemons.get(position).getExperience()));
        holder.lutemonImage.setImageResource(lutemons.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
