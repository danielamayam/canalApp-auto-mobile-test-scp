package com.rimac.app.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SuscripcionDesdePagos {

    private String numtarjeta;
    private String cvv;
    private String fecha;
    private String placa;
    private String vigencia;

    public String getNumtarjeta() {
        return numtarjeta;
    }

    public String getCvv() {
        return cvv;
    }

    public String getFecha() {
        return fecha;
    }

    public String getPlaca() {
        return placa;
    }

    public String getVigencia() {
        return vigencia;
    }

    public static List<SuscripcionDesdePagos> setData(DataTable dataTable) {
        List<SuscripcionDesdePagos> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, SuscripcionDesdePagos.class));
        }
        return dates;
    }
}
