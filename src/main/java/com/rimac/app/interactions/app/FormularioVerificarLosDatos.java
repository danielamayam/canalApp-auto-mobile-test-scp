package com.rimac.app.interactions.app;

import com.rimac.app.interactions.Hide;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiMeditoADomicilio.*;

public class FormularioVerificarLosDatos implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

        if (ERROR_TXT_CELULAR.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    Enter.theValue("9999999999").into(TXT_CELULAR),
                    Hide.keyboard()
            );
        }

        actor.attemptsTo(
                WaitUntil.the(BTN_ENVIAR_SOLICITUD, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ENVIAR_SOLICITUD));

    }

    public static FormularioVerificarLosDatos go() {
        return Instrumented.instanceOf(FormularioVerificarLosDatos.class).withProperties();
    }
}
