package com.example.upkeep_app.model.vo.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.upkeep_app.model.vo.Boat;
import com.example.upkeep_app.model.vo.Fleet;

import java.util.List;

public class FleetWithBoats {
    @Embedded
    public Fleet fleet;
    @Relation(
            parentColumn = "id",
            entityColumn = "id"
    )
    public List<Boat> boats;
}
