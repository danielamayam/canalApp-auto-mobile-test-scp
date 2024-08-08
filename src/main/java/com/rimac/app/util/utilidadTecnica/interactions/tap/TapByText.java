package com.rimac.app.util.utilidadTecnica.interactions.tap;

import com.rimac.app.util.utilidadTecnica.interactions.ComandosCapabilities;
import com.rimac.app.util.utilidadTecnica.interactions.EncuentraElElemento;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Scroll;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

public class TapByText implements Interaction {
    private final String atributo;
    private final String selector;

    public TapByText(String selector, String atributo) {
        this.selector = selector;
        this.atributo = atributo;
    }

    @Step("{0} scrolled to (#atributo)")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(new Performable[]{Scroll.on(this.selector, this.atributo)});
        if (ComandosCapabilities.isiOS(actor)) {
            actor.attemptsTo(new Performable[]{Tap.on(EncuentraElElemento.as(actor).conTextoEniOS(this.atributo))});
        } else if (ComandosCapabilities.isAndroid(actor)) {
            actor.attemptsTo(new Performable[]{Tap.on(EncuentraElElemento.as(actor).conTextoEnAndroid(this.selector, this.atributo))});
        }

    }
}
