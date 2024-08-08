package com.rimac.app.tasks.consultasVida;

import com.rimac.app.interactions.MenuItem;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.rimac.app.userInterfaces.UiConsultasVida.BTN_VIDA;
import static com.rimac.app.userInterfaces.UiConsultasVida.CARD_VIDA_FLEXIBLE;
import static com.rimac.app.userInterfaces.UiMenu.BTN_PAGOS;

public class NavegaHastaPagosVidaFlexible implements Task {

    private String vigencia;

    public NavegaHastaPagosVidaFlexible(String vigencia){
        this.vigencia = vigencia;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MenuItem.seguros(),
                WaitUntil.the(BTN_VIDA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_VIDA),
                Tap.on(CARD_VIDA_FLEXIBLE(vigencia)),
                Tap.on(BTN_PAGOS)
        );
    }

    public static NavegaHastaPagosVidaFlexible go(String vigencia){
        return Tasks.instrumented(NavegaHastaPagosVidaFlexible.class, vigencia);
    }
}
