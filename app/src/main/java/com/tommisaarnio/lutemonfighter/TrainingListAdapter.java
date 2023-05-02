package com.tommisaarnio.lutemonfighter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrainingListAdapter extends RecyclerView.Adapter<TrainingViewHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemonsTraining = new ArrayList<>();

    private ArrayList<Lutemon> selectedLutemons = new ArrayList<>();

    public TrainingListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemonsTraining = Storage.getInstance().getLutemonsTraining();
    }

    @NonNull
    @Override
    public TrainingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TrainingViewHolder(LayoutInflater.from(context).inflate(R.layout.moving_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingViewHolder holder, int position) {
    Lutemon lutemon = lutemonsTraining.get(position);
        holder.checkBox.setText(lutemonsTraining.get(position).getName() + " (" + lutemonsTraining.get(position).getColor() + ")");

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
                lutemonsTraining.remove(l);
            }
            selectedLutemons.clear();
        }
    });
}

    @Override
    public int getItemCount() {
        return lutemonsTraining.size();
    }
}
