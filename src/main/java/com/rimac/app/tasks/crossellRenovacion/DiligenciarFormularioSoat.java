package com.rimac.app.tasks.crossellRenovacion;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.FormularioCrearTarjeta;
import com.rimac.app.interactions.MenuItem;
import com.rimac.app.models.SuscripcionDesdePagos;
import com.rimac.app.util.utilidadTecnica.interactions.ComandosCapabilities;
import com.rimac.app.util.utilidadTecnica.interactions.Hide;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Scroll;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import com.rimac.app.util.utilidadTecnica.utils.Mensajes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiCrossellRenovacion.*;
import static com.rimac.app.userInterfaces.UiSeguros.*;

public class DiligenciarFormularioSoat implements Task {

    private String placa;
    private SuscripcionDesdePagos suscripcionDesdePagos;

    public DiligenciarFormularioSoat(String placa, SuscripcionDesdePagos suscripcionDesdePagos) {
        this.suscripcionDesdePagos = suscripcionDesdePagos;
        this.placa = placa;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            char[] charArray = placa.toCharArray();
            actor.attemptsTo(
                    MenuItem.paraMi(),
                    Tap.on(BTN_SOAT),
                    Tap.on(BTN_QUIERO_COMPRAR),
                    Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                            Enter.theValue(String.valueOf(charArray[0])).into(TXT_PLACA_ANDROID.of(String.valueOf(1))),
                            Enter.theValue(String.valueOf(charArray[1])).into(TXT_PLACA_ANDROID.of(String.valueOf(2))),
                            Enter.theValue(String.valueOf(charArray[2])).into(TXT_PLACA_ANDROID.of(String.valueOf(3))),
                            Enter.theValue(String.valueOf(charArray[3])).into(TXT_PLACA_ANDROID.of(String.valueOf(5))),
                            Enter.theValue(String.valueOf(charArray[4])).into(TXT_PLACA_ANDROID.of(String.valueOf(6))),
                            Enter.theValue(String.valueOf(charArray[5])).into(TXT_PLACA_ANDROID.of(String.valueOf(7))),
                            Hide.keyboard()
                    ).otherwise(
                            Enter.theValue(String.valueOf(charArray[0])).into(TXT_PLACA_IOS.of(String.valueOf(1))),
                            Enter.theValue(String.valueOf(charArray[1])).into(TXT_PLACA_IOS.of(String.valueOf(2))),
                            Enter.theValue(String.valueOf(charArray[2])).into(TXT_PLACA_IOS.of(String.valueOf(3))),
                            Enter.theValue(String.valueOf(charArray[3])).into(TXT_PLACA_IOS.of(String.valueOf(4))),
                            Enter.theValue(String.valueOf(charArray[4])).into(TXT_PLACA_IOS.of(String.valueOf(5))),
                            Enter.theValue(String.valueOf(charArray[5])).into(TXT_PLACA_IOS.of(String.valueOf(6))),
                            EsperarElemento.por(1)
                    ),
                    Tap.on(BTN_GUARDAR_TARJETA),
                    EsperarElemento.por(20),
                    WaitUntil.the(LBL_TIEMPO_DE_ESPERA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
            );
            actor.attemptsTo(
                    Check.whether(LBL_ELIGE_TU_PLAN.resolveFor(actor).isVisible()).andIfSo(
                            Scroll.on(LBL_AFILIA_TU_TARJETA),
                            Tap.on(BTNR_AFILIAR),
                            Tap.on(BTN_CONTINUAR),
                            EsperarElemento.por(5),
                            Scroll.on(BTN_ANADIR_NUEVA_TARJETA),
                            Tap.on(BTN_ANADIR_NUEVA_TARJETA)
                    ),
                    FormularioCrearTarjeta.go(suscripcionDesdePagos),
                    Tap.on(BTN_PAGAR),
                    WaitUntil.the(LBL_MENSAJE, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()

            );
        } catch (RuntimeException ex) {
            throw new Assertions(Assertions.Error(Mensajes.DILIGENCIA_EL_FORMULARIO_DE_SOAT), ex);
        }

    }

    public static DiligenciarFormularioSoat go(String placa, SuscripcionDesdePagos suscripcionDesdePagos) {
        return Tasks.instrumented(DiligenciarFormularioSoat.class, placa, suscripcionDesdePagos);
    }
}
