package com.rimac.app.interactions.app;

import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiReembolso.*;


public class TomarFoto implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_TOMAR_FOTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_TOMAR_FOTO),
                EsperarElemento.por(5),
                Tap.on(BTN_CAPTURAR_FOTO),
                WaitUntil.the(BTN_USAR_FOTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_USAR_FOTO)
        );
    }

    public static TomarFoto go() {
        return Instrumented.instanceOf(TomarFoto.class).withProperties();
    }
}
