package com.rimac.app.util.utilidadTecnica.interactions;

import com.rimac.app.util.utilidadTecnica.interactions.builders.SwipeBuilderFrom;
import net.serenitybdd.screenplay.Actor;

public class Swipe {
    private Swipe() {
        throw new IllegalStateException("Error en Swipe");
    }

    public static SwipeBuilderFrom as(Actor actor) {
        return new SwipeBuilderFrom(actor);
    }
}
