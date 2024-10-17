package com.rimac.app.tasks.pagos;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.ComandosCapabilities;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.Swipe;
import com.rimac.app.interactions.app.FormularioCrearTarjeta;
import com.rimac.app.interactions.app.SkipAlerts;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import com.rimac.app.models.SuscripcionDesdePagos;
import com.rimac.app.util.constantes.Mensajes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiSeguros.*;

public class PagoSuscribiendoTarjeta implements Task {

    private SuscripcionDesdePagos suscripcionDesdePagos;

    public PagoSuscribiendoTarjeta(SuscripcionDesdePagos suscripcionDesdePagos){
        this.suscripcionDesdePagos = suscripcionDesdePagos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    EsperarElemento.por(15),
                    Tap.on(BTN_PAGAR_CUOTAS),
                    Tap.siElElementoEsVisible(BTN_ALERTA_AUTOMATICO),
                    WaitUntil.the(CHKlISTADO, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Tap.on(CHKlISTADO),
                    Tap.on(BTN_INICIAR_PAGO),
                    EsperarElemento.por(5),
                    Scroll.on(BTN_ANADIR_TARJETA),
                    Swipe.as(actor).fromBottom().toTop(),
                    WaitUntil.the(BTN_ANADIR_TARJETA, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                    Tap.on(BTN_ANADIR_TARJETA),
                    FormularioCrearTarjeta.go(suscripcionDesdePagos),
                    Tap.on(BTN_PAGAR),
                    Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(Tap.siElElementoEsVisible(BTN_ALERTA_ANDROID)),
                    EsperarElemento.por(5),
                    SkipAlerts.dismissAlerts(),
                    WaitUntil.the(LBL_PAGO_EXITOSO, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
            );
        }catch (RuntimeException ex){
            throw new Assertions(Assertions.Error(Mensajes.PAGO_SUSCRIBIENDO_LA_TARJETA), ex);
        }
    }

    public static PagoSuscribiendoTarjeta go(SuscripcionDesdePagos suscripcionDesdePagos) {
        return Tasks.instrumented(PagoSuscribiendoTarjeta.class, suscripcionDesdePagos);
    }
}
