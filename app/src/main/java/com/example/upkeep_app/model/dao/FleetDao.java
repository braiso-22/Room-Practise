package com.example.upkeep_app.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.upkeep_app.model.vo.Fleet;
import com.example.upkeep_app.model.vo.relations.FleetWithBoats;

import java.util.List;

@Dao
public interface FleetDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Fleet fleet);

    @Query("DELETE FROM fleet")
    void deleteAll();

    @Query("SELECT * FROM fleet")
    LiveData<List<Fleet>> getAll();
}
