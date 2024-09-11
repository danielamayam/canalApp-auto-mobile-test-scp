package com.rimac.app.tasks.serviciosVehiculares;

import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiServiciosVehiculares.*;

public class SeleccionaLosDatosAsistenciasVehicularesProblema implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Tap.on(BTN_INICIAR_SOLICITUD),
                EsperarElemento.por(10),
                Tap.siElElementoEsVisible(BTN_CANCELAR),
                WaitUntil.the(BTN_CONFIRMAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONFIRMAR),
                WaitUntil.the(BTN_AUXILIO_MECANICO, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_AUXILIO_MECANICO),
                WaitUntil.the(BTN_BATERIA_BAJA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_BATERIA_BAJA),
                WaitUntil.the(BTN_CONFIRMAR_SOLICITUD, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONFIRMAR_SOLICITUD),
                WaitUntil.the(LBL_MENSAJE_CHOFER, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()

        );
    }

    public static SeleccionaLosDatosAsistenciasVehicularesProblema go(){
        return Tasks.instrumented(SeleccionaLosDatosAsistenciasVehicularesProblema.class);
    }
}
