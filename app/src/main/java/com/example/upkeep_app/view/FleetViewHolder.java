package com.example.upkeep_app.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.upkeep_app.R;

public class FleetViewHolder extends RecyclerView.ViewHolder {
    private final TextView fleetItemView;

    public FleetViewHolder(@NonNull View itemView) {
        super(itemView);
        fleetItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(int id) {
        fleetItemView.setText(id);
    }

    public static FleetViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new FleetViewHolder(view);
    }
}
