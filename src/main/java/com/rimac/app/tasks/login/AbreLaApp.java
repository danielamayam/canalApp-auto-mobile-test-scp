package com.rimac.app.tasks.login;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.logging.Logger;

public class AbreLaApp implements Task {

    public AbreLaApp(){  }

    public static AbreLaApp rimac(){
        return Tasks.instrumented(AbreLaApp.class);
    }

    @Override
    @Step("App Rimac abierta")
    public <T extends Actor> void performAs(T actor) {
        Logger.getAnonymousLogger().info("Se abre app Rimac");
    }
}
