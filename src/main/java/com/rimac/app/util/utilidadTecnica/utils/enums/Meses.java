package com.rimac.app.util.utilidadTecnica.utils.enums;

public enum Meses {
    ENERO("01", "enero"),
    FEBRERO("02", "febrero"),
    MARZO("03", "marzo"),
    ABRIL("04", "abril"),
    MAYO("05", "mayo"),
    JUNIO("06", "junio"),
    JULIO("07", "julio"),
    AGOSTO("08", "agosto"),
    SEPTIEMBRE("09", "septiembre"),
    OCTUBRE("10", "octubre"),
    NOVIEMBRE("11", "noviembre"),
    DICIEMBRE("12", "diciembre");

    String diaMes;
    String mes;

    private Meses(String diaMes, String mes) {
        this.diaMes = diaMes;
        this.mes = mes;
    }

    public String getMes() {
        return this.mes;
    }

    public String getDiaMes() {
        return this.diaMes;
    }
}
