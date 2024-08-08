package com.rimac.app.interactions;

import com.rimac.app.util.TiempoInactividadApp;
import com.rimac.app.util.utilidadTecnica.interactions.Swipe;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class TiempoInactividadiOS implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EsperarElemento.por(3)
        );
        TiempoInactividadApp tiempoInactividadApp = new TiempoInactividadApp();
        tiempoInactividadApp.mapas();
        int contadorMinutos = 0;
        while (contadorMinutos < 12) {
            actor.attemptsTo(
                    Swipe.as(actor).fromBottom().toTop(),
                    EsperaExplicita.empleada(30),
                    Swipe.as(actor).fromBottom().toTop(),
                    EsperaExplicita.empleada(30),
                    Swipe.as(actor).fromBottom().toTop(),
                    EsperaExplicita.empleada(30),
                    Swipe.as(actor).fromBottom().toTop(),
                    EsperaExplicita.empleada(30)
            );
            contadorMinutos++;
        }
        EsperarElemento.por(3);
        tiempoInactividadApp.appRimac();
        Serenity.takeScreenshot();
        EsperarElemento.por(4);
    }

    public static TiempoInactividadiOS go() {
        return Instrumented.instanceOf(TiempoInactividadiOS.class).withProperties();
    }
}
