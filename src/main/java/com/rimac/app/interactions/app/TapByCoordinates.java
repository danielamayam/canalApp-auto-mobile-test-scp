package com.rimac.app.interactions.app;

import com.rimac.app.interactions.GetDriver;
import io.appium.java_client.AppiumDriver;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

public class TapByCoordinates implements Interaction {
    private final int x;
    private final int y;

    public TapByCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Step("{0} taps on coordinate (#x, #y)")
    public <T extends Actor> void performAs(T actor) {
        AppiumDriver driver = GetDriver.as(actor).appiumDriver();

        if (driver != null && driver.getSessionId() != null) {
            try {
                // Esperar un poco para asegurarse de que la interfaz esté cargada
                Thread.sleep(1000);

                // Verificar si las coordenadas están dentro de los límites de la pantalla
                org.openqa.selenium.Dimension screenSize = driver.manage().window().getSize();
                if (x > screenSize.getWidth() || y > screenSize.getHeight()) {
                    throw new IllegalArgumentException("Las coordenadas están fuera de los límites de la pantalla");
                }

                // Usar acciones W3C para realizar el tap
                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                Sequence tap = new Sequence(finger, 1)
                        .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
                        .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                        .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

                driver.perform(Arrays.asList(tap));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("La acción de tap fue interrumpida", e);
            } catch (Exception e) {
                throw new RuntimeException("Error al realizar el tap en las coordenadas (" + x + ", " + y + "): " + e.getMessage(), e);
            }
        } else {
            throw new RuntimeException("Driver no inicializado o sesión no activa");
        }
    }

    public static TapByCoordinates on(int x, int y) {
        return Tasks.instrumented(TapByCoordinates.class, x, y);
    }
}