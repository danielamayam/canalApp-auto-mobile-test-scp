package com.rimac.app.tasks.login;

import com.rimac.app.exceptions.Assertions;
import com.rimac.app.interactions.ComandosCapabilities;
import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.Hide;
import com.rimac.app.interactions.app.NewOmitirAlertas;
import com.rimac.app.interactions.app.OmitirAlertas;
import com.rimac.app.interactions.app.SkipAlerts;
import com.rimac.app.interactions.builders.Tap;
import com.rimac.app.models.Login;
import com.rimac.app.util.constantes.Mensajes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiLogin.*;

public class InicioDeSesion implements Task {

    private Login login;

    public InicioDeSesion(Login login) {
        this.login = login;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.wasAbleTo(
                    EsperarElemento.por(3),
                    Tap.siElElementoEsVisible(BTN_CAMBIAR_USUARIO),
                    WaitUntil.the(TXT_USUARIO, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Enter.keyValues(login.getNumeroUsuario()).into(TXT_USUARIO),
                    WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                    Click.on(BTN_CONTINUAR),
                    EsperarElemento.por(5),
                    WaitUntil.the(TXT_CONTRASENA, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                    Enter.keyValues(login.getContrasena()).into(TXT_CONTRASENA),
                    Hide.keyboard(),
                    EsperarElemento.por(5),
                    WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isClickable()).forNoMoreThan(120).seconds(),
                    Click.on(BTN_CONTINUAR),
                    EsperarElemento.por(5),
                    SkipAlerts.dismissAlerts(),
                    EsperarElemento.por(30)

            );
        } catch (RuntimeException ex) {
            throw new Assertions(Assertions.Error(Mensajes.INICIO_DE_SESION), ex);
        }

    }

    public static InicioDeSesion go(Login login) {
        return Tasks.instrumented(InicioDeSesion.class, login);
    }


}
