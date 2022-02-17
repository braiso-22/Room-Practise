package com.example.upkeep_app.model.vo.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.upkeep_app.model.vo.Component;
import com.example.upkeep_app.model.vo.Upkeep;

import java.util.List;

public class ComponentWithUpkeeps {
    @Embedded
    public Component component;
    @Relation(
            parentColumn = "id",
            entityColumn = "id"
    )
    public List<Upkeep> upkeeps;
}
