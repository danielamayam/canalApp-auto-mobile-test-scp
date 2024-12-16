package com.rimac.app.tasks.medicoADomicilio;

import com.rimac.app.interactions.Swipe;
import com.rimac.app.interactions.app.FormularioDireccion;
import com.rimac.app.interactions.app.FormularioPaciente;
import com.rimac.app.interactions.app.FormularioSintomas;
import com.rimac.app.interactions.app.FormularioVerificarLosDatos;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiMeditoADomicilio.BTN_HOME_MEDICO_A_DOMICILIO;
import static com.rimac.app.userInterfaces.UiReembolso.LBL_SOLICITUD_RECIBIDA;

public class VariosDependientes implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Swipe.as(actor).fromBottom().toTop(),
                Scroll.on(BTN_HOME_MEDICO_A_DOMICILIO),
                Tap.on(BTN_HOME_MEDICO_A_DOMICILIO),
                FormularioPaciente.go("Longhi Baller Stiwn - Cónyuge"),
                FormularioSintomas.go(),
                FormularioDireccion.go(),
                FormularioVerificarLosDatos.go(),
                WaitUntil.the(LBL_SOLICITUD_RECIBIDA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
        );
    }

    public static VariosDependientes go(){
        return Tasks.instrumented(VariosDependientes.class);
    }
}
