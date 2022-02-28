package com.example.upkeep_app.util.exceptions;

import androidx.annotation.Nullable;

public class InvalidTime extends Exception{
    @Nullable
    @Override
    public String getMessage() {
        return "Hora mal formada, formato correcto HH:MM:SS";
    }
}
