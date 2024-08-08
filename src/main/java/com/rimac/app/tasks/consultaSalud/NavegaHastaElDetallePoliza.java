package com.rimac.app.tasks.consultaSalud;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.MenuItem;
import com.rimac.app.util.utilidadTecnica.interactions.ComandosCapabilities;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import com.rimac.app.util.utilidadTecnica.utils.Mensajes;
import com.rimac.app.util.utilidadTecnica.utils.enums.MenuSeguros;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiConsultasVida.LBL_NUMERO_DE_POLIZA;
import static com.rimac.app.userInterfaces.UiMenu.*;
import static com.rimac.app.userInterfaces.UiMenu.BTN_POLIZA;
import static com.rimac.app.userInterfaces.UiSeguros.BTN_VER_DETALLE;

public class NavegaHastaElDetallePoliza implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    MenuItem.seguros(),
                    Check.whether(ComandosCapabilities.isiOS(actor)).andIfSo(
                            Tap.on(BTN_VEHICULAR_IOS.of(MenuSeguros.ITEM_SALUD.getClave()))
                    ).otherwise(
                            Tap.on(BTN_VEHICULAR_ANDROID.of(MenuSeguros.ITEM_SALUD.getClave()))
                    ),
                    Tap.on(BTN_VER_DETALLE),
                    WaitUntil.the(BTN_POLIZA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Tap.on(BTN_POLIZA),
                    WaitUntil.the(LBL_NUMERO_DE_POLIZA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()

            );
        }catch (RuntimeException ex){
            throw new Assertions(Assertions.Error(Mensajes.NAVEGA_HASTA_EL_DETALLE_DE_LA_POLIZA), ex);
        }
    }

    public static NavegaHastaElDetallePoliza go(){
        return Tasks.instrumented(NavegaHastaElDetallePoliza.class);
    }
}
