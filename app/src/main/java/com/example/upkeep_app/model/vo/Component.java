package com.example.upkeep_app.model.vo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "component")
public class Component {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NotNull
    private int code;
    @NotNull
    private String name;
    private String brand;
    private String model;
    private String serialNumber;
    private String observations;

    public Component(@NotNull int code, @NotNull String name, String brand, String model, String serialNumber, String observations) {
        this.code = code;
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.observations = observations;
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

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getObservations() {
        return observations;
    }

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", observations='" + observations + '\'' +
                '}' + "\n";
    }
}
