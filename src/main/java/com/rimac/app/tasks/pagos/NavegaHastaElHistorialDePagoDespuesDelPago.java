package com.rimac.app.tasks.pagos;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import com.rimac.app.util.constantes.Mensajes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiSeguros.*;

public class NavegaHastaElHistorialDePagoDespuesDelPago implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Tap.on(BTN_IR_AL_INICIO),
                    Scroll.on(BTN_HISTORIAL_DE_PAGOS),
                    Tap.on(BTN_HISTORIAL_DE_PAGOS),
                    WaitUntil.the(LBL_CONSULTA_TUS_PAGOS, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
            );
        }catch (RuntimeException ex){
            throw new Assertions(Assertions.Error(Mensajes.NAVEGA_HASTA_EL_HISTORIAL_DE_PAGO_DESPUES_DEL_PAGO), ex);
        }
    }

    public static NavegaHastaElHistorialDePagoDespuesDelPago go(){
        return Tasks.instrumented(NavegaHastaElHistorialDePagoDespuesDelPago.class);
    }
}
