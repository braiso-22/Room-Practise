package com.example.upkeep_app.model.vo.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.upkeep_app.model.vo.Operator;
import com.example.upkeep_app.model.vo.Task;

import java.util.List;

public class OperatorWithTasks {
    @Embedded
    public Operator operator;
    @Relation(
            parentColumn = "id",
            entityColumn = "id"
    )
    public List<Task> tasks;
}
