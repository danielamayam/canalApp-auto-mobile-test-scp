package com.rimac.app.exceptions;

public class Assertions extends AssertionError{

    private static final long serialVersionUID = 1L;
    public static final String EL_NUMERO_DE_POLIZA_NO_ES_EL_CORRECTO_AL_ESPERADO = "El número de póliza no es el correcto al esperado.";
    public static final String EL_TARGET_NO_ES_EL_ESPERADO = "El elemento de la pantalla no es el esperado o no se encontró el esperado.";

    public Assertions(String message, Throwable cause) {
        super(message, cause);
    }

    public Assertions(String message) {
        super(message);
    }

    private static final String ERROR = "Error en la clase";

    public static String Error(String donde) {
        return ERROR + donde;
    }
}
