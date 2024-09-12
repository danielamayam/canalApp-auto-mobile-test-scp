package com.rimac.app.interactions.app;

import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UIAlertas.BTN_ALERTAS;
import static com.rimac.app.userInterfaces.UiLogin.TXT_USUARIO;
import static com.rimac.app.userInterfaces.UiMenu.BTN_HOME;

public class NewOmitirAlertas implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

//        boolean visible = false;
//
//        do {
//
//            visible = BTN_HOME.resolveFor(actor).isVisible();
//
//            ListOfWebElementFacades elements = BTN_ALERTAS.resolveAllFor(actor);
//
//            if (!visible){
//
//                actor.attemptsTo(
//                        Tap.on(BTN_ALERTAS(elements.size()))
//                );
//            }
//        }while (!visible);

        actor.attemptsTo(
                WaitUntil.the(BTN_ALERTAS, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
              Tap.siElElementoEsVisible(BTN_ALERTAS)
        );

    }

    public static NewOmitirAlertas home() {
        return Tasks.instrumented(NewOmitirAlertas.class);
    }
}
