package com.example.upkeep_app.util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.upkeep_app.model.vo.Boat;
import com.example.upkeep_app.model.vo.Component;
import com.example.upkeep_app.model.vo.Fleet;
import com.example.upkeep_app.model.vo.Operator;
import com.example.upkeep_app.model.vo.Service;
import com.example.upkeep_app.model.vo.Store;
import com.example.upkeep_app.model.vo.Task;
import com.example.upkeep_app.model.vo.Upkeep;
import com.example.upkeep_app.util.exceptions.FormatError;
import com.example.upkeep_app.util.exceptions.InvalidDate;
import com.example.upkeep_app.util.exceptions.InvalidLength;
import com.example.upkeep_app.util.exceptions.InvalidTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class VOParser {

    public static Fleet parseFleet(String content) {
        return new Fleet(content);
    }

    public static Boat parseBoat(String content) throws InvalidLength, FormatError {
        String[] list = longitudRequerida(content, 3);
        return new Boat(list[0], list[1], list[2]);
    }

    public static Service parseService(String content) throws InvalidLength, FormatError {
        String[] list = longitudRequerida(content, 2);
        return new Service(list[0], list[1]);
    }

    public static Component parseComponent(String content) throws InvalidLength, FormatError {
        String[] list = longitudRequerida(content, 6);
        return new Component(list[0], list[1], list[2], list[3], list[4], list[5]);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Upkeep parseUpkeep(String content) throws InvalidLength, InvalidDate, InvalidTime {
        String[] list = longitudRequerida(content, 2);
        DateTimeFormatter dF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter tF = DateTimeFormatter.ofPattern("HH:MM:SS");

        LocalDate lD = LocalDate.parse(list[0], dF);

        if (!lD.toString().equals(list[0])) {
            throw new InvalidDate();
        }
        LocalTime lT = LocalTime.parse(list[1], tF);
        if (!lT.toString().equals(list[1])) {
            throw new InvalidTime();
        }
        return new Upkeep(list[0], list[1]);
    }

    public static Task parseTask(String content) throws InvalidLength, FormatError {
        String[] list = longitudRequerida(content, 2);
        return new Task(list[0], list[1]);
    }

    public static Operator parseOperator(String content) throws InvalidLength, FormatError {
        String[] list = longitudRequerida(content, 5);
        return new Operator(list[0], list[1], list[2], list[3], list[4]);
    }

    public static Store parseStore(String content) throws InvalidLength, FormatError {
        String[] list = longitudRequerida(content, 8);
        return new Store(list[0], list[1], list[2], list[3], list[4], list[5], list[6], list[7]);
    }

    private static String[] longitudRequerida(String content, int longitud) throws InvalidLength {
        String[] list = content.split(";");
        if (list.length != longitud) {
            throw new InvalidLength(longitud);
        }
        return list;
    }
}

