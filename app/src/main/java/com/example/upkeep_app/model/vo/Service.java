package com.example.upkeep_app.model.vo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.upkeep_app.util.exceptions.FormatError;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "service")
public class Service {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NotNull
    private int code;
    @NotNull
    private String name;

    public Service(@NotNull int code, @NotNull String name) {
        this.code = code;
        this.name = name;
    }

    public Service(String code, String name) throws FormatError {
        try {
            this.code = Integer.parseInt(code);
            this.name = name;
        }catch (Exception e){
            throw new FormatError("Service");
        }
        this.name = name;
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

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                '}' + "\n";
    }
}
