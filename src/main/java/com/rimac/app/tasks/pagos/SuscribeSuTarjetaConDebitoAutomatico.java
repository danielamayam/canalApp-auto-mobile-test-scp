package com.rimac.app.tasks.pagos;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.FormularioCrearTarjeta;
import com.rimac.app.models.SuscripcionDesdePagos;
import com.rimac.app.util.utilidadTecnica.interactions.ComandosCapabilities;
import com.rimac.app.util.utilidadTecnica.interactions.Swipe;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Scroll;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import com.rimac.app.util.utilidadTecnica.utils.Mensajes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.rimac.app.userInterfaces.UiSeguros.*;
import static com.rimac.app.userInterfaces.UiSeguros.BTN_ANADIR_TARJETA;

public class SuscribeSuTarjetaConDebitoAutomatico implements Task {

    private SuscripcionDesdePagos suscripcionDesdePagos;

    public SuscribeSuTarjetaConDebitoAutomatico(SuscripcionDesdePagos suscripcionDesdePagos){
        this.suscripcionDesdePagos = suscripcionDesdePagos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Tap.on(BTN_PAGAR_CUOTAS),
                    Tap.siElElementoEsVisible(BTN_ALERTA_AUTOMATICO),
                    WaitUntil.the(CHKlISTADO, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Tap.on(CHKlISTADO),
                    Tap.on(BTN_INICIAR_PAGO),
                    WaitUntil.the(LBL_PAGA_AL_INSTANTE, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Swipe.as(actor).fromBottom().toTop(),
                    Scroll.on(BTN_ANADIR_TARJETA),
                    WaitUntil.the(BTN_ANADIR_TARJETA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Tap.on(BTN_ANADIR_TARJETA),
                    FormularioCrearTarjeta.go(suscripcionDesdePagos),
                    Tap.on(SWC_AUTOMATICO),
                    Tap.on(BTN_PAGAR),
                    Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(Tap.siElElementoEsVisible(BTN_ALERTA_ANDROID)),
                    WaitUntil.the(LBL_PAGO_EXITOSO, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
            );
        }catch (RuntimeException ex){
            throw new Assertions(Assertions.Error(Mensajes.SUSCRIBE_SU_TARJETA_CON_DEBITO_AUTOMATICO), ex);
        }
    }

    public static SuscribeSuTarjetaConDebitoAutomatico go(SuscripcionDesdePagos suscripcionDesdePagos){
        return Tasks.instrumented(SuscribeSuTarjetaConDebitoAutomatico.class, suscripcionDesdePagos);
    }
}
