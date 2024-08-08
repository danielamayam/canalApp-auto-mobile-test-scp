package com.rimac.app.tasks.inactividad;

import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.MenuItem;
import com.rimac.app.util.utilidadTecnica.interactions.ComandosCapabilities;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Scroll;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import com.rimac.app.util.utilidadTecnica.utils.enums.MenuSeguros;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

import static com.rimac.app.userInterfaces.UiMenu.BTN_VEHICULAR_ANDROID;
import static com.rimac.app.userInterfaces.UiMenu.BTN_VEHICULAR_IOS;
import static com.rimac.app.userInterfaces.UiSeguros.SEGURO_VEHICULAR_CARD;

public class NavegaHastaDetalle implements Task {

    private String placa;
    private String vigencia;

    public NavegaHastaDetalle(String placa, String vigencia){
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
                Click.on(SEGURO_VEHICULAR_CARD(vigencia, placa))
        );
    }

    public static NavegaHastaDetalle go(String placa, String vigencia){
        return Tasks.instrumented(NavegaHastaDetalle.class, placa, vigencia);
    }
}
