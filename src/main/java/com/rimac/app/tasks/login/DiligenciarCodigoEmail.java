package com.rimac.app.tasks.login;

import com.rimac.app.interactions.builders.Tap;
import com.rimac.app.util.ObtenerCodigoHormail;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.rimac.app.userInterfaces.UiCrossellRenovacion.BTN_CONTINUAR;
import static com.rimac.app.userInterfaces.UiLogin.BTN_ENVIAR_CODIGO_POR_CORREO;

public class DiligenciarCodigoEmail implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Tap.on(BTN_ENVIAR_CODIGO_POR_CORREO),
                Tap.on(BTN_CONTINUAR)
        );
    }

    public static DiligenciarCodigoEmail go(){
        return Tasks.instrumented(DiligenciarCodigoEmail.class);
    }

}
