package com.example.upkeep_app.model.vo.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.upkeep_app.model.vo.Component;
import com.example.upkeep_app.model.vo.Service;

import java.util.List;

public class ServiceWithComponents {
    @Embedded
    public Service service;
    @Relation(
            parentColumn = "id",
            entityColumn = "id"
    )
    public List<Component> components;
}
