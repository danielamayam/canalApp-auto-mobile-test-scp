package com.rimac.app.tasks.consultasVehicularYSOAT;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.TakeScreenshot;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import com.rimac.app.util.constantes.Mensajes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiConsultasVehicularSoat.LBL_PRECIO;
import static com.rimac.app.userInterfaces.UiSeguros.BTN_HISTORIAL_DE_PAGOS;
import static com.rimac.app.userInterfaces.UiSeguros.LBL_CONSULTA_TUS_PAGOS;

public class NavegaHastaElHistorialSeguroVehicular implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
       try {
           actor.attemptsTo(EsperarElemento.por(10));
           if (LBL_PRECIO.resolveFor(actor).isVisible()){
               actor.attemptsTo(
                       TakeScreenshot.asEvidence(),
                       Scroll.on(BTN_HISTORIAL_DE_PAGOS),
                       Tap.on(BTN_HISTORIAL_DE_PAGOS),
                       WaitUntil.the(LBL_CONSULTA_TUS_PAGOS, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
               );
           }else {
               throw new Assertions("El label del precio no está presente");
           }
       }catch (RuntimeException ex){
           throw new Assertions(Assertions.Error(Mensajes.NAVEGA_HASTA_EL_HISTORIAL_DE_SEGURO_VEHICULAR), ex);
       }

    }


    public static NavegaHastaElHistorialSeguroVehicular go(){
        return Tasks.instrumented(NavegaHastaElHistorialSeguroVehicular.class);
    }
}
