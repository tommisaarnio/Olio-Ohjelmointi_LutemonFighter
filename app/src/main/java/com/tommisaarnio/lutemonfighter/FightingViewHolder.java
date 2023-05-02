package com.tommisaarnio.lutemonfighter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FightingViewHolder extends RecyclerView.ViewHolder {
    CheckBox checkBox;

    public FightingViewHolder(@NonNull View itemView) {
        super(itemView);
        checkBox = itemView.findViewById(R.id.cbLutemon);
    }

}