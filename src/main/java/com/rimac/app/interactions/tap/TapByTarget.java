package com.rimac.app.interactions.tap;

import com.rimac.app.interactions.GetDriver;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.exceptions.ObjetosException;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.interactions.Actions;

public class TapByTarget implements Interaction {
    private final Target target;

    public TapByTarget(Target target) {
        this.target = target;
    }

    @Step("{0} taps on #target")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(new Performable[]{Scroll.on(this.target)});

        try {
            (new Actions(GetDriver.as(actor).appiumDriver())).click(this.target.resolveFor(actor).getElement()).perform();
        } catch (RuntimeException var3) {
            String var10002 = ObjetosException.errorSeleccionandoObjeto();
            throw new ObjetosException(var10002 + this.target.toString());
        }
    }
}