package com.tommisaarnio.lutemonfighter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DeadListAdapter extends RecyclerView.Adapter<DeadViewHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemonsDead = new ArrayList<>();
    private ArrayList<Lutemon> selectedLutemons = new ArrayList<>();

    public DeadListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemonsDead = Storage.getInstance().getLutemonsDead();
    }

    @NonNull
    @Override
    public DeadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DeadViewHolder(LayoutInflater.from(context).inflate(R.layout.moving_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DeadViewHolder holder, int position) {
        Lutemon lutemon = lutemonsDead.get(position);
        holder.checkBox.setText(lutemonsDead.get(position).getName() + " (" + lutemonsDead.get(position).getColor() + ")");
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
                    lutemonsDead.remove(l);
                }
                selectedLutemons.clear();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lutemonsDead.size();
    }
}
