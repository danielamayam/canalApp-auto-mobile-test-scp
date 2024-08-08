package com.rimac.app.util.utilidadTecnica.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatoHora {
    private FormatoHora() {
        throw new IllegalStateException("Error en FormatoHora");
    }

    public static String[] separarHora(String hora) {
        return hora.split(":");
    }

    public static String obtenerHora(String[] hora) {
        return hora[0];
    }

    public static String obtenerMinutos(String[] hora) {
        return hora[1];
    }

    public static String obtenerMeridiem(String hora) {
        return hora.split(" ")[1];
    }

    public static String parseHora(String hora) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
            Date dateObj = sdf.parse(hora);
            return (new SimpleDateFormat("K:mm a")).format(dateObj);
        } catch (ParseException var3) {
            return "";
        }
    }
}
