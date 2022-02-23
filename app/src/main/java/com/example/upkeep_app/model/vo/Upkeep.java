package com.example.upkeep_app.model.vo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.sql.Date;
import java.sql.Time;

@Entity(tableName = "upkeep")
public class Upkeep {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NotNull
    private String date;
    @NotNull
    private String hour;

    public Upkeep(@NotNull String date, @NotNull String hour) {
        this.date = date;
        this.hour = hour;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getHour() {
        return hour;
    }

    @Override
    public String toString() {
        return "Upkeep{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                '}' + "\n";
    }
}
