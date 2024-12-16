package com.rimac.app.tasks.medicoADomicilio;

import com.rimac.app.interactions.Swipe;
import com.rimac.app.interactions.app.FormularioDireccion;
import com.rimac.app.interactions.app.FormularioSintomas;
import com.rimac.app.interactions.app.FormularioVerificarLosDatos;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiMeditoADomicilio.*;
import static com.rimac.app.userInterfaces.UiReembolso.LBL_SOLICITUD_RECIBIDA;

public class SinDependientes implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Swipe.as(actor).fromBottom().toTop(),
                Scroll.on(BTN_HOME_MEDICO_A_DOMICILIO),
                Tap.on(BTN_HOME_MEDICO_A_DOMICILIO),
                FormularioSintomas.go(),
                FormularioDireccion.go(),
                FormularioVerificarLosDatos.go(),
                WaitUntil.the(LBL_SOLICITUD_RECIBIDA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
        );
    }

    public static SinDependientes go() {
        return Tasks.instrumented(SinDependientes.class);
    }
}
