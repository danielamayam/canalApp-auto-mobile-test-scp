package com.rimac.app.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;


public class VerificarElemento implements Question<Boolean> {

    private Target target;

    public VerificarElemento(Target target){
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return target.resolveFor(actor).isVisible();
    }

    public static VerificarElemento as(Target target){
        return new VerificarElemento(target);
    }
}
