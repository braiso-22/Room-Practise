package com.example.upkeep_app.model.vo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "fleet")
public class Fleet {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NotNull
    private String name;

    public Fleet(@NotNull String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Fleet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}'+"\n";
    }
}
