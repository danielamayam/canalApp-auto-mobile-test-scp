package com.rimac.app.interactions.app;
import com.rimac.app.interactions.GetDriver;
import io.appium.java_client.PerformsTouchActions;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.time.Duration;

import static java.sql.DriverManager.getDriver;

public class SerenitySwipeAction implements Interaction {

    private final String textToFind;
    private final By containerLocator;
    private final int maxSwipes;

    public SerenitySwipeAction(String textToFind, By containerLocator, int maxSwipes) {
        this.textToFind = textToFind;
        this.containerLocator = containerLocator;
        this.maxSwipes = maxSwipes;
    }

    @Override
    @Step("{0} swipes horizontally until finding the text '#textToFind'")
    public <T extends Actor> void performAs(T actor) {
        AppiumDriver driver = GetDriver.as(actor).appiumDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Dimension size = driver.manage().window().getSize();

        int startX = (int) (size.width * 0.8);
        int endX = (int) (size.width * 0.2);
        int middleY = size.height / 2;

        for (int i = 0; i < maxSwipes; i++) {
            try {
                WebElement container = wait.until(ExpectedConditions.presenceOfElementLocated(containerLocator));
                if (container.findElements(By.xpath("//*[contains(@text, '" + textToFind + "')]")).size() > 0) {
                    return; // Text found, exit the method
                }
            } catch (Exception e) {
                // Text not found, continue with the swipe
            }

            new TouchAction((PerformsTouchActions) driver)
                    .press(PointOption.point(startX, middleY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(endX, middleY))
                    .release()
                    .perform();
        }

        throw new AssertionError("Text '" + textToFind + "' not found after " + maxSwipes + " swipes.");
    }

    public static SerenitySwipeAction swipeUntilTextFound(String textToFind, By containerLocator, int maxSwipes) {
        return new SerenitySwipeAction(textToFind, containerLocator, maxSwipes);
    }
}

