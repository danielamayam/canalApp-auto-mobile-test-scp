package com.rimac.app.tasks.serviciosDeSalud;

import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.util.utilidadTecnica.interactions.ComandosCapabilities;
import com.rimac.app.util.utilidadTecnica.interactions.Hide;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Scroll;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static com.rimac.app.userInterfaces.UiReembolso.*;
import static com.rimac.app.userInterfaces.UiServiciosDeSalud.BTN_ACEPTAR;

public class AdjuntarDocumentos implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_FACTURA, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_FACTURA),
                EsperarElemento.por(10),
                Tap.on(BTN_ENTENDIDO),

                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO),

                EsperarElemento.por(25),
                WaitUntil.the(TXT_SERIE_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Enter.theValue("FRED").into(TXT_SERIE_DOCUMENTO),
                Hide.keyboard(),
                Enter.theValue("1").into(TXT_NUMERO_DOCUMENTO),
                Hide.keyboard(),
                Check.whether(ComandosCapabilities.isiOS(actor)).andIfSo(
                        Tap.on(BTN_MONEDA),
                        Tap.on(CHEC_DOLARES),
                        Enter.theValue("35000").into(TXT_MONTO),
                        Hide.keyboard(),
                        Tap.on(TXT_FECHA),
                        Hide.keyboard()
                ),
                Tap.on(BTN_CONTINUAR),

                WaitUntil.the(BTN_RECIBO_POR_HONORARIOS, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_RECIBO_POR_HONORARIOS),
                Tap.siElElementoEsVisible(BTN_ENTENDIDO),

                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO),

                EsperarElemento.por(25),
                Enter.theValue("FHED").into(TXT_SERIE_DOCUMENTO),
                Hide.keyboard(),
                Enter.theValue("2").into(TXT_NUMERO_DOCUMENTO),
                Hide.keyboard(),

                Check.whether(ComandosCapabilities.isiOS(actor)).andIfSo(
                        Tap.on(BTN_MONEDA),
                        Tap.on(CHEC_DOLARES),
                        Enter.theValue("35000").into(TXT_MONTO),
                        Hide.keyboard(),
                        Tap.on(TXT_FECHA),
                        Hide.keyboard()
                ),

                Tap.on(BTN_CONTINUAR),

                Scroll.on(BTN_BOLETA),
                WaitUntil.the(BTN_BOLETA, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_BOLETA),
                Tap.siElElementoEsVisible(BTN_ENTENDIDO),

                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO),

                EsperarElemento.por(25),
                Enter.theValue("123456789").into(TXT_RUCO),
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

                Scroll.on(BTN_HOJA_DE_ATENCION),
                WaitUntil.the(BTN_HOJA_DE_ATENCION, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_HOJA_DE_ATENCION),
                Tap.siElElementoEsVisible(BTN_ENTENDIDO),

                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO),

                EsperarElemento.por(25),
                Tap.on(BTN_CONTINUAR),

                Scroll.on(BTN_ORDEN_MEDICA),
                WaitUntil.the(BTN_ORDEN_MEDICA, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ORDEN_MEDICA),
                Tap.siElElementoEsVisible(BTN_ENTENDIDO),

                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO),
                EsperarElemento.por(25),
                Tap.on(BTN_CONTINUAR),

                Scroll.on(BTN_HOJA_DE_LIQUIDACION),
                WaitUntil.the(BTN_HOJA_DE_LIQUIDACION, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_HOJA_DE_LIQUIDACION),
                Tap.siElElementoEsVisible(BTN_ENTENDIDO),

                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO),
                EsperarElemento.por(25),
                Tap.on(BTN_CONTINUAR),

                Scroll.on(BTN_INFORME_MEDICO),
                WaitUntil.the(BTN_INFORME_MEDICO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_INFORME_MEDICO),
                Tap.siElElementoEsVisible(BTN_ENTENDIDO),

                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO),
                EsperarElemento.por(25),
                Tap.on(BTN_CONTINUAR),

                Scroll.on(BTN_RESULTADO_EXAMENES),
                WaitUntil.the(BTN_RESULTADO_EXAMENES, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_RESULTADO_EXAMENES),
                Tap.siElElementoEsVisible(BTN_ENTENDIDO),

                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO),
                EsperarElemento.por(25),
                Tap.on(BTN_CONTINUAR),

                Scroll.on(BTN_EPICRISIS),
                WaitUntil.the(BTN_EPICRISIS, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_EPICRISIS),
                Tap.siElElementoEsVisible(BTN_ENTENDIDO),

                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO),
                EsperarElemento.por(25),
                Tap.on(BTN_CONTINUAR),

                Scroll.on(BTN_REPORTE_OPERATORIO),
                WaitUntil.the(BTN_REPORTE_OPERATORIO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_REPORTE_OPERATORIO),
                Tap.siElElementoEsVisible(BTN_ENTENDIDO),

                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO),
                EsperarElemento.por(25),
                Tap.on(BTN_CONTINUAR),

                Scroll.on(BTN_ANATOMIA_PATOLOGICO),
                WaitUntil.the(BTN_ANATOMIA_PATOLOGICO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ANATOMIA_PATOLOGICO),
                Tap.siElElementoEsVisible(BTN_ENTENDIDO),

                WaitUntil.the(BTN_ADJUNTAR_DOCUMENTO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ADJUNTAR_DOCUMENTO),
                Tap.siElElementoEsVisible(BTN_ALERT_PERMITIR),
                Tap.on(BTN_DOCUMENTO),
                EsperarElemento.por(25),
                Tap.on(BTN_CONTINUAR),

                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),
                EsperarElemento.por(10),

                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),
                EsperarElemento.por(10),

                WaitUntil.the(BTN_CONTINUAR_DATOS_CORREO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR_DATOS_CORREO),
                EsperarElemento.por(10),

                WaitUntil.the(BTN_ENVIAR_SOLICITUD, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_ENVIAR_SOLICITUD),

                WaitUntil.the(LBL_SOLICITUD_RECIBIDA, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds()
        );
    }

    public static AdjuntarDocumentos go(){
        return Tasks.instrumented(AdjuntarDocumentos.class);
    }
}
