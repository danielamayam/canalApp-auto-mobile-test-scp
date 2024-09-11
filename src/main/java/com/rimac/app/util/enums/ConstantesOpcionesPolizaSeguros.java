package com.rimac.app.util.enums;

public enum ConstantesOpcionesPolizaSeguros {

    OPCION_POLIZA("Póliza"),
    OPCION_COBERTURA("Cobertura"),
    OPCION_BENEFICIOS("Beneficios"),
    OPCION_INVERSION("Inversión"),
    OPCION_PORTAFOLIO("Portafolio"),
    OPCION_PAGOS("Pagos");



    private final String clave;

    ConstantesOpcionesPolizaSeguros(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

}
