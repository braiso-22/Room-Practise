package com.example.upkeep_app.util.exceptions;

import androidx.annotation.Nullable;

public class FormatError extends Exception {
    private String clase;
    public FormatError(String clase){
        this.clase = clase;
    }

    @Nullable
    @Override
    public String getMessage() {
        return "Error creando este ".concat(clase);
    }
}
