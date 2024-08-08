package com.rimac.app.interactions;

import com.rimac.app.models.SuscripcionDesdePagos;
import com.rimac.app.util.utilidadTecnica.interactions.Hide;
import com.rimac.app.util.utilidadTecnica.utils.enums.Datos;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiSeguros.*;

public class FormularioCrearTarjeta implements Interaction {

    private SuscripcionDesdePagos suscripcionDesdePagos;

    public FormularioCrearTarjeta(SuscripcionDesdePagos suscripcionDesdePagos){
        this.suscripcionDesdePagos = suscripcionDesdePagos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(TXT_NUMERO_TARJETA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Enter.theValue(suscripcionDesdePagos.getNumtarjeta()).into(TXT_NUMERO_TARJETA),
                    Enter.theValue(Datos.NOMBRE.getClave()).into(TXT_NOMBRE),
                    Enter.theValue(Datos.APELLIDO.getClave()).into(TXT_APELLIDO),
                    Enter.theValue(suscripcionDesdePagos.getFecha()).into(TXT_FECHA),
                    Enter.theValue(suscripcionDesdePagos.getCvv()).into(TXT_CVV),
                    Enter.theValue(Datos.CORREO.getClave()).into(TXT_CORREO),
                    Hide.keyboard()

            );
        }catch (RuntimeException e){

        }
    }

    public static FormularioCrearTarjeta go(SuscripcionDesdePagos suscripcionDesdePagos){
        return Instrumented.instanceOf(FormularioCrearTarjeta.class).withProperties(suscripcionDesdePagos);
    }
}
