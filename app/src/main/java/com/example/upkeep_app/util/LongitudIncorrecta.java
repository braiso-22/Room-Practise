package com.example.upkeep_app.util;

import androidx.annotation.Nullable;

class LongitudIncorrecta extends Exception {
    @Nullable
    @Override
    public String getMessage() {
        return "Numero de elementos separados por ; incorrectos";
    }
}
