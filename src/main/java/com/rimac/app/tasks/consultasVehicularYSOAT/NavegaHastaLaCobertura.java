package com.rimac.app.tasks.consultasVehicularYSOAT;

import com.rimac.app.interactions.ComandosCapabilities;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.app.IrAPagosDePolizaVihicular;
import com.rimac.app.interactions.app.MenuItem;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import com.rimac.app.util.enums.MenuSeguros;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiMenu.*;
import static com.rimac.app.userInterfaces.UiSeguros.SEGURO_VEHICULAR_CARD;
import static com.rimac.app.userInterfaces.UiServiciosVehiculares.BTN_ACCIDENTES_PERSONALES;

public class NavegaHastaLaCobertura implements Task {

    private String placa;
    private String vigencia;

    public NavegaHastaLaCobertura(String placa, String vigencia){
        this.placa = placa;
        this.vigencia = vigencia;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MenuItem.seguros(),
                Check.whether(ComandosCapabilities.isiOS(actor)).andIfSo(
                        Tap.on(BTN_VEHICULAR_IOS.of(MenuSeguros.ITEM_VEHICULAR.getClave()))
                ).otherwise(
                        Tap.on(BTN_VEHICULAR_ANDROID.of(MenuSeguros.ITEM_VEHICULAR.getClave()))
                ),
                EsperarElemento.por(10),
                Scroll.on(SEGURO_VEHICULAR_CARD(vigencia, placa)),
                Click.on(SEGURO_VEHICULAR_CARD(vigencia, placa)),
                WaitUntil.the(BTN_COBERTURA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_COBERTURA),
                WaitUntil.the(BTN_ACCIDENTES_PERSONALES, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ACCIDENTES_PERSONALES)
        );
    }

    public static NavegaHastaLaCobertura go(String placa, String vigencia){
        return Tasks.instrumented(NavegaHastaLaCobertura.class, placa, vigencia);
    }
}
