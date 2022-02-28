package com.example.upkeep_app.model.vo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.upkeep_app.util.exceptions.FormatError;

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

    public Task(String lenght, String description) throws FormatError{
        try{
            this.lenght = Integer.parseInt(lenght);
            this.description = description;
        }catch (Exception e){
            throw new FormatError("Task");
        }
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", lenght=" + lenght +
                ", description='" + description + '\'' +
                '}' + "\n";
    }
}
