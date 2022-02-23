package com.example.upkeep_app.model.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.upkeep_app.model.dao.*;
import com.example.upkeep_app.model.vo.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Fleet.class, Boat.class, Service.class,
        Component.class, Upkeep.class, Task.class,
        Operator.class, Store.class},
        version = 1, exportSchema = false)
public abstract class UpkeepsRoomDatabase extends RoomDatabase {

    public abstract FleetDao fleetDao();

    public abstract BoatDao boatDao();

    public abstract ServiceDao serviceDao();

    public abstract ComponentDao componentDao();

    public abstract UpkeepDao upkeepDao();

    public abstract TaskDao taskDao();

    public abstract OperatorDao operatorDao();

    public abstract StoreDao storeDao();

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
                            .addCallback(roomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background

                FleetDao fleetDao = INSTANCE.fleetDao();
                fleetDao.deleteAll();

                Fleet fleet = new Fleet("Flota Carlos");
                fleetDao.insert(fleet);

                BoatDao boatDao = INSTANCE.boatDao();
                boatDao.deleteAll();

                Boat boat = new Boat(1, "Santa catalina", "123");
                boatDao.insert(boat);

                ServiceDao serviceDao = INSTANCE.serviceDao();
                serviceDao.deleteAll();

                Service service = new Service(123, "motores");
                serviceDao.insert(service);


            });
        }
    };

}
