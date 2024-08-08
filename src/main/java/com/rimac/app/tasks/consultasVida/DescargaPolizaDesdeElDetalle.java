package com.rimac.app.tasks.consultasVida;


import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.MenuItem;
import com.rimac.app.util.utilidadTecnica.interactions.Swipe;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Scroll;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import com.rimac.app.util.utilidadTecnica.utils.Mensajes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiConsultasVida.*;


public class DescargaPolizaDesdeElDetalle implements Task {

    private String vigencia;

    public DescargaPolizaDesdeElDetalle(String vigencia) {
        this.vigencia = vigencia;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    MenuItem.seguros(),
                    WaitUntil.the(BTN_VIDA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Tap.on(BTN_VIDA),
                    Tap.on(CARD_SEGURO_VIDA_CONTIGO(vigencia)),
                    Scroll.on(LBL_MANUAL_DE_USO),
                    Swipe.as(actor).fromTop().toTop(),
                    WaitUntil.the(BTN_DESCARGAR_MANUAL, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Tap.on(BTN_DESCARGAR_MANUAL),
                    WaitUntil.the(PDF_VIEW, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
            );
        }catch (RuntimeException ex){
            throw new Assertions(Assertions.Error(Mensajes.DESCARGA_POLIZA_DESDE_EL_DETALLE), ex);
        }
    }


    public static DescargaPolizaDesdeElDetalle go(String vigencia) {
        return Tasks.instrumented(DescargaPolizaDesdeElDetalle.class, vigencia);
    }
}
