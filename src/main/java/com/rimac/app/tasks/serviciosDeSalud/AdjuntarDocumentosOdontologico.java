package com.rimac.app.tasks.serviciosDeSalud;

import com.rimac.app.interactions.ComandosCapabilities;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.Hide;
import com.rimac.app.interactions.app.MenuItem;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiMenu.BTN_HOME;
import static com.rimac.app.userInterfaces.UiReembolso.*;
import static com.rimac.app.userInterfaces.UiServiciosDeSalud.BTN_ACEPTAR;
import static com.rimac.app.userInterfaces.UiServiciosDeSalud.BTN_REEMBOLSO_DE_SALUD;

public class AdjuntarDocumentosOdontologico implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_FACTURA, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_FACTURA),
                EsperarElemento.por(10),
                Tap.on(BTN_ENTENDIDO),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO)),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO),

                EsperarElemento.por(25),
                WaitUntil.the(TXT_SERIE_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Enter.theValue("FRED").into(TXT_SERIE_DOCUMENTO),
                Hide.keyboard(),
                Enter.theValue("1").into(TXT_NUMERO_DOCUMENTO),
                Hide.keyboard(),
                Tap.on(BTN_MONEDA),
                Tap.on(CHEC_DOLARES),
                Enter.theValue("35000").into(TXT_MONTO),
                Hide.keyboard(),
                Tap.on(TXT_FECHA),
                Check.whether(ComandosCapabilities.isiOS(actor)).andIfSo(
                        Hide.keyboard()
                ).otherwise(
                        Tap.on(BTN_ACEPTAR)
                ),
                Tap.on(BTN_CONTINUAR),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                        EsperarElemento.por(10)
                ),
                Scroll.on(BTN_RECIBO_POR_HONORARIOS),
                WaitUntil.the(BTN_RECIBO_POR_HONORARIOS, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_RECIBO_POR_HONORARIOS),
                Tap.siElElementoEsVisible(BTN_ENTENDIDO),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO)),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO),

                EsperarElemento.por(25),
                WaitUntil.the(TXT_SERIE_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Enter.theValue("FHED").into(TXT_SERIE_DOCUMENTO),
                Hide.keyboard(),
                Enter.theValue("2").into(TXT_NUMERO_DOCUMENTO),
                Hide.keyboard(),
                Tap.on(BTN_MONEDA),
                Tap.on(CHEC_DOLARES),
                Enter.theValue("35000").into(TXT_MONTO),
                Hide.keyboard(),
                Tap.on(TXT_FECHA),
                Check.whether(ComandosCapabilities.isiOS(actor)).andIfSo(
                        Hide.keyboard()
                ).otherwise(
                        Tap.on(BTN_ACEPTAR)
                ),
                Tap.on(BTN_CONTINUAR),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                        EsperarElemento.por(10)
                ),

                Scroll.on(BTN_BOLETA),
                WaitUntil.the(BTN_BOLETA, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_BOLETA),
                Tap.siElElementoEsVisible(BTN_ENTENDIDO),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO)),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO),

                EsperarElemento.por(25),
                WaitUntil.the(TXT_RUCO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Enter.theValue("20510247290").into(TXT_RUCO),
                Hide.keyboard(),
                Tap.on(BTN_MONEDA_V2),
                Tap.on(CHEC_DOLARES),
                EsperarElemento.por(5),
                Enter.theValue("350").into(TXT_MONTO),
                Hide.keyboard(),
                Enter.theValue("3").into(TXT_NUMERO_DOCUMENTO),
                Hide.keyboard(),
                Enter.theValue("F234").into(TXT_SERIE_DOCUMENTO),
                Hide.keyboard(),
                Tap.on(TXT_FECHA),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                        Tap.on(BTN_ACEPTAR)
                ).otherwise(
                        Hide.keyboard()
                ),

                Tap.on(BTN_CONTINUAR),

                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                        EsperarElemento.por(10)
                ),

                Scroll.on(BTN_SOLICITUD_REEMBOLSO),
                WaitUntil.the(BTN_SOLICITUD_REEMBOLSO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_SOLICITUD_REEMBOLSO),
                Tap.siElElementoEsVisible(BTN_ENTENDIDO),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO)),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO),
                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),

                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                        EsperarElemento.por(10)
                ),
                Scroll.on(BTN_ODONTOGRAMA),
                WaitUntil.the(BTN_ODONTOGRAMA, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ODONTOGRAMA),
                Tap.siElElementoEsVisible(BTN_ENTENDIDO),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO)),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO),
                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                        EsperarElemento.por(10)
                ),

                Scroll.on(BTN_LIQUIDACION_CLINICA),
                WaitUntil.the(BTN_LIQUIDACION_CLINICA, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_LIQUIDACION_CLINICA),
                Tap.siElElementoEsVisible(BTN_ENTENDIDO),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO)),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO),
                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                        EsperarElemento.por(10)
                ),

                Scroll.on(BTN_MODELO_DE_ESTUDIO),
                WaitUntil.the(BTN_MODELO_DE_ESTUDIO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_MODELO_DE_ESTUDIO),
                Tap.siElElementoEsVisible(BTN_ENTENDIDO),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO)),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO),
                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                        EsperarElemento.por(10)
                ),

                Scroll.on(BTN_RADIOGRAFIA),
                WaitUntil.the(BTN_RADIOGRAFIA, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_RADIOGRAFIA),
                Tap.siElElementoEsVisible(BTN_ENTENDIDO),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO)),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO),
                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                        EsperarElemento.por(10)
                ),

                Scroll.on(BTN_RADIOGRAFIA_PANORAMICA),
                WaitUntil.the(BTN_RADIOGRAFIA_PANORAMICA, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_RADIOGRAFIA_PANORAMICA),
                Tap.siElElementoEsVisible(BTN_ENTENDIDO),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO)),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO),
                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                        EsperarElemento.por(10)
                ),

                Scroll.on(BTN_INFORME_MEDICO_ODONTOLOGICO),
                WaitUntil.the(BTN_INFORME_MEDICO_ODONTOLOGICO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_INFORME_MEDICO_ODONTOLOGICO),
                Tap.siElElementoEsVisible(BTN_ENTENDIDO),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO)),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO),
                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),

                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                        EsperarElemento.por(15)
                ),

                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),


                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),


                WaitUntil.the(BTN_CONTINUAR_DATOS_CORREO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR_DATOS_CORREO),


                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),

                WaitUntil.the(LBL_SOLICITUD_RECIBIDA, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.siElElementoEsVisible(BTN_ALERTA),

                Tap.on(BTN_IR_AL_INICIO),

                WaitUntil.the(BTN_HOME, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),

                MenuItem.tramites(),

                Tap.on(BRN_SEGUIMIENTO),

                Tap.on(BTN_REEMBOLSO_DE_SALUD),

                WaitUntil.the(CARD_REEMBOLSO, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()

        );
    }

    public static AdjuntarDocumentosOdontologico go() {
        return Tasks.instrumented(AdjuntarDocumentosOdontologico.class);
    }
}
