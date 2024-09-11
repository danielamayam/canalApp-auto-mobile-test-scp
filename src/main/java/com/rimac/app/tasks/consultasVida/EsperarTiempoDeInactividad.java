package com.rimac.app.tasks.consultasVida;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.ComandosCapabilities;
import com.rimac.app.interactions.app.TiempoInactividadiOS;
import com.rimac.app.interactions.app.TiempoInactividadAndroid;
import com.rimac.app.util.constantes.Mensajes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;

public class EsperarTiempoDeInactividad implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Check.whether(ComandosCapabilities.isiOS(actor)).andIfSo(TiempoInactividadiOS.go()).otherwise(TiempoInactividadAndroid.go())

            );
        }catch (RuntimeException ex){
            throw new Assertions(Assertions.Error(Mensajes.ESPERAR_TIEMPO_DE_INACTIVIDAD), ex);
        }
    }

    public static EsperarTiempoDeInactividad go(){
        return Tasks.instrumented(EsperarTiempoDeInactividad.class);
    }
}
