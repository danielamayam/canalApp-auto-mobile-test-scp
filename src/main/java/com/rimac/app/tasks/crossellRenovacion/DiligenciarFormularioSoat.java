package com.rimac.app.tasks.crossellRenovacion;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.ComandosCapabilities;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.Hide;
import com.rimac.app.interactions.Swipe;
import com.rimac.app.interactions.app.FormularioCrearTarjeta;
import com.rimac.app.interactions.app.MenuItem;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import com.rimac.app.models.SuscripcionDesdePagos;
import com.rimac.app.util.VehicleIdentifierGenerator;
import com.rimac.app.util.constantes.Mensajes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Arrays;

import static com.rimac.app.userInterfaces.UiCrossellRenovacion.*;
import static com.rimac.app.userInterfaces.UiSeguros.*;

public class DiligenciarFormularioSoat implements Task {


    private SuscripcionDesdePagos suscripcionDesdePagos;

    public DiligenciarFormularioSoat(SuscripcionDesdePagos suscripcionDesdePagos) {
        this.suscripcionDesdePagos = suscripcionDesdePagos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            //String placa = VehicleIdentifierGenerator.generateLicensePlate();
            String placa = "MIM-288";
            String[] charArray = placa.replace("-", "").split("");
            actor.attemptsTo(
                    MenuItem.paraMi(),
                    Swipe.as(actor).fromBottom().toLeft(),
                    Swipe.as(actor).fromBottom().toLeft(),
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
                    EsperarElemento.por(30)
            );
            do {
                if (LBL_DATOS_ADICIONALES.isVisibleFor(actor)) {
                    actor.attemptsTo(
                            WaitUntil.the(LBL_DATOS_ADICIONALES, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                            Tap.on(TXT_TIPO_USO),
                            Tap.on(RB_PARTICULAR),
                            Tap.on(TXT_TIPO_VEHICULO),
                            Tap.on(RB_AUTO),
                            Tap.on(TXT_MARCA),
                            Check.whether(ComandosCapabilities.isiOS(actor)).andIfSo(
                                    Swipe.as(actor).fromBottom().toTop(),
                                    Swipe.as(actor).fromBottom().toTop(),
                                    Swipe.as(actor).fromBottom().toTop()
                            ).otherwise(
                                    Scroll.on(RB_CHEVROLET),
                                    Swipe.as(actor).fromBottom().toTop()
                            ),
                            Tap.on(RB_CHEVROLET),
                            Tap.on(TXT_MODELO),
                            Scroll.on(RB_MODELO),
                            Tap.on(RB_MODELO),
                            Tap.on(TXT_ANIO_FABRICACION),
                            Check.whether(ComandosCapabilities.isiOS(actor)).andIfSo(
                                    Enter.theValue("2020").into(LBL_FECHA)
                            ).otherwise(
                                    Swipe.as(actor).fromTop().toBottom()
                            ),
                            Tap.on(BTN_ACEPTAR_FECHA),
                            Tap.on(TXT_NUMERO_DE_SERIE),
                            Enter.theValue("12345678").into(TXT_NUMERO_DE_SERIE),
                            Hide.keyboard(),
                            Tap.on(TXT_NUMERO_ASIENTOS),
                            Enter.theValue("5").into(TXT_NUMERO_ASIENTOS),
                            Hide.keyboard(),
                            EsperarElemento.por(1),
                            Tap.on(BTN_CONTINUAR),
                            EsperarElemento.por(30)
                    );
                }
                System.out.println(LBL_DATOS_ADICIONALES.isVisibleFor(actor));
            }while (LBL_DATOS_ADICIONALES.isVisibleFor(actor));

            actor.attemptsTo(
                    EsperarElemento.por(30),
                    Swipe.as(actor).fromBottom().toTop(),
                    Swipe.as(actor).fromBottom().toTop(),
                    Tap.on(BTNR_AFILIAR),
                    Tap.on(BTN_CONTINUAR),
                    EsperarElemento.por(30)
            );
            if (TXT_DEPARTAMENTO.isVisibleFor(actor)) {
                actor.attemptsTo(Tap.on(TXT_DEPARTAMENTO),
                        Tap.on(TXT_AMAZONAS),
                        EsperarElemento.por(1),
                        Tap.on(TXT_PROVINCIA),
                        Tap.on(TXT_BAGUA),
                        EsperarElemento.por(1),
                        Tap.on(TXT_DISTRITO),
                        Tap.on(TXT_ARAMANGO),
                        EsperarElemento.por(1),
                        Tap.on(DIRECCION),
                        Enter.theValue("Santiago").into(DIRECCION),
                        Hide.keyboard(),
                        EsperarElemento.por(1),
                        Tap.on(BTN_CONTINUAR)
                );
            };
            actor.attemptsTo(
                    Tap.on(BTN_ANADIR_NUEVA_TARJETA),
                    FormularioCrearTarjeta.go(suscripcionDesdePagos),
                    Tap.on(BTN_PAGAR),
                    WaitUntil.the(LBL_MENSAJE, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
            );
        } catch (RuntimeException ex) {
            throw new Assertions(Assertions.Error(Mensajes.DILIGENCIA_EL_FORMULARIO_DE_SOAT), ex);
        }

    }

    public static DiligenciarFormularioSoat go(SuscripcionDesdePagos suscripcionDesdePagos) {
        return Tasks.instrumented(DiligenciarFormularioSoat.class, suscripcionDesdePagos);
    }
}
