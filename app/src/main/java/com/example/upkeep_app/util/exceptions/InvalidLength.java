package com.example.upkeep_app.util.exceptions;

import androidx.annotation.Nullable;

public class InvalidLength extends Exception {
    @Nullable
    @Override
    public String getMessage() {
        return "Numero de elementos separados por \";\" incorrectos";
    }
}
