package com.rimac.app.util.utilidadTecnica.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class Wait implements Interaction {
    private final int time;

    public Wait(int time) {
        this.time = time;
    }

    public static Wait explicit(int time) {
        return (Wait) Tasks.instrumented(Wait.class, new Object[]{time});
    }

    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep((long)this.time);
        } catch (InterruptedException var3) {
            InterruptedException e = var3;
            e.printStackTrace();
        }

    }
}
