package com.rimac.app.tasks.pagos;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.MenuItem;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Scroll;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import com.rimac.app.util.utilidadTecnica.utils.Mensajes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiConsultasVehicularSoat.*;
import static com.rimac.app.userInterfaces.UiMenu.BTN_PAGOS;
import static com.rimac.app.userInterfaces.UiSeguros.LBL_PAGADO;

public class NavegaHastaPagosSoat implements Task {

    private String placa;
    private String vigencia;

    public NavegaHastaPagosSoat(String placa, String vigencia){
        this.placa = placa;
        this.vigencia = vigencia;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    MenuItem.seguros(),
                    WaitUntil.the(BTN_SOAT, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Tap.on(BTN_SOAT),
                    Scroll.on(CARD_SOAT(placa, vigencia)),
                    Tap.on(CARD_SOAT(placa, vigencia)),
                    WaitUntil.the(BTN_PAGOS, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Tap.on(BTN_PAGOS),
                    WaitUntil.the(LBL_PAGADO, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()

            );
        }catch (RuntimeException ex){
            throw new Assertions(Assertions.Error(Mensajes.NAVEGA_HASTA_PAGOS_SOAT), ex);
        }
    }

    public static NavegaHastaPagosSoat go(String placa, String vigencia){
        return Tasks.instrumented(NavegaHastaPagosSoat.class, placa, vigencia);
    }
}
