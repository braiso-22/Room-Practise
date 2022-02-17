package com.example.upkeep_app.model.vo.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.upkeep_app.model.vo.Store;
import com.example.upkeep_app.model.vo.Task;

import java.util.List;

public class TaskWithStores {
    @Embedded
    public Task task;
    @Relation(
            parentColumn = "id",
            entityColumn = "id"
    )
    public List<Store> stores;
}
