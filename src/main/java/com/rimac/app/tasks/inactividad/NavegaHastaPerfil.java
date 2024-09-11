package com.rimac.app.tasks.inactividad;

import com.rimac.app.interactions.app.MenuItem;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.rimac.app.userInterfaces.UiInactividad.BTN_MI_INFORMACION;
import static com.rimac.app.userInterfaces.UiInactividad.LBL_DATOS_PERSONALES;

public class NavegaHastaPerfil implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MenuItem.perfil(),
                Tap.on(BTN_MI_INFORMACION),
                WaitUntil.the(LBL_DATOS_PERSONALES, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()

        );
    }

    public static NavegaHastaPerfil go(){
        return Tasks.instrumented(NavegaHastaPerfil.class);
    }
}
