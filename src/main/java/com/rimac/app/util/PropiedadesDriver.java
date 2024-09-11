package com.rimac.app.util;

import io.appium.java_client.AppiumDriver;

import java.util.logging.Level;

import static java.util.logging.Logger.getAnonymousLogger;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class PropiedadesDriver {

    private PropiedadesDriver() {
        throw new IllegalStateException("Utility class");
    }

    public static String obtenerCapability(String propiedad) {
        AppiumDriver driver = getProxiedDriver();
        return driver.getCapabilities().getCapability(propiedad).toString();
    }

    public static void esperaEnSegundos(int tiempo) {
        try {
            Thread.sleep(tiempo * 1000L);
        } catch (InterruptedException ex) {
            getAnonymousLogger().log(Level.SEVERE, "error ejecutando la espera", ex);
            Thread.currentThread().interrupt();
        }
    }

}
