package com.rimac.app.interactions;

import com.rimac.app.interactions.app.FormularioClinica;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

public class HorizontalSwipeByCoordinates implements Interaction {
    private final int inicialX;
    private final int inicialY;
    private final int endX;

    public HorizontalSwipeByCoordinates(int inicialX, int inicialY, int endX) {
        this.inicialX = inicialX;
        this.inicialY = inicialY;
        this.endX = endX;
    }

    @Step("{0} swiped horizontally from (#inicialX, #inicialY) to (#endX, #inicialY)")
    public <T extends Actor> void performAs(T actor) {

        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        var start = new Point(inicialX, inicialY);
        var end = new Point(endX, inicialY);
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        GetDriver.as(actor).appiumDriver().perform(Arrays.asList(swipe));
    }

    public static HorizontalSwipeByCoordinates go(int inicialX, int inicialY, int endX){
        return Instrumented.instanceOf(HorizontalSwipeByCoordinates.class).withProperties(inicialX,inicialY, endX);
    }
}

