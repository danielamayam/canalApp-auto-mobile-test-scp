package com.rimac.app.tasks.pagos;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.app.IrAPagosDePolizaSalud;
import com.rimac.app.interactions.app.IrAPagosDePolizaVihicular;
import com.rimac.app.interactions.builders.Tap;
import com.rimac.app.util.constantes.Mensajes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.rimac.app.userInterfaces.UiSeguros.*;

public class NavegaHastaElListadoDeCuotas implements Task {

    private String placa;
    private String vigencia;
    private String item ;

    public NavegaHastaElListadoDeCuotas(String placa, String vigencia, String item){
        this.placa = placa;
        this.vigencia = vigencia;
        this.item = item;
    }

    public NavegaHastaElListadoDeCuotas( String item){
        this.item = item;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try{
            switch (item){
                case "Vehicular":
                    actor.attemptsTo(
                            IrAPagosDePolizaVihicular.go(placa, vigencia),
                            Tap.on(BTN_PAGARCUOTAS),
                            Tap.siElElementoEsVisible(BTN_ALERTA_AUTOMATICO),
                            WaitUntil.the(CHKlISTADO, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
                    );
                    break;
                case "EPS":
                    actor.attemptsTo(
                            IrAPagosDePolizaSalud.go()
                    );
                    break;
            }
        }catch (RuntimeException ex){
            throw new Assertions(Assertions.Error(Mensajes.NAVEGA_HASTA_EL_LISTADO_DE_CUOTAS), ex);
        }
    }

    public static NavegaHastaElListadoDeCuotas vehiculos(String placa, String vigencia) {
        return Tasks.instrumented(NavegaHastaElListadoDeCuotas.class, placa, vigencia, "Vehicular");
    }

    public static NavegaHastaElListadoDeCuotas eps() {
        return Tasks.instrumented(NavegaHastaElListadoDeCuotas.class, "EPS");
    }
}
