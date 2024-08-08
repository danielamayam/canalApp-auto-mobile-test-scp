package com.rimac.app.util.utilidadTecnica.utils;

import com.rimac.app.util.utilidadTecnica.utils.enums.Meses;

public class FormatoFechas {
    private FormatoFechas() {
        throw new IllegalStateException("Error en FormatoFechas");
    }

    public static String[] separarFecha(String fecha) {
        return fecha.split("/");
    }

    public static String[] separarFechaGoogle(String fecha) {
        return fecha.split(" ");
    }

    public static String obtenerDia(String[] fecha) {
        return fecha[0];
    }

    public static String obtenerMesString(String[] fecha) {
        Meses[] var10000 = Meses.values();
        int var10001 = Integer.parseInt(fecha[1]);
        return Meses.valueOf("" + var10000[var10001 - 1]).getMes();
    }

    public static String obtenerMesInt(String fecha) {
        return Meses.valueOf(fecha.toUpperCase()).getDiaMes();
    }

    public static String obtenerYear(String[] fecha) {
        return fecha[2];
    }
}
