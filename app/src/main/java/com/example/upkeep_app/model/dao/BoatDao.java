package com.example.upkeep_app.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.upkeep_app.model.vo.Boat;
import com.example.upkeep_app.model.vo.relations.BoatWithServices;

import java.util.List;

@Dao
public interface BoatDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Boat boat);

    @Query("DELETE FROM boat")
    void deleteAll();

    @Query("SELECT * FROM boat")
    LiveData<List<Boat>> getAll();

    @Transaction
    @Query("SELECT * FROM boat")
    List<BoatWithServices> getBoatWithServices();
}
