package com.rimac.app.interactions;

import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.rimac.app.userInterfaces.UiMenu.*;

public class MenuItem implements Interaction {

    private String item;

    public MenuItem(String item){
        this.item = item;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (item){
            case "Home":
                actor.attemptsTo(
                        WaitUntil.the(BTN_HOME, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                        Tap.on(BTN_HOME)
                );
                break;
            case "Para Mí":
                actor.attemptsTo(
                        WaitUntil.the(BTN_PARAMI, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                        Tap.on(BTN_PARAMI)
                );
                break;
            case "Seguros":
                actor.attemptsTo(
                        WaitUntil.the(BTN_SEGUROS, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                        Tap.on(BTN_SEGUROS)
                );
                break;
            case "Tramites":
                actor.attemptsTo(
                        WaitUntil.the(BTN_TRAMITES, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                        Tap.on(BTN_TRAMITES)
                );
                break;
            case "Perfil":
                actor.attemptsTo(
                        WaitUntil.the(BTN_PERFIL, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                        Tap.on(BTN_PERFIL)
                );
                break;
            case "Estar Bien":
                actor.attemptsTo(
                        WaitUntil.the(BTN_ESTARBIEN, WebElementStateMatchers.isVisible()).forNoMoreThan(120).seconds(),
                        Tap.on(BTN_ESTARBIEN)
                );
                break;
            default:
                break;
        }
    }

    public static MenuItem home(){
        return Instrumented.instanceOf(MenuItem.class).withProperties("Home");
    }

    public static MenuItem paraMi(){
        return Instrumented.instanceOf(MenuItem.class).withProperties("Para Mí");
    }

    public static MenuItem seguros(){
        return Instrumented.instanceOf(MenuItem.class).withProperties("Seguros");
    }

    public static MenuItem tramites(){
        return Instrumented.instanceOf(MenuItem.class).withProperties("Tramites");
    }

    public static MenuItem perfil(){
        return Instrumented.instanceOf(MenuItem.class).withProperties("Perfil");
    }

    public static MenuItem estarBien(){
        return Instrumented.instanceOf(MenuItem.class).withProperties("Estar Bien");
    }
}
