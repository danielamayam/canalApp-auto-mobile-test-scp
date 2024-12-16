package com.rimac.app.interactions.app;

import com.rimac.app.interactions.ComandosCapabilities;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiMeditoADomicilio.*;

public class FormularioPaciente implements Interaction {

    private String paciente;

    public FormularioPaciente(String paciente) {
        this.paciente = paciente;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EsperaExplicita.empleada(10),
                WaitUntil.the(LBL_FORM_PACIENTE, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_SEGURO_Y_CONTRATANTE_DROPDOWN),
                EsperaExplicita.empleada(5),
                Check.whether(ComandosCapabilities.isiOS(actor)).andIfSo(
                        Tap.on(LBL_PACIENTE_IOS.of(paciente))
                ).otherwise(
                        Tap.on(LBL_PACIENTE.of(paciente))
                ),
                EsperaExplicita.empleada(10),
                Tap.on(BTN_VALIDAR_COBERTURA)
        );
    }


    public static FormularioPaciente go(String paciente) {
        return Instrumented.instanceOf(FormularioPaciente.class).withProperties(paciente);
    }
}
