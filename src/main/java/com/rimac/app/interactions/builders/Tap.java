package com.rimac.app.interactions.builders;

import com.rimac.app.interactions.tap.*;
import com.rimac.app.util.ComandosScroll;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;


public class Tap {
    private Tap() {
        throw new IllegalStateException("Error en Tap");
    }

    public static TapByTarget on(Target target) {
        return (TapByTarget)Tasks.instrumented(TapByTarget.class, new Object[]{target});
    }

    public static TapByCoordinates on(int x, int y) {
        return (TapByCoordinates)Tasks.instrumented(TapByCoordinates.class, new Object[]{x, y});
    }

    public static TapByElement on(WebElement element) {
        return (TapByElement)Tasks.instrumented(TapByElement.class, new Object[]{element});
    }

    public static TapOnVisibleObject siElElementoEsVisible(Target target) {
        return (TapOnVisibleObject)Tasks.instrumented(TapOnVisibleObject.class, new Object[]{target});
    }

    public static TapByText onVerticalTextScrollView(String text) {
        return (TapByText)Tasks.instrumented(TapByText.class, new Object[]{ComandosScroll.uiSelectorTextoVerticalScrollView(), text});
    }

    public static TapByText onHorizontalext(String text) {
        return (TapByText)Tasks.instrumented(TapByText.class, new Object[]{ComandosScroll.uiSelectorTextoHorizontal(), text});
    }

    public static TapByText onVerticalExactText(String text) {
        return (TapByText)Tasks.instrumented(TapByText.class, new Object[]{ComandosScroll.uiSelectorTextoVerticalScrollViewContainsExact(), text});
    }

    public static TapByText onVerticalTextView(String text) {
        return (TapByText)Tasks.instrumented(TapByText.class, new Object[]{ComandosScroll.uiSelectorTextoVerticalTextView(), text});
    }

    public static TapByText onVerticalTextFeha(String text) {
        return (TapByText)Tasks.instrumented(TapByText.class, new Object[]{ComandosScroll.uiSelectorFechaVertical(), text});
    }

    public static TapByText onVerticalTextYear(String text) {
        return (TapByText)Tasks.instrumented(TapByText.class, new Object[]{ComandosScroll.uiSelectorYearVertical(), text});
    }

    public static TapByText onVerticalTextPlace(String text) {
        return (TapByText)Tasks.instrumented(TapByText.class, new Object[]{ComandosScroll.uiSelectorPlaceVertical(), text});
    }

    public static TapByText onVerticalTextDay(String text) {
        return (TapByText)Tasks.instrumented(TapByText.class, new Object[]{ComandosScroll.uiSelectorDayVertical(), text});
    }

    public static TapByText onVerticalTextFecha(String text) {
        return (TapByText)Tasks.instrumented(TapByText.class, new Object[]{ComandosScroll.uiSelectorFechaVertical(), text});
    }

    public static TapText enElTexto(String atributo) {
        return (TapText)Tasks.instrumented(TapText.class, new Object[]{atributo});
    }
}