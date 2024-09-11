package com.rimac.app.util.enums;

public enum ConstantesHome {

    OPCION_HOME("Home"),
    OPCION_SEGUROS("Seguros"),
    OPCION_TRAMITES("Tramites"),
    OPCION_TIENDA("Tienda"),
    OPCION_PERFIL("Perfil");


    private final String clave;

    ConstantesHome(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }
}
