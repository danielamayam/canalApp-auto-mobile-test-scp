package com.rimac.app.interactions.app;

import com.rimac.app.interactions.ComandosCapabilities;
import com.rimac.app.interactions.builders.Tap;
import com.rimac.app.util.enums.MenuSeguros;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.rimac.app.userInterfaces.UiMenu.*;
import static com.rimac.app.userInterfaces.UiMenu.BTN_PAGOS;
import static com.rimac.app.userInterfaces.UiSeguros.BTN_VER_DETALLES;


public class IrAPagosDePolizaSalud implements Interaction {


    public IrAPagosDePolizaSalud(){
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try{
            actor.attemptsTo(
                    MenuItem.seguros(),
                    Check.whether(ComandosCapabilities.isiOS(actor)).andIfSo(
                            Tap.siElElementoEsVisible(BTN_VEHICULAR_IOS.of(MenuSeguros.ITEM_SALUD.getClave()))
                    ).otherwise(
                            Tap.siElElementoEsVisible(BTN_VEHICULAR_ANDROID.of(MenuSeguros.ITEM_SALUD.getClave()))
                    ),
                    Tap.on(BTN_VER_DETALLES),
                    WaitUntil.the(BTN_PAGOS, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Tap.on(BTN_PAGOS)

            );
        }catch (RuntimeException e){

        }
    }

    public static IrAPagosDePolizaSalud go(){
        return Instrumented.instanceOf(IrAPagosDePolizaSalud.class).withProperties();
    }
}
