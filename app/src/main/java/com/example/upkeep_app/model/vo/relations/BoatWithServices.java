package com.example.upkeep_app.model.vo.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.upkeep_app.model.vo.Boat;
import com.example.upkeep_app.model.vo.Service;

import java.util.List;

public class BoatWithServices {
    @Embedded
    public Boat boat;
    @Relation(
            parentColumn = "id",
            entityColumn = "id"
    )
    public List<Service> services;
}
