package com.rimac.app.tasks.inactividad;


import com.rimac.app.interactions.app.MenuItem;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import static com.rimac.app.userInterfaces.UiServiciosDeSalud.BTN_DESCUENTOS;

public class NavegaHastaDescuentos implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MenuItem.tramites(),
                Scroll.on(BTN_DESCUENTOS),
                Tap.on(BTN_DESCUENTOS)
        );
    }

    public static NavegaHastaDescuentos go(){
        return Tasks.instrumented(NavegaHastaDescuentos.class);
    }
}
