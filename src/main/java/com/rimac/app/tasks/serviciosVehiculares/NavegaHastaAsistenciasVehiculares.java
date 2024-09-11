package com.rimac.app.tasks.serviciosVehiculares;

import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.app.MenuItem;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiMenu.BTN_VEHICULAR;
import static com.rimac.app.userInterfaces.UiServiciosVehiculares.*;

public class NavegaHastaAsistenciasVehiculares implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MenuItem.tramites(),
                //WaitUntil.the(BTN_VEHICULAR, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                //Tap.on(BTN_VEHICULAR),
                Scroll.on(BTN_ASISTENCIAS_VEHICULARES),
                Tap.on(BTN_ASISTENCIAS_VEHICULARES),
                WaitUntil.the(BTN_INICIAR_SOLICITUD, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
        );
    }

    public static NavegaHastaAsistenciasVehiculares go(){
        return Tasks.instrumented(NavegaHastaAsistenciasVehiculares.class);
    }
}
