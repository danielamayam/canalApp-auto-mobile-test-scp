package com.rimac.app.interactions.app;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;
import java.util.List;
import static com.rimac.app.userInterfaces.UIAlertas.alertButtons;
import static com.rimac.app.userInterfaces.UiMenu.BTN_HOME;


public class SkipAlerts implements Interaction {

    private static final Logger LOGGER = LoggerFactory.getLogger(SkipAlerts.class);
    private static final int TIMEOUT_SECONDS = 30;
    private static final int REVALIDATION_WAIT_MILLIS = 1000;



    private <T extends Actor> boolean handleAlerts(T actor, WebDriverWait wait) {
        try {
            return wait.until(driver -> {
                if (BTN_HOME.resolveFor(actor).isVisible()) {
                    return false;
                }

                for (Target alertButton : alertButtons) {
                    List<WebElementFacade> elements = alertButton.resolveAllFor(actor);
                    if (!elements.isEmpty() && elements.get(0).isVisible()) {
                        actor.attemptsTo(Tap.on(alertButton));
                        LOGGER.info("Alerta manejada: {}", alertButton.getName());
                        return true;
                    }
                }
                return false;
            });
        } catch (TimeoutException e) {
            LOGGER.info("No se encontraron más alertas después de {} segundos.", TIMEOUT_SECONDS);
            return false;
        }
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriverWait wait = new WebDriverWait(actor.usingAbilityTo(BrowseTheWeb.class).getDriver(), Duration.ofSeconds(TIMEOUT_SECONDS));

        boolean alertsHandled;
        do {
            alertsHandled = handleAlerts(actor, wait);
            if (alertsHandled) {
                try {
                    Thread.sleep(REVALIDATION_WAIT_MILLIS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    LOGGER.warn("Interrupción durante la espera de revalidación", e);
                }
            }
        } while (alertsHandled);
        if (!BTN_HOME.resolveFor(actor).isVisible()) {
            LOGGER.warn("El botón de inicio no es visible después de manejar todas las alertas.");
        }
    }

    public static SkipAlerts dismissAlerts() {
        return Tasks.instrumented(SkipAlerts.class);
    }
}