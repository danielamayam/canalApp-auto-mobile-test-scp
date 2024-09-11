package com.rimac.app.tasks.pagos;

import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiSeguros.*;

public class EliminarMedioDePago implements Task {

    private String tarjeta;

    public EliminarMedioDePago(String tarjeta){
        this.tarjeta = tarjeta;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String ultimos4Caracteres = tarjeta.length() > 4 ? tarjeta.substring(tarjeta.length() - 4) : tarjeta;
        System.out.println(ultimos4Caracteres);
        actor.attemptsTo(
                Scroll.on(BTN_HISTORIAL_DE_PAGOS),
                Tap.on(BTN_MEDIOS_DE_PAGO),
                WaitUntil.the(LBL_MIS_TARJETAS, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_NUMERO_TARJETA(ultimos4Caracteres)),
                Tap.on(BTN_ELIMINAR),
                Tap.on(BTN_SI_ELIMINAR),
                EsperarElemento.por(10)
        );
    }

    public static EliminarMedioDePago go(String tarjeta){
        return Tasks.instrumented(EliminarMedioDePago.class, tarjeta);
    }
}
