package com.rimac.app.util.utilidadTecnica.interactions;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class SelectNumberPicker implements Interaction {
    private final String value;

    public SelectNumberPicker(String value) {
        this.value = value;
    }

    public static SelectNumberPicker withValue(String value) {
        return (SelectNumberPicker) Tasks.instrumented(SelectNumberPicker.class, new Object[]{value});
    }

    public <T extends Actor> void performAs(T actor) {
        Target numberPicker = Target.the("lablel number picker").located(AppiumBy.id("android:id/numberpicker_input"));
        String dynamicXpath = "//android.widget.Button[@text=\"%s\"]";
        int actualYear = Integer.parseInt(numberPicker.resolveFor(actor).getText());

        for(Target previousYear = Target.the("previous year").located(AppiumBy.xpath(String.format(dynamicXpath, actualYear - 1))); !numberPicker.resolveFor(actor).getText().equals(this.value); previousYear = Target.the("YEAR").located(AppiumBy.xpath(String.format(dynamicXpath, actualYear - 1)))) {
            previousYear.resolveFor(actor).click();
            actualYear = Integer.parseInt(numberPicker.resolveFor(actor).getText());
        }

    }
}
