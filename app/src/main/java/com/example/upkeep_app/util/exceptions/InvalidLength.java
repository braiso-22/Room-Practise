package com.example.upkeep_app.util.exceptions;

import androidx.annotation.Nullable;

public class InvalidLength extends Exception {
    private Integer elementos;

    public InvalidLength() {

    }

    public InvalidLength(int num) {
        elementos = num;
    }

    @Nullable
    @Override
    public String getMessage() {

        return elementos != null ? String.format("Numero de elementos(%d) separados por \";\" incorrectos", elementos) : "Numero de elementos separados por \";\" incorrectos";
    }
}
