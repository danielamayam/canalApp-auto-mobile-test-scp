package com.rimac.app.tasks.consultasVehicularYSOAT;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.MenuItem;
import com.rimac.app.util.utilidadTecnica.interactions.ComandosCapabilities;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Scroll;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import com.rimac.app.util.utilidadTecnica.utils.Mensajes;
import com.rimac.app.util.utilidadTecnica.utils.enums.MenuSeguros;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiConsultasVehicularSoat.BTN_DESCARGAR_POLIZA_DIGITAL;
import static com.rimac.app.userInterfaces.UiConsultasVida.PDF_VIEW;
import static com.rimac.app.userInterfaces.UiMenu.*;
import static com.rimac.app.userInterfaces.UiSeguros.SEGURO_VEHICULAR_CARD;

public class DescargarPolizaDigital implements Task {

    private String placa;
    private String vigencia;

    public DescargarPolizaDigital(String placa, String vigencia){
        this.placa = placa;
        this.vigencia = vigencia;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    MenuItem.seguros(),
                    Check.whether(ComandosCapabilities.isiOS(actor)).andIfSo(
                            Tap.on(BTN_VEHICULAR_IOS.of(MenuSeguros.ITEM_VEHICULAR.getClave()))
                    ).otherwise(
                            Tap.on(BTN_VEHICULAR_ANDROID.of(MenuSeguros.ITEM_VEHICULAR.getClave()))
                    ),
                    Scroll.on(SEGURO_VEHICULAR_CARD(vigencia, placa)),
                    Tap.on(SEGURO_VEHICULAR_CARD(vigencia, placa)),
                    WaitUntil.the(BTN_POLIZA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Tap.on(BTN_POLIZA),
                    WaitUntil.the(BTN_DESCARGAR_POLIZA_DIGITAL, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Tap.on(BTN_DESCARGAR_POLIZA_DIGITAL),
                    EsperarElemento.por(15),
                    WaitUntil.the(PDF_VIEW, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
            );
        }catch (RuntimeException ex){
            throw new Assertions(Assertions.Error(Mensajes.DESCARGA_POLIZA_DIGITAL), ex);
        }
    }

    public static DescargarPolizaDigital go(String placa, String vigencia){
        return Tasks.instrumented(DescargarPolizaDigital.class, placa, vigencia);
    }
}
