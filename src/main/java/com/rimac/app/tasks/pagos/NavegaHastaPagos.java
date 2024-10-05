package com.rimac.app.tasks.pagos;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.app.IrAPagosDePolizaVihicular;
import com.rimac.app.interactions.app.SkipAlerts;
import com.rimac.app.util.constantes.Mensajes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class NavegaHastaPagos implements Task {

    private String placa;
    private String vigencia;

    public NavegaHastaPagos(String placa, String vigencia){
        this.placa = placa;
        this.vigencia = vigencia;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    IrAPagosDePolizaVihicular.go(placa, vigencia)
            );
        }catch (RuntimeException ex){
            throw new Assertions(Assertions.Error(Mensajes.NAVEGA_HASTA_PAGOS), ex);
        }
    }

    public static NavegaHastaPagos go(String placa, String vigencia) {
        return Tasks.instrumented(NavegaHastaPagos.class, placa, vigencia);
    }
}
