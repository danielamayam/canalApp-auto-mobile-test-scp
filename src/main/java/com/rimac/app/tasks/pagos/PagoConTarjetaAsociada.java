package com.rimac.app.tasks.pagos;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.ComandosCapabilities;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.app.SkipAlerts;
import com.rimac.app.interactions.builders.Tap;
import com.rimac.app.util.constantes.Mensajes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.rimac.app.userInterfaces.UiSeguros.*;

public class PagoConTarjetaAsociada implements Task {

    private String numeroTarjeta;

    public PagoConTarjetaAsociada(String numeroTarjeta){
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            String ultimos4Caracteres = numeroTarjeta.length() > 4 ? numeroTarjeta.substring(numeroTarjeta.length() - 4) : numeroTarjeta;
            System.out.println(ultimos4Caracteres);
            actor.attemptsTo(
                    EsperarElemento.por(10),
                    Tap.on(BTN_PAGAR_CUOTAS),
                    Tap.siElElementoEsVisible(BTN_ALERTA_AUTOMATICO),
                    WaitUntil.the(CHKlISTADO, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Tap.on(CHKlISTADO),
                    Tap.on(BTN_INICIAR_PAGO),
                    EsperarElemento.por(5),
                    Tap.on(CHEC_NUMERO_TARJETA(ultimos4Caracteres)),
                    Tap.on(BTN_PAGAR),
                    Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(Tap.siElElementoEsVisible(BTN_ALERTA_ANDROID)),
                    EsperarElemento.por(5),
                    SkipAlerts.dismissAlerts(),
                    WaitUntil.the(LBL_PAGO_EXITOSO, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
            );
        }catch (RuntimeException ex){
            throw new Assertions(Assertions.Error(Mensajes.PAGO_CON_TARJETA_ASOCIADA), ex);
        }
    }

    public static PagoConTarjetaAsociada go(String numeroTarjeta){
        return Tasks.instrumented(PagoConTarjetaAsociada.class, numeroTarjeta);
    }
}
