package com.rimac.app.tasks.serviciosVehiculares;

import com.rimac.app.interactions.ComandosCapabilities;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.Hide;
import com.rimac.app.interactions.Swipe;
import com.rimac.app.interactions.app.MenuItem;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.findby.By;
import static com.rimac.app.interactions.app.SerenitySwipeAction.swipeUntilTextFound;
import static com.rimac.app.userInterfaces.UiCrossellRenovacion.*;
import static com.rimac.app.userInterfaces.UiCrossellRenovacion.BTN_INICIAR_SOLICITUD;
import static com.rimac.app.userInterfaces.UiMenu.BTN_VEHICULAR;
import static com.rimac.app.userInterfaces.UiServiciosVehiculares.*;

public class GestionarChoferRemplazo implements Task {

    private String placa;

    public GestionarChoferRemplazo(String placa) {
        this.placa = placa;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MenuItem.tramites(),
                EsperarElemento.por(10),
                Tap.siElElementoEsVisible(BTN_VEHICULAR),
                Swipe.as(actor).fromBottom().toTop(),
                Tap.on(BTN_CHOFER_DE_REMPLAZO),
                EsperarElemento.por(10),
                Check.whether(BTN_INICIAR_SOLICITUD.isVisibleFor(actor)).andIfSo(
                        WaitUntil.the(BTN_INICIAR_SOLICITUD, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                        Tap.on(BTN_INICIAR_SOLICITUD)
                ),
                EsperarElemento.por(20),
                /*Tap.on(BTN_VEHICULO),
                Tap.siElElementoEsVisible(BTN_CANCELAR),
                EsperarElemento.por(40),

                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                        Tap.on(TXT_PUNTO_DE_PARTIDA),
                        Enter.theValue("Calle Capón").into(TXT_PUNTO_DE_PARTIDA),
                        Hide.keyboard(),
                        EsperarElemento.por(3),
                        Tap.on(LBL_CALLE("Calle Capón")),

                        Click.on(TXT_PUNTO_DE_DESTINO),
                        Enter.theValue("Calle Quince").into(TXT_PUNTO_DE_DESTINO),
                        Hide.keyboard(),
                        EsperarElemento.por(3),
                        Tap.on(LBL_CALLE("Calle Quince"))
                ).otherwise(
                        Enter.theValue("Calle Capón").into(TXT_PUNTO_DE_PARTIDA_NEW_UI),
                        Hide.keyboard(),
                        EsperarElemento.por(3),
                        Tap.on(LBL_CALLE("Calle Capón")),
                        EsperarElemento.por(10),

                        Enter.theValue("Calle Quince").into(TXT_PUNTO_DE_DESTINO_NEW_UI),
                        Hide.keyboard(),
                        EsperarElemento.por(3),
                        Tap.on(LBL_CALLE("Calle Quince"))


                ),

                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                        WaitUntil.the(TXT_HORA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                        Tap.on(TXT_HORA),
                        Tap.on(BTN_ACEPTAR)
                ),
                Tap.on(BTN_CONTINUAR),
                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),
                EsperarElemento.por(10),
                Swipe.as(actor).fromTop().toTop(),
                WaitUntil.the(LBL_MENSAJE_CHOFER, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_VOLVER_AL_INICIO),
                MenuItem.home(),*/
                WaitUntil.the(LBL_SOLICITUD_CHOFER_REMPLAZO, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
        );
    }


    public static GestionarChoferRemplazo go(String placa) {
        return Tasks.instrumented(GestionarChoferRemplazo.class, placa);
    }
}
