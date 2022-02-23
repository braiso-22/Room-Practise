package com.example.upkeep_app.model.vo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "operator")
public class Operator {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NotNull
    private int code;
    @NotNull
    private String identification;
    @NotNull
    private String name;
    @NotNull
    private String surnames;
    @NotNull
    private String email;

    public Operator(@NotNull int code, @NotNull String identification, @NotNull String name, @NotNull String surnames, @NotNull String email) {
        this.code = code;
        this.identification = identification;
        this.name = name;
        this.surnames = surnames;
        this.email = email;
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

    public String getIdentification() {
        return identification;
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "id=" + id +
                ", code=" + code +
                ", identification='" + identification + '\'' +
                ", name='" + name + '\'' +
                ", surnames='" + surnames + '\'' +
                ", email='" + email + '\'' +
                '}' + "\n";
    }
}
