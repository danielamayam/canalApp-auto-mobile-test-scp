package com.rimac.app.tasks.serviciosVehiculares;

import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiCrossellRenovacion.BTN_CONTINUAR;
import static com.rimac.app.userInterfaces.UiServiciosVehiculares.*;

public class SeleccionaLosDatosAsistenciasVehicularesAuxilioMecanico implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Tap.on(BTN_INICIAR_SOLICITUD),
                EsperarElemento.por(10),
                Tap.on(BTN_VEHICULO),
                Tap.siElElementoEsVisible(BTN_CANCELAR),
                WaitUntil.the(BTN_CONFIRMAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONFIRMAR),
                WaitUntil.the(BTN_NO_SABES_CUAL_ELEGIR, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_NO_SABES_CUAL_ELEGIR),
                WaitUntil.the(BTN_ELIGE_UNA_OPCION, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ELIGE_UNA_OPCION),
                WaitUntil.the(BTN_VEHICULO_NO_PRENDE, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_VEHICULO_NO_PRENDE),
                Tap.on(BTN_CONTINUAR ),
                WaitUntil.the(BTN_SI, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_SI),
                Tap.on(BTN_CONTINUAR ),
                WaitUntil.the(BTN_SI, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_SI),
                Tap.on(BTN_CONTINUAR ),
                WaitUntil.the(BTN_QUE_BUENO, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()

        );
    }

    public static SeleccionaLosDatosAsistenciasVehicularesAuxilioMecanico go(){
        return Tasks.instrumented(SeleccionaLosDatosAsistenciasVehicularesAuxilioMecanico.class);
    }
}
