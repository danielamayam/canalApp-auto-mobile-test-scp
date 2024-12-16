package com.rimac.app.tasks.consultasVida;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.app.EsperaExplicita;
import com.rimac.app.interactions.app.MenuItem;
import com.rimac.app.interactions.builders.Tap;
import com.rimac.app.util.constantes.Mensajes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiConsultasVida.*;

public class NavegaHastaElDetalleSeguroVidaFlexible implements Task {

    private String vigencia;

    public NavegaHastaElDetalleSeguroVidaFlexible(String vigencia){
        this.vigencia = vigencia;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    MenuItem.seguros(),
                    EsperaExplicita.empleada(10),
                    Tap.siElElementoEsVisible(BTN_VIDA),
                    EsperarElemento.por(5),
                    Tap.on(CARD_VIDA_FLEXIBLE(vigencia)),
                    WaitUntil.the(LBL_DETALLE_DE_MI_POLIZA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
            );
        }catch (RuntimeException ex){
            throw new Assertions(Assertions.Error(Mensajes.NAVEGA_HASTA_EL_DETALLE_DEL_SEGURO_VIDA_FLEXIBLE), ex);
        }
    }

    public static NavegaHastaElDetalleSeguroVidaFlexible go(String vigencia){
        return Tasks.instrumented(NavegaHastaElDetalleSeguroVidaFlexible.class, vigencia);
    }
}
