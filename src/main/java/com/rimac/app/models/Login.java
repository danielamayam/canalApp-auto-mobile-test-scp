package com.rimac.app.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Login {
    private String numeroUsuario;
    private String contrasena;

    public String getNumeroUsuario() {
        return numeroUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public static List<Login> setData(DataTable dataTable) {
        List<Login> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, Login.class));
        }
        return dates;
    }
}
