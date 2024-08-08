package com.rimac.app.interactions;

import com.rimac.app.util.utilidadTecnica.interactions.ComandosCapabilities;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Scroll;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import com.rimac.app.util.utilidadTecnica.utils.enums.MenuSeguros;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiMenu.*;
import static com.rimac.app.userInterfaces.UiMenu.BTN_PAGOS;
import static com.rimac.app.userInterfaces.UiSeguros.*;

public class IrAPagosDePolizaVihicular implements Interaction {

    private String placa;
    private String vigencia;

    public IrAPagosDePolizaVihicular(String placa, String vigencia){
        this.placa = placa;
        this.vigencia = vigencia;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try{
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
                    WaitUntil.the(BTN_PAGOS, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Tap.on(BTN_PAGOS)
            );
        }catch (RuntimeException e){

        }
    }

    public static IrAPagosDePolizaVihicular go(String placa, String vigencia){
        return Instrumented.instanceOf(IrAPagosDePolizaVihicular.class).withProperties(placa, vigencia);
    }
}
