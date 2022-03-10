package com.example.upkeep_app.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.upkeep_app.model.vo.Fleet;
import com.example.upkeep_app.model.vo.Task;
import com.example.upkeep_app.model.vo.relations.TaskWithStores;

import java.util.List;
@Dao
public interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Task task);

    @Query("DELETE FROM task")
    void deleteAll();

    @Query("SELECT * FROM task")
    LiveData<List<Task>> getAll();

    @Update
    void update(Task task);
}
