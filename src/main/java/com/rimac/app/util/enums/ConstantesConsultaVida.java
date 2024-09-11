package com.rimac.app.util.enums;

public enum ConstantesConsultaVida {

    PLAN_VIDA_CONTIGO("Vida Contigo"),
    PLAN_VIDA_FLEXIBLE("Vida Flexible");

    private final String clave;

    ConstantesConsultaVida(String clave){
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }
}
