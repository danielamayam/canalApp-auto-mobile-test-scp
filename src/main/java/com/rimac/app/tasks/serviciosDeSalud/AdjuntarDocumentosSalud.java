package com.rimac.app.tasks.serviciosDeSalud;

import com.rimac.app.interactions.ComandosCapabilities;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.Hide;
import com.rimac.app.interactions.app.AdjuntarDocumento;
import com.rimac.app.interactions.app.MenuItem;
import com.rimac.app.interactions.app.TomarFoto;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

import static com.rimac.app.userInterfaces.UiMenu.BTN_HOME;
import static com.rimac.app.userInterfaces.UiReembolso.*;
import static com.rimac.app.userInterfaces.UiReembolso.BTN_CONTINUAR;
import static com.rimac.app.userInterfaces.UiServiciosDeSalud.BTN_ACEPTAR;
import static com.rimac.app.userInterfaces.UiServiciosDeSalud.BTN_REEMBOLSO_DE_SALUD;

public class AdjuntarDocumentosSalud implements Task {
    static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    @Override
    public <T extends Actor> void performAs(T actor) {
        String v_environment = variables.getProperty("reembolso");
        actor.attemptsTo(
                WaitUntil.the(BTN_FACTURA, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_FACTURA),
                EsperarElemento.por(10),
                Tap.on(BTN_ENTENDIDO),

                Check.whether(!v_environment.contains("documento")).andIfSo(TomarFoto.go()).otherwise(AdjuntarDocumento.go()),


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
                        EsperarElemento.por(5)
                ),

                Scroll.on(BTN_BOLETA),
                WaitUntil.the(BTN_BOLETA, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_BOLETA),
                Tap.siElElementoEsVisible(BTN_ENTENDIDO),
                Check.whether(!v_environment.contains("documento")).andIfSo(TomarFoto.go()).otherwise(AdjuntarDocumento.go()),



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
                        EsperarElemento.por(5)
                ),

                Scroll.on(BTN_RECETA_MEDICA),
                WaitUntil.the(BTN_RECETA_MEDICA, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_RECETA_MEDICA),
                Tap.siElElementoEsVisible(BTN_ENTENDIDO),
                Check.whether(!v_environment.contains("documento")).andIfSo(TomarFoto.go()).otherwise(AdjuntarDocumento.go()),



                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                        EsperarElemento.por(5)
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

    public static AdjuntarDocumentosSalud go() {
        return Tasks.instrumented(AdjuntarDocumentosSalud.class);
    }
}
