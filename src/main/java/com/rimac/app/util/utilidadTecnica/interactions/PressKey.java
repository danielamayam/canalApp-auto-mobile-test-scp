package com.rimac.app.util.utilidadTecnica.interactions;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class PressKey implements Interaction {
    public PressKey() {
    }

    public static PressKey enter() {
        return new PressKey();
    }

    public <T extends Actor> void performAs(T actor) {
        if (ComandosCapabilities.isAndroid(actor)) {
            GetDriver.as(actor).androidDriver().pressKey(new KeyEvent(AndroidKey.ENTER));
        }

    }
}