package com.rimac.app.tasks.serviciosVehiculares;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import static com.rimac.app.userInterfaces.UiServiciosVehiculares.BTN_IR_ATRAS;
import static com.rimac.app.userInterfaces.UiServiciosVehiculares.CARD_CHOFER_REMPLAZO;

public class ValidarCancelacionChoferReclamo implements Task {

    private String placa;

    public ValidarCancelacionChoferReclamo(String placa){
        this.placa = placa;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Tap.on(BTN_IR_ATRAS),
                EsperarElemento.por(10)
        );

        if (CARD_CHOFER_REMPLAZO(placa).isVisibleFor(actor)){
            throw new Assertions("No se cancelo correctamente el servicio chofer remplazo");
        }
    }

    public static ValidarCancelacionChoferReclamo go(String placa){
        return Tasks.instrumented(ValidarCancelacionChoferReclamo.class, placa);
    }

}
