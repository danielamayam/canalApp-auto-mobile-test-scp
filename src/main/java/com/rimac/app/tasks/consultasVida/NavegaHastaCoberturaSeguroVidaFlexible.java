package com.rimac.app.tasks.consultasVida;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.MenuItem;
import com.rimac.app.util.utilidadTecnica.interactions.TakeScreenshot;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import com.rimac.app.util.utilidadTecnica.utils.Mensajes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.rimac.app.userInterfaces.UiConsultasVida.*;
import static com.rimac.app.userInterfaces.UiMenu.BTN_COBERTURA;

public class NavegaHastaCoberturaSeguroVidaFlexible implements Task {

    private String vigencia;

    public NavegaHastaCoberturaSeguroVidaFlexible(String vigencia){
        this.vigencia = vigencia;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    MenuItem.seguros(),
                    WaitUntil.the(BTN_VIDA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Tap.on(BTN_VIDA),
                    Tap.on(CARD_VIDA_FLEXIBLE(vigencia)),
                    Tap.on(BTN_COBERTURA),
                    WaitUntil.the(LBL_DATOS_DEL_ASEGURADO, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Tap.on(BTN_COBERTURA_PRINCIPALES),
                    TakeScreenshot.asEvidence(),
                    Tap.on(BTN_COBERTURA_ADICIONALES),
                    TakeScreenshot.asEvidence()
            );
        }catch (RuntimeException ex){
            throw new Assertions(Assertions.Error(Mensajes.NAVEGA_HASTA_LA_COBERTURA_DEL_SEGURO_VIDA_FLEXIBLE), ex);
        }
    }

    public static NavegaHastaCoberturaSeguroVidaFlexible go(String vigencia){
        return Tasks.instrumented(NavegaHastaCoberturaSeguroVidaFlexible.class, vigencia);
    }
}