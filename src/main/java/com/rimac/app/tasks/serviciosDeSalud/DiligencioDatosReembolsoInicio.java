package com.rimac.app.tasks.serviciosDeSalud;

import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.models.Reembolso;
import com.rimac.app.util.utilidadTecnica.interactions.Hide;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Scroll;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiCrossellRenovacion.BTN_CONTINUAR;
import static com.rimac.app.userInterfaces.UiServiciosDeSalud.*;
import static com.rimac.app.userInterfaces.UiServiciosDeSalud.LBL_CARGAR_DOCUMENTOS;

public class DiligencioDatosReembolsoInicio implements Task {

    private Reembolso reembolso;

    public DiligencioDatosReembolsoInicio(Reembolso reembolso){
        this.reembolso = reembolso;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.on(BTN_REEMBOLSO_DE_SALUD),
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
                WaitUntil.the(BTN_LUGAR_DE_ATENCION, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_LUGAR_DE_ATENCION),
                Tap.on(CHEK_LUGAR),
                EsperarElemento.por(5),
                WaitUntil.the(BTN_FECHA_ATENCION, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_FECHA_ATENCION),
                Hide.keyboard(),
                EsperarElemento.por(5),
                WaitUntil.the(BTN_TIPO_COBERTURA, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_TIPO_COBERTURA),
                Tap.on(LBL_PRODUCTO_Y_CONTRATANTE(reembolso.getTipoCobertura())),
                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),
                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),
                WaitUntil.the(LBL_CARGAR_DOCUMENTOS, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds()
        );
    }

    public static DiligencioDatosReembolsoInicio go(Reembolso reembolso){
        return Tasks.instrumented(DiligencioDatosReembolsoInicio.class, reembolso);
    }


}
