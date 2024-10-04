package com.rimac.app.tasks.serviciosVehiculares;

import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.rimac.app.userInterfaces.UiServiciosVehiculares.*;

public class CancelarChoferRemplazo implements Task {

    private String placa;

    public CancelarChoferRemplazo(String placa){
        this.placa = placa;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EsperarElemento.por(50),
                Scroll.on(CARD_CHOFER_REMPLAZO(placa)),
                WaitUntil.the(CARD_CHOFER_REMPLAZO(placa), WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(CARD_CHOFER_REMPLAZO(placa)),
                WaitUntil.the(BTN_CANCELAR_SERVICIO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CANCELAR_SERVICIO),
                WaitUntil.the(BTN_SI_CANCELAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_SI_CANCELAR),
                WaitUntil.the(LBL_SOLICITUD_CANCELADA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
        );
    }

    public static CancelarChoferRemplazo go(String placa){
        return Tasks.instrumented(CancelarChoferRemplazo.class, placa);
    }
}
