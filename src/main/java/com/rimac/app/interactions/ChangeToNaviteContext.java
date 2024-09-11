package com.rimac.app.interactions;

import io.appium.java_client.remote.SupportsContextSwitching;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.util.Set;
import java.util.logging.Logger;

public class ChangeToNaviteContext implements Interaction {
    public static ChangeToNaviteContext isNativo(){
        return Tasks.instrumented(ChangeToNaviteContext.class);
    }

    @Override
    @Step("ChangeToNativeContext")
    public <T extends Actor> void performAs(T actor) {
        Set<String> contextNames = ((SupportsContextSwitching) GetDriver.as(actor).appiumDriver()).getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains("NATIVE_APP")) {
                ((SupportsContextSwitching) GetDriver.as(actor).appiumDriver()).context(contextName);
            }
        }
        Logger.getAnonymousLogger().info("Contexto Nativo Activado");
    }
}
