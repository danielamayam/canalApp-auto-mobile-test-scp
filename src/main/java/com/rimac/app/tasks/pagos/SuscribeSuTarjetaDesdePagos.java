package com.rimac.app.tasks.pagos;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.ComandosCapabilities;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.Hide;
import com.rimac.app.interactions.app.FormularioCrearTarjeta;
import com.rimac.app.interactions.app.IrAPagosDePolizaVihicular;
import com.rimac.app.interactions.app.SkipAlerts;
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

public class SuscribeSuTarjetaDesdePagos implements Task {

    private SuscripcionDesdePagos suscripcionDesdePagos;

    public SuscribeSuTarjetaDesdePagos(SuscripcionDesdePagos suscripcionDesdePagos){
        this.suscripcionDesdePagos = suscripcionDesdePagos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try{
            String ultimos4Caracteres = suscripcionDesdePagos.getNumtarjeta().length() > 4 ? suscripcionDesdePagos.getNumtarjeta().substring(suscripcionDesdePagos.getNumtarjeta().length() - 4) : suscripcionDesdePagos.getNumtarjeta();
            actor.attemptsTo(
                    IrAPagosDePolizaVihicular.go(suscripcionDesdePagos.getPlaca(), suscripcionDesdePagos.getVigencia()),
                    Scroll.on(BTN_MEDIOS_DE_PAGO),
                    Tap.on(BTN_MEDIOS_DE_PAGO),
                    WaitUntil.the(LBL_MIS_TARJETAS, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Scroll.on(BTN_ANADIR_NUEVA_TARJETA),
                    Tap.on(BTN_ANADIR_NUEVA_TARJETA),
                    FormularioCrearTarjeta.go(suscripcionDesdePagos),
                    Tap.on(BTN_GUARDAR_TARJETA),
                    Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(Tap.siElElementoEsVisible(BTN_ALERTA_ANDROID)),
                    EsperarElemento.por(5),
                    SkipAlerts.dismissAlerts(),
                    WaitUntil.the(LBL_MIS_TARJETAS, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Scroll.on(LBL_NUMERO_TARJETA(ultimos4Caracteres))

            );
        }catch (RuntimeException ex){
            throw new Assertions(Assertions.Error(Mensajes.SUSCRIBE_SU_TARJETA_DESDE_PAGOS), ex);
        }
    }

    public static SuscribeSuTarjetaDesdePagos go(SuscripcionDesdePagos suscripcionDesdePagos) {
        return Tasks.instrumented(SuscribeSuTarjetaDesdePagos.class, suscripcionDesdePagos);
    }
}
