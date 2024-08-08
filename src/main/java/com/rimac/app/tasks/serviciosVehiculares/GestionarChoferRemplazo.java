package com.rimac.app.tasks.serviciosVehiculares;

import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.MenuItem;
import com.rimac.app.util.utilidadTecnica.interactions.ComandosCapabilities;
import com.rimac.app.util.utilidadTecnica.interactions.Hide;
import com.rimac.app.util.utilidadTecnica.interactions.Swipe;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Scroll;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static com.rimac.app.userInterfaces.UiCrossellRenovacion.*;
import static com.rimac.app.userInterfaces.UiSeguros.BTN_GUARDAR_TARJETA;
import static com.rimac.app.userInterfaces.UiServiciosVehiculares.*;

public class GestionarChoferRemplazo implements Task {

    private String placa;

    public GestionarChoferRemplazo(String placa){
        this.placa = placa;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MenuItem.tramites(),
                //WaitUntil.the(BTN_VEHICULAR, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                //Tap.on(BTN_VEHICULAR),
                Scroll.on(BTN_CHOFER_DE_REMPLAZO),
                Tap.on(BTN_CHOFER_DE_REMPLAZO),
                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR ),
                Tap.siElElementoEsVisible(BTN_CANCELAR),
                EsperarElemento.por(40),
                Check.whether(ComandosCapabilities.isiOS(actor)).andIfSo(
                        Tap.on(TXT_PUNTO_DE_PARTIDA),
                        Enter.theValue("Calle Capón").into(TXT_PUNTO_DE_PARTIDA)
                ),
                Click.on(TXT_PUNTO_DE_DESTINO),
                Enter.theValue("Calle Capón").into(TXT_PUNTO_DE_DESTINO),
                Hide.keyboard(),
                Tap.on(LBL_CALLE),
                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR ),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                        WaitUntil.the(TXT_HORA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                        Tap.on(TXT_HORA),
                        Tap.on(BTN_ACEPTAR)
                ),
                Tap.on(BTN_CONTINUAR ),
                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR ),
                EsperarElemento.por(5),
                Swipe.as(actor).fromTop().toTop(),
                Tap.on(BTN_GUARDAR_TARJETA),
                WaitUntil.the(LBL_MENSAJE_CHOFER, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()

        );
    }

    public static GestionarChoferRemplazo go(String placa){
        return Tasks.instrumented(GestionarChoferRemplazo.class, placa);
    }
}
