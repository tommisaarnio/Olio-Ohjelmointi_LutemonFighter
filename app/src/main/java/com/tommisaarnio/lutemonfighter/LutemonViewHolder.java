package com.tommisaarnio.lutemonfighter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {
    ImageView lutemonImage;
    TextView lutemonName, lutemonAttack, lutemonDefense, lutemonHitpoints, lutemonXp;

    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        lutemonImage = itemView.findViewById(R.id.ivLutemon);
        lutemonName = itemView.findViewById(R.id.txtName);
        lutemonAttack = itemView.findViewById(R.id.txtAttack);
        lutemonDefense = itemView.findViewById(R.id.txtDefense);
        lutemonHitpoints = itemView.findViewById(R.id.txtHitpoints);
        lutemonXp = itemView.findViewById(R.id.txtXp);
    }
}
