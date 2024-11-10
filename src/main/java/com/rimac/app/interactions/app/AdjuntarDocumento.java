package com.rimac.app.interactions.app;

import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiReembolso.*;

public class AdjuntarDocumento implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO)
        );
    }

    public static AdjuntarDocumento go(){
        return Instrumented.instanceOf(AdjuntarDocumento.class).withProperties();
    }
}