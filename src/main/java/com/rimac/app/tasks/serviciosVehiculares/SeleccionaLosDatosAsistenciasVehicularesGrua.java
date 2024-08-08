package com.rimac.app.tasks.serviciosVehiculares;

import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.util.utilidadTecnica.interactions.ComandosCapabilities;
import com.rimac.app.util.utilidadTecnica.interactions.Swipe;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiCrossellRenovacion.BTN_CONTINUAR;
import static com.rimac.app.userInterfaces.UiSeguros.BTN_GUARDAR_TARJETA;
import static com.rimac.app.userInterfaces.UiServiciosVehiculares.*;

public class SeleccionaLosDatosAsistenciasVehicularesGrua implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Tap.on(BTN_INICIAR_SOLICITUD),
                EsperarElemento.por(10),
                Tap.siElElementoEsVisible(BTN_CANCELAR),
                WaitUntil.the(BTN_CONFIRMAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONFIRMAR),
                WaitUntil.the(BTN_GRUA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_GRUA),
                WaitUntil.the(BTN_FACIL_ACCESO, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_FACIL_ACCESO),
                EsperarElemento.por(10),
                Check.whether(ComandosCapabilities.isAndroid(actor)).andIfSo(
                        Tap.siElElementoEsVisible(BTN_CANCELAR),
                        EsperarElemento.por(10),
                        Tap.on(TXT_PUNTO_DE_DESTINO),
                        Enter.theValue("Calle Capón").into(TXT_PUNTO_DE_DESTINO),
                        Tap.on(LBL_CALLE)
                ).otherwise(
                        Tap.on(TXT_PUNTO_DE_DESTINO),
                        Enter.theValue("Calle Capón").into(TXT_PUNTO_DE_DESTINO),
                        EsperarElemento.por(10),
                        Tap.on(LBL_CALLE)
                ),
                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR ),
                EsperarElemento.por(5),
                Swipe.as(actor).fromTop().toTop(),
                Tap.on(BTN_GUARDAR_TARJETA),
                WaitUntil.the(LBL_MENSAJE_CHOFER, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()

        );
    }

    public static SeleccionaLosDatosAsistenciasVehicularesGrua go(){
        return Tasks.instrumented(SeleccionaLosDatosAsistenciasVehicularesGrua.class);
    }
}
