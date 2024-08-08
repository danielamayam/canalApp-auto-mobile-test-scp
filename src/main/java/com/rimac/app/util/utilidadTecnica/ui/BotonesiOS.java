package com.rimac.app.util.utilidadTecnica.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class BotonesiOS {
    public static final Target BTN_DONE = Target.the("Botón Done teclado").located(AppiumBy.id("Done"));
    public static final Target BTN_OK = Target.the("Botón OK teclado").located(AppiumBy.id("OK"));

    private BotonesiOS() {
        throw new IllegalStateException("Error en BotonesiOS");
    }
}
