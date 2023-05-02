package com.tommisaarnio.lutemonfighter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DeadViewHolder extends RecyclerView.ViewHolder {
    CheckBox checkBox;

    public DeadViewHolder(@NonNull View itemView) {
        super(itemView);
        checkBox = itemView.findViewById(R.id.cbLutemon);
    }

}