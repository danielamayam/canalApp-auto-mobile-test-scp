package com.rimac.app.util.utilidadTecnica.interactions.fechas;

import com.rimac.app.util.utilidadTecnica.interactions.Swipe;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class SelectYear implements Interaction {
    private final String fecha;

    public SelectYear(String fecha) {
        this.fecha = fecha;
    }

    public static SelectYear conFecha(String fecha) {
        return (SelectYear) Tasks.instrumented(SelectYear.class, new Object[]{fecha});
    }

    public <T extends Actor> void performAs(T actor) {
        Target year = Target.the("YEAR").located(AppiumBy.androidUIAutomator(String.format("new UiSelector().resourceId(\"android:id/text1\").text(\"%s\").instance(0)", this.fecha)));

        while(!year.resolveFor(actor).isCurrentlyVisible()) {
            actor.attemptsTo(new Performable[]{Swipe.as(actor).fromTop().toBottom()});
        }

        actor.attemptsTo(new Performable[]{Tap.on(year)});
    }
}
