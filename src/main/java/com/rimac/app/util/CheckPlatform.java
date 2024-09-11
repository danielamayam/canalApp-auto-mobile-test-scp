package com.rimac.app.util;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class CheckPlatform implements Task {

    private AppiumDriver driver;

    public CheckPlatform(AppiumDriver driver) {
        this.driver = driver;
    }

    public static CheckPlatform using(AppiumDriver driver) {
        return Tasks.instrumented(CheckPlatform.class, driver);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String platformName = driver.getCapabilities().getCapability("platformName").toString();
        System.out.println("Platform Name: " + platformName);

        if (platformName.equalsIgnoreCase("Android")) {
            System.out.println("The device is running Android.");
        } else if (platformName.equalsIgnoreCase("iOS")) {
            System.out.println("The device is running iOS.");
        } else {
            System.out.println("Unknown platform.");
        }
    }
}
