package com.example.upkeep_app.model.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.upkeep_app.model.dao.*;
import com.example.upkeep_app.model.vo.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Fleet.class, Boat.class, Service.class,
        Component.class, Upkeep.class, Task.class,
        Operator.class, Store.class},
        version = 1, exportSchema = false)
public abstract class UpkeepsRoomDatabase extends RoomDatabase {

    public FleetDao fleetDao;
    public BoatDao boatDao;
    public ServiceDao serviceDao;
    public ComponentDao componentDao;
    public UpkeepDao upkeepDao;
    public TaskDao taskDao;
    public OperatorDao operatorDao;
    public StoreDao storeDao;

    private static volatile UpkeepsRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 10;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static UpkeepsRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UpkeepsRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UpkeepsRoomDatabase.class, "upkeeps_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
