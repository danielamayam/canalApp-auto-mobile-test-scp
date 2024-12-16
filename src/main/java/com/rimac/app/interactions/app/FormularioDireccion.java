package com.rimac.app.interactions.app;

import com.rimac.app.interactions.Hide;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiMeditoADomicilio.*;

public class FormularioDireccion implements Interaction {

    private String item;

    public FormularioDireccion(String item){
        this.item = item;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (item){
            case "registrar":
                actor.attemptsTo(
                        WaitUntil.the(LBL_FORM_DIRECCION, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                        Scroll.on(BTN_AGREGAR_DIRECCION),
                        Tap.on(BTN_AGREGAR_DIRECCION),
                        EsperaExplicita.empleada(10),
                        Tap.siElElementoEsVisible(BTN_CANCELAR),
                        Tap.siElElementoEsVisible(BTN_CERRAR_UBICACION),
                        Enter.theValue("Calle Quince").into(TXT_UBICACION),
                        EsperaExplicita.empleada(10),
                        Tap.on(LBL_UBICACION),
                        EsperaExplicita.empleada(10),
                        Tap.on(BTN_CONTINUAR),

                        Tap.on(BTN_UNA_CASA),
                        Enter.theValue("3").into(TXT_PISO),
                        Hide.keyboard(),
                        Tap.on(BTN_CASA),
                        Tap.on(BTN_CONTINUAR)
                );
                break;
           default:
               actor.attemptsTo(
                       WaitUntil.the(LBL_FORM_DIRECCION, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                       Tap.on(CARD_DIRECCION_UNO)
               );
                break;
        }


    }

    public static FormularioDireccion go(){
        return Instrumented.instanceOf(FormularioDireccion.class).withProperties("default");
    }

    public static FormularioDireccion agregarDireccion(){
        return Instrumented.instanceOf(FormularioDireccion.class).withProperties("registrar");
    }
}
