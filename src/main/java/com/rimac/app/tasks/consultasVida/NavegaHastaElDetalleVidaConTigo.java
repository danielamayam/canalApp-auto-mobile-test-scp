package com.rimac.app.tasks.consultasVida;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.ComandosCapabilities;
import com.rimac.app.interactions.app.MenuItem;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import com.rimac.app.util.constantes.Mensajes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiConsultasVida.*;
import static com.rimac.app.userInterfaces.UiMenu.BTN_COBERTURA;

public class NavegaHastaElDetalleVidaConTigo implements Interaction {

    private String vigencia;

    public NavegaHastaElDetalleVidaConTigo(String vigencia){
        this.vigencia = vigencia;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    MenuItem.seguros(),
                    WaitUntil.the(BTN_VIDA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    //Tap.on(BTN_VIDA),
                    Scroll.on(CARD_SEGURO_VIDA_CONTIGO(vigencia)),
                    Tap.on(CARD_SEGURO_VIDA_CONTIGO(vigencia)),
                    WaitUntil.the(BTN_COBERTURA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
            );
        }catch (RuntimeException ex){
            throw new Assertions(Assertions.Error(Mensajes.NAVEGA_HASTA_EL_DETALLE_DEL_SEGURO_VIDA_CONTIGO), ex);
        }
    }

    public static NavegaHastaElDetalleVidaConTigo go(String vigencia){
        return Tasks.instrumented(NavegaHastaElDetalleVidaConTigo.class, vigencia);
    }
}
