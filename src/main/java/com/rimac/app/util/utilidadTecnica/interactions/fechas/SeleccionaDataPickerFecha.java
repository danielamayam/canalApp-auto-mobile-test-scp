package com.rimac.app.util.utilidadTecnica.interactions.fechas;

import com.rimac.app.util.utilidadTecnica.interactions.ComandosCapabilities;
import com.rimac.app.util.utilidadTecnica.interactions.GetDriver;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import com.rimac.app.util.utilidadTecnica.utils.FormatoFechas;
import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleccionaDataPickerFecha implements Interaction {
    private final String fecha;
    private final Target lblFechaMes;
    private final Target btnFechaYear;
    private final Target btnMesSiguiente;
    private final Target btnMesAnterior;
    private final Target btnAceptarFecha;

    public SeleccionaDataPickerFecha(String fecha, Target lblFechaMes, Target btnFechaYear, Target btnMesSiguiente, Target btnMesAnterior, Target btnAceptarFecha) {
        this.fecha = fecha;
        this.lblFechaMes = lblFechaMes;
        this.btnFechaYear = btnFechaYear;
        this.btnMesSiguiente = btnMesSiguiente;
        this.btnMesAnterior = btnMesAnterior;
        this.btnAceptarFecha = btnAceptarFecha;
    }

    public static SeleccionaDataPickerFecha conFecha(String fecha, Target lblFechaMes, Target btnFechaYear, Target btnMesSiguiente, Target btnMesAnterior, Target btnAceptarFecha) {
        return (SeleccionaDataPickerFecha) Tasks.instrumented(SeleccionaDataPickerFecha.class, new Object[]{fecha, lblFechaMes, btnFechaYear, btnMesSiguiente, btnMesAnterior, btnAceptarFecha});
    }

    public <T extends Actor> void performAs(T actor) {
        if (ComandosCapabilities.isiOS(actor)) {
            List<WebElement> wheels = (List) GetDriver.as(actor).iosDriver().findElement(AppiumBy.className("XCUIElementTypePickerWheel"));
            ((WebElement)wheels.get(0)).sendKeys(new CharSequence[]{FormatoFechas.obtenerDia(FormatoFechas.separarFecha(this.fecha))});
            ((WebElement)wheels.get(1)).sendKeys(new CharSequence[]{FormatoFechas.obtenerMesString(FormatoFechas.separarFecha(this.fecha))});
            ((WebElement)wheels.get(2)).sendKeys(new CharSequence[]{FormatoFechas.obtenerYear(FormatoFechas.separarFecha(this.fecha))});
        } else if (ComandosCapabilities.isAndroid(actor)) {
            actor.attemptsTo(new Performable[]{Tap.on(this.btnFechaYear), SelectYear.conFecha(FormatoFechas.obtenerYear(FormatoFechas.separarFecha(this.fecha))), SelectMonth.conFecha(this.fecha, this.lblFechaMes, this.btnMesSiguiente, this.btnMesAnterior), Tap.onVerticalTextDay(FormatoFechas.obtenerDia(FormatoFechas.separarFecha(this.fecha))), Tap.on(this.btnAceptarFecha)});
        }

    }
}
