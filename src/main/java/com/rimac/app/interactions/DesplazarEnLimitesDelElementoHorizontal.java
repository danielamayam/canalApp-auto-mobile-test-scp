package com.rimac.app.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DesplazarEnLimitesDelElementoHorizontal implements Task {

    private final Target elemento;
    private final int xOffset;
    private final int yOffset;


    public DesplazarEnLimitesDelElementoHorizontal(Target elemento, int xOffset, int yOffset) {
        this.elemento = elemento;
        this.xOffset = xOffset;
        this.yOffset = yOffset;

    }

    public static DesplazarEnLimitesDelElementoHorizontal en(Target elemento, int xOffset, int yOffset) {
        return instrumented(DesplazarEnLimitesDelElementoHorizontal.class, elemento, xOffset, yOffset);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElement webElement = elemento.resolveFor(actor);

        int startX = webElement.getLocation().getX();
        int startY = webElement.getLocation().getY();
        int height = webElement.getSize().getHeight();


        int scrollStartX = startX ;
        int scrollStartY = startY + (height / 2);
        int scrollEndX = scrollStartX + xOffset;
        int scrollEndY = scrollStartY + yOffset;


        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        var start = new Point(scrollStartX, scrollStartY);
        var end = new Point(scrollEndX, scrollEndY);
        var swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        GetDriver.as(actor).appiumDriver().perform(Arrays.asList(swipe));



    }
}