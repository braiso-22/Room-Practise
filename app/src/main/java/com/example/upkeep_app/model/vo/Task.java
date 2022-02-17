package com.example.upkeep_app.model.vo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "task")
public class Task {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NotNull
    private int lenght;
    @NotNull
    private String description;

    public Task(@NotNull int lenght, @NotNull String description) {
        this.lenght = lenght;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getLenght() {
        return lenght;
    }

    public String getDescription() {
        return description;
    }
}
