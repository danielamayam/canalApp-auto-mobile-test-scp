package com.rimac.app.tasks.consultasVehicularYSOAT;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.app.MenuItem;
import com.rimac.app.interactions.builders.Tap;
import com.rimac.app.util.constantes.Mensajes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.rimac.app.userInterfaces.UiConsultasVehicularSoat.*;

public class NavegaHastaElResumen implements Task {

    private String placa;

    public NavegaHastaElResumen(String placa){
        this.placa = placa;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    MenuItem.seguros(),
                    WaitUntil.the(BTN_SOAT, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Tap.on(BTN_SOAT),
                    EsperarElemento.por(5),
                    Tap.on(CARD_SOAT_PLACA(placa)),
                    Tap.on(BTN_VER_RESUMEN),
                    WaitUntil.the(LBL_NUMERO_POLIZA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()

            );
        }catch (RuntimeException ex){
            throw new Assertions(Assertions.Error(Mensajes.NAVEGA_HASTA_EL_RESUMEN), ex);
        }
    }

    public static NavegaHastaElResumen go(String placa){
        return Tasks.instrumented(NavegaHastaElResumen.class, placa);
    }
}
