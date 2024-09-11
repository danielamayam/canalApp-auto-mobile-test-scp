package com.rimac.app.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;


public class SwipeByCoordinates implements Interaction {
    private final int inicialX;
    private final int inicialY;
    private final int endX;
    private final int endY;

    public SwipeByCoordinates(int inicialX, int inicialY, int endX, int endY) {
        this.inicialX = inicialX;
        this.inicialY = inicialY;
        this.endX = endX;
        this.endY = endY;
    }

    @Step("{0} swiped from (#inicialX, #inicialY) to (#endX, #endY)")
    public <T extends Actor> void performAs(T actor) {


        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        var start = new Point(inicialX, inicialY);
        var end = new Point (endX, endY);
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        GetDriver.as(actor).appiumDriver().perform(Arrays.asList(swipe));




        //(new TouchAction((PerformsTouchActions) GetDriver.as(actor).appiumDriver())).longPress((new PointOption()).withCoordinates(this.inicialX, this.inicialY)).moveTo((new PointOption()).withCoordinates(this.endX, this.endY)).release().perform();
        //(new TouchAction((PerformsTouchActions) GetDriver.as(actor).appiumDriver())).longPress((new PointOption()).withCoordinates(this.inicialX, this.inicialY)).moveTo((new PointOption()).withCoordinates(this.endX, this.endY)).release().perform()
    }
}