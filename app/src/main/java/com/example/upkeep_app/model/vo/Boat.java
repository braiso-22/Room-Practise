package com.example.upkeep_app.model.vo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.upkeep_app.util.exceptions.FormatError;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "boat")
public class Boat {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NotNull
    private int code;
    @NotNull
    private String name;
    @NotNull
    private String registration;

    public Boat(String id, String code, String name, String registration)throws FormatError{
        try {
            this.id = Integer.parseInt(id);
            this.code = Integer.parseInt(code);
            this.name = name;
            this.registration = registration;
        } catch (Exception e) {
            throw new FormatError("Boat");
        }
    }

    public Boat(@NotNull int code, @NotNull String name, @NotNull String registration) {
        this.code = code;
        this.name = name;
        this.registration = registration;
    }

    public Boat(String code, String name, String registration) throws FormatError {
        try {
            this.code = Integer.parseInt(code);
            this.name = name;
            this.registration = registration;
        } catch (Exception e) {
            throw new FormatError("Boat");
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getRegistration() {
        return registration;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", registration='" + registration + '\'' +
                '}' + "\n";
    }
}
