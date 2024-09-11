package com.rimac.app.interactions.app;

import com.rimac.app.interactions.GetDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class TapByCoordinates implements Interaction {
    private final int x;
    private final int y;

    public TapByCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Step("{0} taps on coordinate (#x, #y)")
    public <T extends Actor> void performAs(T actor) {

        AppiumDriver driver = GetDriver.as(actor).appiumDriver();

        if (driver != null && driver.getSessionId() != null) {
            new TouchAction((PerformsTouchActions) driver)
                    .tap(TapOptions.tapOptions().withPosition(PointOption.point(x, y)))
                    .perform();
        } else {
            throw new RuntimeException("Driver not initialized or session not active");
        }
    }

    public static TapByCoordinates on(int x, int y){
        return Tasks.instrumented(TapByCoordinates.class, x,y);
    }
}
