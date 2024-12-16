package com.rimac.app.tasks.medicoADomicilio;

import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.app.EsperaExplicita;
import com.rimac.app.interactions.app.MenuItem;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.rimac.app.userInterfaces.UiConsultasVehicularSoat.BTN_SALUD;
import static com.rimac.app.userInterfaces.UiMeditoADomicilio.CARD_SALUD;

public class VariasPolizasSinDependientesDesdeSeguros implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MenuItem.seguros(),
                EsperarElemento.por(10),
                WaitUntil.the(BTN_SALUD, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.siElElementoEsVisible(BTN_SALUD),
                EsperaExplicita.empleada(10),
                Tap.on(CARD_SALUD)
        );
    }

    public static VariasPolizasSinDependientesDesdeSeguros go(){
        return Tasks.instrumented(VariasPolizasSinDependientesDesdeSeguros.class);
    }
}
