package com.rimac.app.tasks.login;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.MenuItem;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import com.rimac.app.util.utilidadTecnica.utils.Mensajes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.rimac.app.userInterfaces.UiLogin.BTN_CERRAR_SESION;
import static com.rimac.app.userInterfaces.UiLogin.LBL_MENSAJE;

public class CerrarSesion implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    MenuItem.perfil(),
                    Tap.on(BTN_CERRAR_SESION),
                    WaitUntil.the(LBL_MENSAJE, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds()
            );
        }catch (RuntimeException ex){
            throw new Assertions(Assertions.Error(Mensajes.CERRAR_SESION), ex);
        }
    }

    public static CerrarSesion go(){
        return Tasks.instrumented(CerrarSesion.class);
    }
}
