package com.rimac.app.interactions.app;

import com.rimac.app.interactions.ComandosCapabilities;
import com.rimac.app.interactions.Hide;
import com.rimac.app.interactions.Swipe;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiMeditoADomicilio.*;

public class FormularioSintomas implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LBL_FORM_SINTOMAS, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Check.whether(ComandosCapabilities.isiOS(actor)).andIfSo(
                        Tap.on(BTN_SINTOMA_IOS.of("Dolor de cabeza"))
                ).otherwise(Tap.on(BTN_SINTOMA.of("Dolor de cabeza"))),
                Tap.on(BTN_RESPIRATORIOS_DROPDOWN),
                Check.whether(ComandosCapabilities.isiOS(actor)).andIfSo(
                        Tap.on(BTN_SINTOMA_IOS.of("Congestión nasal"))
                ).otherwise(Tap.on(BTN_SINTOMA.of("Congestión nasal"))),
                Tap.on(BTN_MUSCULOESQUELETICOS_DROPDOWN),
                Check.whether(ComandosCapabilities.isiOS(actor)).andIfSo(
                        Tap.on(BTN_SINTOMA_IOS.of("Dolor de cuello"))
                ).otherwise(Tap.on(BTN_SINTOMA.of("Dolor de cuello"))),
                Scroll.on(BTN_DIGESTIVOS_DROPDOWN),
                Tap.on(BTN_DIGESTIVOS_DROPDOWN),
                Check.whether(ComandosCapabilities.isiOS(actor)).andIfSo(
                        Tap.on(BTN_SINTOMA_IOS.of("Acidez"))
                ).otherwise(Tap.on(BTN_SINTOMA.of("Acidez"))),
                Scroll.on(BTN_URINARIOS_DROPDOWN),
                Tap.on(BTN_URINARIOS_DROPDOWN),
                Check.whether(ComandosCapabilities.isiOS(actor)).andIfSo(
                        Tap.on(BTN_SINTOMA_IOS.of("Aumento en la frecuencia urinaria"))
                ).otherwise(Tap.on(BTN_SINTOMA.of("Aumento en la frecuencia urinaria"))),
                Scroll.on(BTN_DERMATOLOGICOS_DROPDOWN),
                Tap.on(BTN_DERMATOLOGICOS_DROPDOWN),
                Check.whether(ComandosCapabilities.isiOS(actor)).andIfSo(
                        Tap.on(BTN_SINTOMA_IOS.of("Calor en la piel"))
                ).otherwise(Tap.on(BTN_SINTOMA.of("Calor en la piel"))),
                Swipe.as(actor).fromBottom().toTop(),
                Scroll.on(BTN_DIAS_DE_SINTOMAS_DROPDOWN),
                Tap.on(BTN_DIAS_DE_SINTOMAS_DROPDOWN),
                Tap.on(RC_DIAS),
                Scroll.on(TXT_ANTECEDENTES),
                Enter.theValue("1").into(TXT_ANTECEDENTES),
                Hide.keyboard(),
                Tap.on(BTN_CONTINUAR)
        );
    }


    public static FormularioSintomas go() {
        return Instrumented.instanceOf(FormularioSintomas.class).withProperties();
    }
}
