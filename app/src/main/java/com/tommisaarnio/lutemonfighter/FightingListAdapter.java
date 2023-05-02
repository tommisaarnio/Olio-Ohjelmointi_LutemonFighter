package com.tommisaarnio.lutemonfighter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FightingListAdapter extends RecyclerView.Adapter<FightingViewHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemonsFighting = new ArrayList<>();
    private ArrayList<Lutemon> selectedLutemons = new ArrayList<>();

    public FightingListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemonsFighting = Storage.getInstance().getLutemonsFighting();
    }

    @NonNull
    @Override
    public FightingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FightingViewHolder(LayoutInflater.from(context).inflate(R.layout.moving_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FightingViewHolder holder, int position) {
        Lutemon lutemon = lutemonsFighting.get(position);
        holder.checkBox.setText(lutemonsFighting.get(position).getName() + " (" + lutemonsFighting.get(position).getColor() + ")");
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
                    lutemonsFighting.remove(l);
                }
                selectedLutemons.clear();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lutemonsFighting.size();
    }
}
