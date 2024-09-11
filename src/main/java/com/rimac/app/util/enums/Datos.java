package com.rimac.app.util.enums;

public enum Datos {


    NOMBRE("Luz"),
    APELLIDO("Sosa"),
    CORREO("pruebas.movileschc@gmail.com");


    private final String clave;

    Datos(String clave){
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }


}
