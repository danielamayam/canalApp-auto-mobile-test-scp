package com.rimac.app.interactions.app;

import com.rimac.app.interactions.ComandosCapabilities;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.Swipe;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import com.rimac.app.util.enums.MenuSeguros;
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
                            Tap.siElElementoEsVisible(BTN_VEHICULAR_IOS.of(MenuSeguros.ITEM_VEHICULAR.getClave()))
                    ).otherwise(
                            Tap.siElElementoEsVisible(BTN_VEHICULAR_ANDROID.of(MenuSeguros.ITEM_VEHICULAR.getClave()))
                    ),
                    EsperarElemento.por(10),
                    Check.whether(SEGURO_VEHICULAR_CARD(vigencia, placa).resolveFor(actor).isVisible()).otherwise(
                            Swipe.as(actor).fromBottom().toTop()
                    ),
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
