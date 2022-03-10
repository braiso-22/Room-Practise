package com.example.upkeep_app.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.upkeep_app.model.vo.Fleet;
import com.example.upkeep_app.model.vo.Operator;
import com.example.upkeep_app.model.vo.relations.OperatorWithTasks;

import java.util.List;

@Dao
public interface OperatorDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Operator operator);

    @Query("DELETE FROM operator")
    void deleteAll();

    @Query("SELECT * FROM operator")
    LiveData<List<Operator>> getAll();

    @Update
    void update(Operator operator);
}
