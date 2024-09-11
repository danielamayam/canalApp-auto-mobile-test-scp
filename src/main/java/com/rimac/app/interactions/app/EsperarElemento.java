package com.rimac.app.interactions.app;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EsperarElemento implements Interaction {
    private static final int MILLISECONDS = 1000;
    private int tryTimes;

    public EsperarElemento(int tryTimes) {
        this.tryTimes = tryTimes;
    }

    @Step("Espera un tiempo")
    @Override
    public <T extends Actor> void performAs(T actor) {
        while (tryTimes > 0) {
            try {
                Thread.sleep(MILLISECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            tryTimes = tryTimes - 1;
        }
    }

    public static EsperarElemento por(int tryTimes) {
        return Tasks.instrumented(EsperarElemento.class, tryTimes);
    }
}
