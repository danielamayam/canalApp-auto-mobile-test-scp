package com.rimac.app.userInterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class BotonesiOS {
    public static final Target BTN_DONE = Target.the("Botón Done teclado").located(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Done\"]"));
    public static final Target BTN_OK = Target.the("Botón OK teclado").located(AppiumBy.id("OK"));
    public static final Target BTN_DONE_ANDROID = Target.the("Botón Done teclado").located(AppiumBy.xpath("//android.view.View[@content-desc='Done']"));
    private BotonesiOS() {
        throw new IllegalStateException("Error en BotonesiOS");
    }
}