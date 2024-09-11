package com.rimac.app.interactions.tap;

import com.rimac.app.interactions.ComandosCapabilities;
import com.rimac.app.interactions.builders.Tap;
import com.rimac.app.userInterfaces.TransversalUI;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

public class TapText implements Interaction {
    private final String atributo;

    public TapText(String atributo) {
        this.atributo = atributo;
    }

    @Step("{0} tap to (#atributo)")
    public <T extends Actor> void performAs(T actor) {
        if (ComandosCapabilities.isiOS(actor)) {
            actor.attemptsTo(new Performable[]{Tap.on(TransversalUI.LBL_TEXTO_IOS.of(new String[]{this.atributo}))});
        } else if (ComandosCapabilities.isAndroid(actor)) {
            actor.attemptsTo(new Performable[]{Tap.on(TransversalUI.LBL_TEXT_ANDROID.of(new String[]{this.atributo}))});
        }

    }
}
