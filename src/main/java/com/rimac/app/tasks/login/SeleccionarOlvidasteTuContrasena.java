package com.rimac.app.tasks.login;

import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiLogin.*;
import static com.rimac.app.userInterfaces.UiLogin.BTN_CONTINUAR;

public class SeleccionarOlvidasteTuContrasena implements Task {

    private String usuario;

    public SeleccionarOlvidasteTuContrasena(String usuario){
        this.usuario = usuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                EsperarElemento.por(3),
                Tap.siElElementoEsVisible(BTN_CAMBIAR_USUARIO),
                WaitUntil.the(TXT_USUARIO, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Enter.keyValues(usuario).into(TXT_USUARIO),
                WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_CONTINUAR),
                WaitUntil.the(TXT_CONTRASENA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                Tap.on(BTN_OLVIDASTE_TU_CONTRASENA),
                WaitUntil.the(LBL_ELIGE_COMO_RESTABLECER, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
        );
    }


    public static SeleccionarOlvidasteTuContrasena go(String usuario){
        return Tasks.instrumented(SeleccionarOlvidasteTuContrasena.class, usuario);
    }
}
