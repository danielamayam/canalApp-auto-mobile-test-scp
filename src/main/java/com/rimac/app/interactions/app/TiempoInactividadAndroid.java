package com.rimac.app.interactions.app;

import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.Swipe;
import com.rimac.app.util.TiempoInactividadApp;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.ScreenOrientation;

import static com.rimac.app.userInterfaces.UiInactividad.LBL_MENSAJE_INACTIVIDAD;
import static com.rimac.app.userInterfaces.UiSeguros.LBL_CONSULTA_TUS_PAGOS;

public class TiempoInactividadAndroid implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EsperarElemento.por(3)
        );
        TiempoInactividadApp tiempoInactividadApp = new TiempoInactividadApp();
        tiempoInactividadApp.inactividad("adb shell am start -n com.google.android.youtube/com.google.android.apps.youtube.app.WatchWhileActivity");
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
        tiempoInactividadApp.inactividad("adb shell am start -n com.rimac.rimac_surrogas.qa/com.rimac.rimac_surrogas.ui.main.MainActivity");
        Serenity.takeScreenshot();
        EsperarElemento.por(4);
        actor.attemptsTo(
                WaitUntil.the(LBL_MENSAJE_INACTIVIDAD, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
        );
    }

    public static TiempoInactividadAndroid go() {
        return Instrumented.instanceOf(TiempoInactividadAndroid.class).withProperties();
    }
}
