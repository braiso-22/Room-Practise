package com.example.upkeep_app.util;

import androidx.annotation.Nullable;

import com.example.upkeep_app.model.vo.Boat;
import com.example.upkeep_app.model.vo.Fleet;

public class VOParser {

    public Fleet parseFleet(String content) {
        return new Fleet(content);
    }

    public Boat parseBoat(String content) throws LongitudIncorrecta, FormatError {
        String[] list = content.split(";");
        if (list.length != 3) {
            throw new LongitudIncorrecta();
        }
        return new Boat(list[0], list[1], list[2]);
    }

}

