package com.rimac.app.tasks.medicoADomicilio;

import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.app.*;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiMeditoADomicilio.BTN_MEDICO_A_DOMICILIO;
import static com.rimac.app.userInterfaces.UiReembolso.LBL_SOLICITUD_RECIBIDA;

public class VariasPolizasVariosDependientesDesdeTramites implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MenuItem.tramites(),
                EsperarElemento.por(10),
                Tap.on(BTN_MEDICO_A_DOMICILIO),
                FormularioPacienteSeguroYContratante.go("3"),
                FormularioSintomas.go(),
                FormularioDireccion.go(),
                FormularioVerificarLosDatos.go(),
                WaitUntil.the(LBL_SOLICITUD_RECIBIDA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
        );
    }


    public static VariasPolizasVariosDependientesDesdeTramites go(){
        return Tasks.instrumented(VariasPolizasVariosDependientesDesdeTramites.class);
    }
}
