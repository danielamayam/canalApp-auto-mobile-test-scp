package com.rimac.app.util.enums;

public enum MenuSeguros {

    ITEM_TODOS("Todos"),
    ITEM_VEHICULAR("Vehicular"),
    ITEM_SOAT("SOAT"),
    ITEM_SALUD("Salud");


    private final String clave;

    MenuSeguros(String clave){
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }


}
