package com.rimac.app.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static com.rimac.app.userInterfaces.UiMenu.BTN_HOME;

public class VerificarLogin implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return BTN_HOME.resolveFor(actor).isVisible();
    }

    public static VerificarLogin as(){
        return new VerificarLogin();
    }
}
