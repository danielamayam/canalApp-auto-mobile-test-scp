package com.rimac.app.util.utilidadTecnica.interactions.fechas;

import com.rimac.app.util.utilidadTecnica.interactions.ComandosCapabilities;
import com.rimac.app.util.utilidadTecnica.interactions.GetDriver;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import com.rimac.app.util.utilidadTecnica.utils.FormatoHora;
import com.rimac.app.util.utilidadTecnica.utils.HoraUI;
import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleccionaDataPickerHora implements Interaction {
    private String hora;
    private final Target btnAceptarHora;

    public SeleccionaDataPickerHora(String hora, Target btnAceptarHora) {
        this.hora = hora;
        this.btnAceptarHora = btnAceptarHora;
    }

    public static SeleccionaDataPickerHora para(String hora, Target btnAceptarHora) {
        return (SeleccionaDataPickerHora) Tasks.instrumented(SeleccionaDataPickerHora.class, new Object[]{hora, btnAceptarHora});
    }

    public <T extends Actor> void performAs(T actor) {
        if (ComandosCapabilities.isiOS(actor)) {
            List<WebElement> wheels = (List) GetDriver.as(actor).iosDriver().findElement(AppiumBy.className("XCUIElementTypePickerWheel"));
            if (wheels.size() == 3) {
                this.hora = FormatoHora.parseHora(this.hora);
                ((WebElement)wheels.get(2)).sendKeys(new CharSequence[]{FormatoHora.obtenerMeridiem(this.hora)});
            }

            ((WebElement)wheels.get(0)).sendKeys(new CharSequence[]{FormatoHora.obtenerHora(FormatoHora.separarHora(this.hora))});
            ((WebElement)wheels.get(1)).sendKeys(new CharSequence[]{FormatoHora.obtenerMinutos(FormatoHora.separarHora(this.hora))});
        } else if (ComandosCapabilities.isAndroid(actor)) {
            actor.attemptsTo(new Performable[]{Tap.on(HoraUI.BTN_MODO_TEXTO), Enter.theValue(new CharSequence[]{FormatoHora.obtenerHora(FormatoHora.separarHora(this.hora))}).into(HoraUI.TXT_HORA), Enter.theValue(new CharSequence[]{FormatoHora.obtenerMinutos(FormatoHora.separarHora(this.hora))}).into(HoraUI.TXT_MINUTOS), Tap.on(this.btnAceptarHora)});
        }

    }
}
