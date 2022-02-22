package com.example.upkeep_app.model.vo.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.upkeep_app.model.vo.Service;
import com.example.upkeep_app.model.vo.Task;
import com.example.upkeep_app.model.vo.Upkeep;

import java.util.List;

public class UpkeepWithTasks {
    @Embedded
    public Upkeep upkeep;
    @Relation(
            parentColumn = "id",
            entityColumn = "id"
    )
    public List<Task> tasks;
}
