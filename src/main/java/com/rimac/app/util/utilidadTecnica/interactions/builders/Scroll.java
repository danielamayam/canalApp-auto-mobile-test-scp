package com.rimac.app.util.utilidadTecnica.interactions.builders;

import com.rimac.app.util.utilidadTecnica.interactions.scroll.ScrollElement;
import com.rimac.app.util.utilidadTecnica.interactions.scroll.ScrollLateral;
import com.rimac.app.util.utilidadTecnica.interactions.scroll.ScrollTarget;
import com.rimac.app.util.utilidadTecnica.interactions.scroll.ScrollText;
import com.rimac.app.util.utilidadTecnica.utils.ComandosScroll;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

public class Scroll {
    private Scroll() {
        throw new IllegalStateException("Error en Scroll");
    }

    public static ScrollTarget on(Target target) {
        return (ScrollTarget) Tasks.instrumented(ScrollTarget.class, new Object[]{target});
    }

    public static ScrollElement on(WebElement element) {
        return (ScrollElement)Tasks.instrumented(ScrollElement.class, new Object[]{element});
    }

    public static ScrollText on(String selector, String text) {
        return (ScrollText)Tasks.instrumented(ScrollText.class, new Object[]{selector, text});
    }

    public static ScrollText onVerticalTextScrollView(String text) {
        return (ScrollText)Tasks.instrumented(ScrollText.class, new Object[]{ComandosScroll.uiSelectorTextoVerticalScrollView(), text});
    }

    public static ScrollLateral onHorizontalText(String text) {
        return (ScrollLateral)Tasks.instrumented(ScrollLateral.class, new Object[]{ComandosScroll.uiSelectorTextoHorizontal(), text});
    }

    public static ScrollText onVerticalTextRecyclerView(String text) {
        return (ScrollText)Tasks.instrumented(ScrollText.class, new Object[]{ComandosScroll.uiSelectorTextoVerticalRecyclerView(), text});
    }
}
