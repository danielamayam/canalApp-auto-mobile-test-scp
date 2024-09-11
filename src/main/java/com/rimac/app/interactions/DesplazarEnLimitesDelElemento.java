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

public class DesplazarEnLimitesDelElemento implements Task {

    private final Target elemento;
    private final int xOffset;
    private final int yOffset;

    private final String monthOrYear;

    public DesplazarEnLimitesDelElemento(Target elemento, int xOffset, int yOffset, String monthOrYear) {
        this.elemento = elemento;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.monthOrYear = monthOrYear;

    }

    public static DesplazarEnLimitesDelElemento en(Target elemento, int xOffset, int yOffset, String monthOrYear) {
        return instrumented(DesplazarEnLimitesDelElemento.class, elemento, xOffset, yOffset, monthOrYear);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElement webElement = elemento.resolveFor(actor);

        int startX = webElement.getLocation().getX();
        int startY = webElement.getLocation().getY();
        int width = webElement.getSize().getWidth();
        int height = webElement.getSize().getHeight();


        int scrollStartX = startX + (int)(width * (monthOrYear == "Mes" ? 0.25 : 0.75));
        int scrollStartY = startY + (height / 2);
        int scrollEndX = scrollStartX + xOffset;
        int scrollEndY = scrollStartY + yOffset;


        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        var start = new Point(scrollStartX, scrollStartY);
        var end = new Point (scrollEndX, scrollEndY);
        var swipe = new Sequence(finger, 1);

        if(monthOrYear == "Mes"){
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            GetDriver.as(actor).appiumDriver().perform(Arrays.asList(swipe));
        }else {
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            GetDriver.as(actor).appiumDriver().perform(Arrays.asList(swipe));
        }
    }
}