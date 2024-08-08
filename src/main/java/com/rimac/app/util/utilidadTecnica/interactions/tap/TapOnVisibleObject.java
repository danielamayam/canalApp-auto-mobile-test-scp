package com.rimac.app.util.utilidadTecnica.interactions.tap;

import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;

public class TapOnVisibleObject implements Interaction {
    private final Target target;

    public TapOnVisibleObject(Target target) {
        this.target = target;
    }

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(new Performable[]{Check.whether(this.target.resolveFor(actor).isCurrentlyVisible()).andIfSo(new Performable[]{Tap.on(this.target)})});
    }
}
