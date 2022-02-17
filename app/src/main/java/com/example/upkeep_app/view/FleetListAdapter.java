package com.example.upkeep_app.view;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.upkeep_app.model.vo.Fleet;

import org.jetbrains.annotations.NotNull;

public class FleetListAdapter extends ListAdapter<Fleet, FleetViewHolder> {
    public FleetListAdapter(@NotNull DiffUtil.ItemCallback<Fleet> diffCallBack) {
        super(diffCallBack);
    }

    @Override
    public FleetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return FleetViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull FleetViewHolder holder, int position) {
        Fleet current = (Fleet) getItem(position);
        holder.bind(current.getId());
    }

    public static class FleetDiff extends DiffUtil.ItemCallback<Fleet> {

        @Override
        public boolean areItemsTheSame(@NonNull Fleet oldItem, @NonNull Fleet newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Fleet oldItem, @NonNull Fleet newItem) {
            return oldItem.getId() == (newItem.getId());
        }
    }
}
