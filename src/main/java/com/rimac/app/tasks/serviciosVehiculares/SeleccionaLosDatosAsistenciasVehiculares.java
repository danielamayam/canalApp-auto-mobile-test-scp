package com.rimac.app.tasks.serviciosVehiculares;

import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.rimac.app.userInterfaces.UiServiciosVehiculares.*;
import static com.rimac.app.userInterfaces.UiServiciosVehiculares.BTN_CONFIRMAR_SOLICITUD;

public class SeleccionaLosDatosAsistenciasVehiculares implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Tap.on(BTN_INICIAR_SOLICITUD),
                EsperarElemento.por(15),
                Tap.siElElementoEsVisible(BTN_CANCELAR),
                WaitUntil.the(BTN_CONFIRMAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONFIRMAR),
                WaitUntil.the(BTN_AUXILIO_MECANICO, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_AUXILIO_MECANICO),
                WaitUntil.the(BTN_CAMBIO_LLANTA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CAMBIO_LLANTA),
                WaitUntil.the(BTN_SI_CUENTO, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_SI_CUENTO),
                WaitUntil.the(BTN_CONFIRMAR_SOLICITUD, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONFIRMAR_SOLICITUD),
                WaitUntil.the(LBL_MENSAJE_CHOFER, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()

        );
    }

    public static SeleccionaLosDatosAsistenciasVehiculares go(){
        return Tasks.instrumented(SeleccionaLosDatosAsistenciasVehiculares.class);
    }
}
