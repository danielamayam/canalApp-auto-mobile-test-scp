package com.rimac.app.interactions.app;

import com.rimac.app.interactions.ComandosCapabilities;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.Hide;
import com.rimac.app.interactions.Swipe;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiCrossellRenovacion.BTN_CONTINUAR;
import static com.rimac.app.userInterfaces.UiServiciosDeSalud.*;
import static com.rimac.app.userInterfaces.UiServiciosDeSalud.LBL_CARGAR_DOCUMENTOS;

public class IniciarReembolso implements Interaction {

    private String getProductoContratante;
    private String getTipoCobertura;

    public IniciarReembolso(String getProductoContratante, String getTipoCobertura){
        this.getProductoContratante =getProductoContratante;
        this.getTipoCobertura = getTipoCobertura;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(BTN_INICIAR_REEMBOLSO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_INICIAR_REEMBOLSO),
                WaitUntil.the(BTN_PRODUCTO_Y_CONTRATANTE, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_PRODUCTO_Y_CONTRATANTE),
                Tap.on(LBL_PRODUCTO_Y_CONTRATANTE(getProductoContratante)),
                EsperarElemento.por(5),
                WaitUntil.the(BTN_LUGAR_DE_ATENCION, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_LUGAR_DE_ATENCION),
                Tap.on(CHEK_LUGAR),
                EsperarElemento.por(5),
                Check.whether(ComandosCapabilities.isiOS(actor)).andIfSo(
                        WaitUntil.the(BTN_LUGAR_DE_ATENCION, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                        Tap.on(BTN_LUGAR_DE_ATENCION),
                        Tap.on(CHEK_LUGAR),
                        EsperarElemento.por(5)
                ),
                WaitUntil.the(BTN_FECHA_ATENCION, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_FECHA_ATENCION),
                Check.whether(ComandosCapabilities.isiOS(actor)).andIfSo(
                        Hide.keyboard()
                ).otherwise(
                        Tap.on(BTN_ACEPTAR)
                ),
                EsperarElemento.por(5),
                Swipe.as(actor).fromBottom().toTop(),
                WaitUntil.the(BTN_TIPO_COBERTURA, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_TIPO_COBERTURA),
                Tap.on(LBL_PRODUCTO_Y_CONTRATANTE(getTipoCobertura)),
                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),
                EsperarElemento.por(3),
                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),
                WaitUntil.the(LBL_CARGAR_DOCUMENTOS, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds()
        );
    }

    public static IniciarReembolso go(String getProductoContratante, String getTipoCobertura){
        return Instrumented.instanceOf(IniciarReembolso.class).withProperties(getProductoContratante, getTipoCobertura);
    }
}
