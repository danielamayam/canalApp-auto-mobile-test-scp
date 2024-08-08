package com.rimac.app.questions;

import com.rimac.app.exceptions.Assertions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class VerificarDetalleSeguroPlanVida implements Question<Boolean> {

    private String texto;
    private Target target;

    public VerificarDetalleSeguroPlanVida(String texto, Target target) {
        this.texto = texto;
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean resultado = false;
        String text = target.resolveFor(actor).getText().trim();
        resultado = text.contains(texto);
        if (!resultado) {
            throw new Assertions("El texto no es igual\n" +
                    "Texto Web: " + text + "\n" +
                    "Texto esperado: " + texto);
        }
        return resultado;
    }

    public static VerificarDetalleSeguroPlanVida on(String texto, Target target) {
        return new VerificarDetalleSeguroPlanVida(texto, target);
    }

}
