package com.rimac.app.util.utilidadTecnica.interactions;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleccionarPickerWheel implements Interaction {
    private final String data;

    public SeleccionarPickerWheel(String data) {
        this.data = data;
    }

    public static SeleccionarPickerWheel conData(String data) {
        return (SeleccionarPickerWheel) Tasks.instrumented(SeleccionarPickerWheel.class, new Object[]{data});
    }

    public <T extends Actor> void performAs(T actor) {
        List<WebElement> wheels = (List)GetDriver.as(actor).iosDriver().findElement(AppiumBy.className("XCUIElementTypePickerWheel"));
        ((WebElement)wheels.get(0)).sendKeys(new CharSequence[]{this.data});
        actor.attemptsTo(new Performable[]{Hide.keyboard()});
    }
}
