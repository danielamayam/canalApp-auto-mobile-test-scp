package com.rimac.app.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Reembolso {

    private String productoContratante;
    private String lugarAtencion;
    private String tipoCobertura;

    public String getProductoContratante() {
        return productoContratante;
    }

    public String getLugarAtencion() {
        return lugarAtencion;
    }

    public String getTipoCobertura() {
        return tipoCobertura;
    }

    public static List<Reembolso> setData(DataTable dataTable) {
        List<Reembolso> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, Reembolso.class));
        }
        return dates;
    }
}
