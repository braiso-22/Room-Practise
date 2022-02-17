package com.example.upkeep_app.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.upkeep_app.model.vo.Upkeep;
import com.example.upkeep_app.model.vo.relations.UpkeepWithTasks;

import java.util.List;
@Dao
public interface UpkeepDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Upkeep upkeep);

    @Query("DELETE FROM upkeep")
    void deleteAll();

    @Query("SELECT * FROM upkeep")
    LiveData<List<Upkeep>> getAll();

    @Transaction
    @Query("SELECT * FROM upkeep")
    List<UpkeepWithTasks> getUpkeepWithTasks();
}
