package com.rimac.app.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ObtenerLimiteElemento implements Task {

    private final Target elemento;

    public ObtenerLimiteElemento(Target elemento) {
        this.elemento = elemento;
    }

    public static ObtenerLimiteElemento para(Target elemento) {
        return instrumented(ObtenerLimiteElemento.class, elemento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement webElement = elemento.resolveFor(actor);
        int x = webElement.getLocation().getX();
        int y = webElement.getLocation().getY();
        int width = webElement.getSize().getWidth();
        int height = webElement.getSize().getHeight();

        System.out.println("Los límites del elemento son:");
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("ancho: " + width);
        System.out.println("alto: " + height);
    }


}