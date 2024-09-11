package com.rimac.app.tasks.pagos;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.ComandosCapabilities;
import com.rimac.app.interactions.Hide;
import com.rimac.app.interactions.app.FormularioCrearTarjeta;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import com.rimac.app.models.SuscripcionDesdePagos;
import com.rimac.app.util.constantes.Mensajes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiSeguros.*;

public class AfiliarTarjetaDesdePagos implements Task {

    private SuscripcionDesdePagos suscripcionDesdePagos;

    public AfiliarTarjetaDesdePagos(SuscripcionDesdePagos suscripcionDesdePagos){
        this.suscripcionDesdePagos = suscripcionDesdePagos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Scroll.on(BTN_CAMBIAR_TARJETA),
                    Tap.on(BTN_CAMBIAR_TARJETA),
                    WaitUntil.the(LBL_CAMBIA_TARJETA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Scroll.on(BTN_ANADIR_NUEVA_TARJETA),
                    Tap.on(BTN_ANADIR_NUEVA_TARJETA),
                    FormularioCrearTarjeta.go(suscripcionDesdePagos),
                    Tap.on(BTN_GUARDAR_TARJETA),
                    Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(Tap.siElElementoEsVisible(BTN_ALERTA_ANDROID)),
                    WaitUntil.the(LBL_TARJETA_CAMBIADA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
            );
        }catch (RuntimeException ex){
            throw new Assertions(Assertions.Error(Mensajes.AFILIAR_TARJETA_DESDE_PAGOS), ex);
        }
    }

    public static AfiliarTarjetaDesdePagos go(SuscripcionDesdePagos suscripcionDesdePagos){
        return Tasks.instrumented(AfiliarTarjetaDesdePagos.class, suscripcionDesdePagos);
    }
}
