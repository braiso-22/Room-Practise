package com.example.upkeep_app.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.upkeep_app.model.vo.Component;
import com.example.upkeep_app.model.vo.relations.ComponentWithUpkeeps;

import java.util.List;

@Dao
public interface ComponentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Component component);

    @Query("DELETE FROM component")
    void deleteAll();

    @Query("SELECT * FROM component")
    LiveData<List<Component>> getAll();
}
