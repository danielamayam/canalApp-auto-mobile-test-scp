package com.rimac.app.interactions.tap;

import com.rimac.app.interactions.GetDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TapByCoordinates implements Interaction {
    private final int x;
    private final int y;

    public TapByCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Step("{0} taps on coordinate (#x, #y)")
    public <T extends Actor> void performAs(T actor) {
        (new Actions(GetDriver.as(actor).appiumDriver())).click((WebElement)(new TapOptions()).withPosition((new PointOption()).withCoordinates(this.x, this.y))).perform();
    }
}