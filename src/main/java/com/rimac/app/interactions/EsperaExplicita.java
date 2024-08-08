package com.rimac.app.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class EsperaExplicita implements Interaction {
    private int minutos;

    public EsperaExplicita(int minutos) {
        this.minutos = minutos * 1000;
    }

    public static EsperaExplicita empleada(int minutos) {
        return (EsperaExplicita)Tasks.instrumented(EsperaExplicita.class, new Object[]{minutos});
    }

    @Step("Ingresa tiempo espera necesario en milisegundos")
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep((long)this.minutos);
        } catch (InterruptedException var3) {
            InterruptedException e = var3;
            e.printStackTrace();
        }
    }
}
