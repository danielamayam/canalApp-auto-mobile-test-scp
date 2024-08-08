package com.rimac.app.util.utilidadTecnica.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.ScreenOrientation;

public class GirarPantalla implements Interaction {
    private final ScreenOrientation rotacion;

    public GirarPantalla(ScreenOrientation rotacion) {
        this.rotacion = rotacion;
    }

    public static GirarPantalla horizontal() {
        return (GirarPantalla) Tasks.instrumented(GirarPantalla.class, new Object[]{ScreenOrientation.LANDSCAPE});
    }

    public static GirarPantalla vertical() {
        return (GirarPantalla)Tasks.instrumented(GirarPantalla.class, new Object[]{ScreenOrientation.PORTRAIT});
    }

    public <T extends Actor> void performAs(T actor) {
        GetDriver.as(actor).iosDriver().rotate(this.rotacion);
    }
}
