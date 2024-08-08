package com.rimac.app.interactions;

import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.rimac.app.userInterfaces.UiCrossellRenovacion.BTN_CONTINUAR;
import static com.rimac.app.userInterfaces.UiServiciosDeSalud.*;

public class FormularioClinica implements Interaction {

    private String nombre;

    public FormularioClinica(String nombre){
        this.nombre = nombre;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Tap.on(BTN_PACIENTE),
                WaitUntil.the(LBL_PACIENTE, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(LBL_PACIENTE),
                Tap.on(BTN_CONTINUAR),
                EsperarElemento.por(5),
                Tap.siElElementoEsVisible(BTN_CANCELAR_LACALIZACION),
                Tap.on(BTN_BUSCAR),
                Enter.theValue(nombre).into(TXT_BUSCAR),
                Tap.on(LBL_BUSCADO),
                WaitUntil.the(LBL_COPAGO, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
        );
    }


    public static FormularioClinica go(String nombre){
        return Instrumented.instanceOf(FormularioClinica.class).withProperties(nombre);
    }
}
