package com.rimac.app.tasks.consultasVida;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.MenuItem;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Scroll;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import com.rimac.app.util.utilidadTecnica.utils.Mensajes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiConsultasVida.*;

public class DescargarEstadoSeguroVidaFlexible implements Task {

    private String month;
    private String year;
    private String vigencia;

    public DescargarEstadoSeguroVidaFlexible(String month, String year, String vigencia){
        this.month = month;
        this.year = year;
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
                    Scroll.on(BTN_IR_A_ESTADO_DE_CUENTA),
                    Tap.on(BTN_IR_A_ESTADO_DE_CUENTA),
                    WaitUntil.the(BTN_DESCARGAR, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Tap.on(BTN_DESCARGAR),
                    EsperarElemento.por(10)
            );
        }catch (RuntimeException ex){
            throw new Assertions(Assertions.Error(Mensajes.DESCARGAR_ESTADO_DEL_SEGURO_VIDA_FLEXIBLE), ex);
        }
    }

    public static DescargarEstadoSeguroVidaFlexible go(String month, String year, String vigencia){
        return Tasks.instrumented(DescargarEstadoSeguroVidaFlexible.class, month, year, vigencia);
    }
}
