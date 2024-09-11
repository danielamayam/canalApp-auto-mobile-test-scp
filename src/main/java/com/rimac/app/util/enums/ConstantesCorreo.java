package com.rimac.app.util.enums;

public enum ConstantesCorreo {


    CORREO_DESTINO("xt9116@rimac.com.pe"),
    CORREO_REMITENTE("autorimac.rpa@gmail.com");

    private final String clave;

    ConstantesCorreo(String clave){
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }


}
