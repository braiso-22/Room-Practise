package com.example.upkeep_app.model.vo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.upkeep_app.util.exceptions.FormatError;

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

    public Component(String id,String code, String name, String brand, String model, String serialNumber, String observations) throws FormatError{
        try{
            this.id = Integer.parseInt(id);
            this.code = Integer.parseInt(code);
            this.name = name;
            this.brand = brand;
            this.model = model;
            this.serialNumber = serialNumber;
            this.observations = observations;
        }catch (Exception e){
            throw new FormatError("Component");
        }
    }

    public Component(@NotNull int code, @NotNull String name, String brand, String model, String serialNumber, String observations) {
        this.code = code;
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.observations = observations;
    }

    public Component(String code, String name, String brand, String model, String serialNumber, String observations) throws FormatError{
        try{
            this.code = Integer.parseInt(code);
            this.name = name;
            this.brand = brand;
            this.model = model;
            this.serialNumber = serialNumber;
            this.observations = observations;
        }catch (Exception e){
            throw new FormatError("Component");
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
