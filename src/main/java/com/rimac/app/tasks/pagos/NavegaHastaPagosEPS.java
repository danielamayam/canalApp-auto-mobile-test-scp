package com.rimac.app.tasks.pagos;

import com.rimac.app.interactions.app.MenuItem;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiMenu.BTN_PAGOS;
import static com.rimac.app.userInterfaces.UiSeguros.BTN_DETALLE;
import static com.rimac.app.userInterfaces.UiSeguros.LBL_MENSAJE_2;

public class NavegaHastaPagosEPS implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MenuItem.seguros(),
                WaitUntil.the(BTN_DETALLE, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_DETALLE),
                WaitUntil.the(BTN_PAGOS, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_PAGOS),
                WaitUntil.the(LBL_MENSAJE_2, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()

        );
    }

    public static NavegaHastaPagosEPS go(){
        return Tasks.instrumented(NavegaHastaPagosEPS.class);
    }
}
