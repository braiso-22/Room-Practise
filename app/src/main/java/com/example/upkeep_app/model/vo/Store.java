package com.example.upkeep_app.model.vo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.upkeep_app.util.exceptions.FormatError;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "store")
public class Store {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NotNull
    private int code;
    @NotNull
    private String name;
    @NotNull
    private String brand;
    @NotNull
    private String model;
    @NotNull
    private String serialNumber;
    @NotNull
    private String observations;
    @NotNull
    private int numStock;
    @NotNull
    private int minStock;

    public Store(@NotNull int code, @NotNull String name, @NotNull String brand, @NotNull String model, @NotNull String serialNumber, @NotNull String observations, @NotNull int numStock, @NotNull int minStock) {
        this.code = code;
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.observations = observations;
        this.numStock = numStock;
        this.minStock = minStock;
    }

    public Store(String code, String name, String brand, String model, String serialNumber, String observations, String numStock, String minStock) throws FormatError{
        try{
            this.code = Integer.parseInt(code);
            this.numStock = Integer.parseInt(numStock);
            this.minStock = Integer.parseInt(minStock);
        }catch (Exception e){
            throw new FormatError("Store");
        }
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

    public int getNumStock() {
        return numStock;
    }

    public int getMinStock() {
        return minStock;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", observations='" + observations + '\'' +
                ", numStock=" + numStock +
                ", minStock=" + minStock +
                '}' + "\n";
    }
}
