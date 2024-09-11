package com.rimac.app.tasks.serviciosDeSalud;

import com.rimac.app.interactions.ComandosCapabilities;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.Hide;
import com.rimac.app.interactions.Swipe;
import com.rimac.app.interactions.app.MenuItem;
import com.rimac.app.interactions.builders.Tap;
import com.rimac.app.models.Reembolso;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.rimac.app.userInterfaces.UiCrossellRenovacion.BTN_CONTINUAR;
import static com.rimac.app.userInterfaces.UiServiciosDeSalud.*;

public class DiligencioDatosReembolsoTramites implements Task {

    private Reembolso reembolso;

    public DiligencioDatosReembolsoTramites(Reembolso reembolso){
        this.reembolso = reembolso;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MenuItem.tramites(),
                WaitUntil.the(LBL_TUS_TRAMITES, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Swipe.as(actor).fromBottom().toTop(),
                Swipe.as(actor).fromBottom().toTop(),
                EsperarElemento.por(4),
                Tap.on(BTN_REEMBOLSO_DE_SALUD),

                WaitUntil.the(BTN_INICIAR_REEMBOLSO, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_INICIAR_REEMBOLSO),
                WaitUntil.the(BTN_PRODUCTO_Y_CONTRATANTE, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_PRODUCTO_Y_CONTRATANTE),
                Tap.on(LBL_PRODUCTO_Y_CONTRATANTE(reembolso.getProductoContratante())),
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
                Tap.on(LBL_PRODUCTO_Y_CONTRATANTE(reembolso.getTipoCobertura())),
                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),
                EsperarElemento.por(3),
                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),
                WaitUntil.the(LBL_CARGAR_DOCUMENTOS, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds()
        );
    }

    public static DiligencioDatosReembolsoTramites go(Reembolso reembolso){
        return Tasks.instrumented(DiligencioDatosReembolsoTramites.class, reembolso);
    }
}
