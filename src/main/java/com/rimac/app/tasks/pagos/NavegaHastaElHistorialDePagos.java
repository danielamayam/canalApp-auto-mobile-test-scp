package com.rimac.app.tasks.pagos;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.ComandosCapabilities;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.app.IrAPagosDePolizaVihicular;
import com.rimac.app.interactions.app.MenuItem;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import com.rimac.app.util.constantes.Mensajes;
import com.rimac.app.util.enums.MenuSeguros;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiMenu.*;
import static com.rimac.app.userInterfaces.UiSeguros.*;

public class NavegaHastaElHistorialDePagos implements Task {

    private String placa;
    private String vigencia;

    public NavegaHastaElHistorialDePagos(String placa, String vigencia){
        this.placa = placa;
        this.vigencia = vigencia;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        try{
            actor.attemptsTo(
                    EsperarElemento.por(10),
                    IrAPagosDePolizaVihicular.go(placa, vigencia),
                    EsperarElemento.por(5),
                    Scroll.on(BTN_HISTORIAL_DE_PAGOS),
                    Tap.on(BTN_HISTORIAL_DE_PAGOS)
                   // WaitUntil.the(LBL_CONSULTA_TUS_PAGOS, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
            );
        }catch (RuntimeException ex){
            throw new Assertions(Assertions.Error(Mensajes.NAVEGA_HASTA_EL_HISTORIAL_DE_PAGOS), ex);
        }
    }

    public static NavegaHastaElHistorialDePagos go(String placa, String vigencia) {
        return Tasks.instrumented(NavegaHastaElHistorialDePagos.class, placa, vigencia);
    }
}
