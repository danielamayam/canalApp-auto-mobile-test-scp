package com.rimac.app.util.utilidadTecnica.utils;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class HoraUI {
    public static final Target BTN_MODO_TEXTO = Target.the("Boton para seleccionar hora en modo texto").locatedForAndroid(AppiumBy.id("android:id/toggle_mode")).locatedForIOS(AppiumBy.name(""));
    public static final Target TXT_HORA = Target.the("Label para ingresar Hora").locatedForAndroid(AppiumBy.id("android:id/input_hour")).locatedForIOS(AppiumBy.name(""));
    public static final Target TXT_MINUTOS = Target.the("Label para ingresar minutos").locatedForAndroid(AppiumBy.id("android:id/input_minute")).locatedForIOS(AppiumBy.name(""));
    public static final Target BTN_ACEPTAR_FECHA = Target.the("Boton para aceptar la fecha/hora").locatedForAndroid(AppiumBy.id("android:id/button1")).locatedForIOS(AppiumBy.name(""));

    public HoraUI() {
    }
}
