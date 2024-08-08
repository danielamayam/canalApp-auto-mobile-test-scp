package com.rimac.app.util.utilidadTecnica.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class TakeScreenshot implements Interaction {
    public TakeScreenshot() {
    }

    public static TakeScreenshot asEvidence() {
        return (TakeScreenshot) Tasks.instrumented(TakeScreenshot.class, new Object[0]);
    }

    public <T extends Actor> void performAs(T actor) {
        Serenity.takeScreenshot();
    }
}
