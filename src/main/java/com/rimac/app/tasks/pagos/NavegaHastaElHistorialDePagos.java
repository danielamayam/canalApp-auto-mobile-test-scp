package com.rimac.app.tasks.pagos;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.IrAPagosDePolizaVihicular;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Scroll;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import com.rimac.app.util.utilidadTecnica.utils.Mensajes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

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
                    IrAPagosDePolizaVihicular.go(placa, vigencia),
                    EsperarElemento.por(5),
                    Scroll.on(BTN_HISTORIAL_DE_PAGOS),
                    Tap.on(BTN_HISTORIAL_DE_PAGOS),
                    WaitUntil.the(LBL_CONSULTA_TUS_PAGOS, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
            );
        }catch (RuntimeException ex){
            throw new Assertions(Assertions.Error(Mensajes.NAVEGA_HASTA_EL_HISTORIAL_DE_PAGOS), ex);
        }
    }

    public static NavegaHastaElHistorialDePagos go(String placa, String vigencia) {
        return Tasks.instrumented(NavegaHastaElHistorialDePagos.class, placa, vigencia);
    }
}
