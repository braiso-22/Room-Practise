package com.example.upkeep_app.util.exceptions;

import androidx.annotation.Nullable;

public class InvalidDate extends Exception{
    @Nullable
    @Override
    public String getMessage() {
        return "Fecha mal formada, formato correcto YYYY-MM-DD";
    }
}