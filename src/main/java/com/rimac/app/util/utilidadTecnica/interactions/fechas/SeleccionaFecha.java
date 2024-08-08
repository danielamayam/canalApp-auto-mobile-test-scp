package com.rimac.app.util.utilidadTecnica.interactions.fechas;

import com.rimac.app.util.utilidadTecnica.interactions.Hide;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class SeleccionaFecha implements Interaction {
    private final Target target;
    private final String fecha;
    private final Target lblFechaMes;
    private final Target btnFechaYear;
    private final Target btnMesSiguiente;
    private final Target btnMesAnterior;
    private final Target btnAceptarFecha;

    public SeleccionaFecha(Target target, String fecha, Target lblFechaMes, Target btnFechaYear, Target btnMesSiguiente, Target btnMesAnterior, Target btnAceptarFecha) {
        this.target = target;
        this.fecha = fecha;
        this.lblFechaMes = lblFechaMes;
        this.btnFechaYear = btnFechaYear;
        this.btnMesSiguiente = btnMesSiguiente;
        this.btnMesAnterior = btnMesAnterior;
        this.btnAceptarFecha = btnAceptarFecha;
    }

    public static SeleccionaFecha para(Target target, String fecha, Target lblFechaMes, Target btnFechaYear, Target btnMesSiguiente, Target btnMesAnterior, Target btnAceptarFecha) {
        return (SeleccionaFecha) Tasks.instrumented(SeleccionaFecha.class, new Object[]{target, fecha, lblFechaMes, btnFechaYear, btnMesSiguiente, btnMesAnterior, btnAceptarFecha});
    }

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(new Performable[]{Tap.on(this.target), SeleccionaDataPickerFecha.conFecha(this.fecha, this.lblFechaMes, this.btnFechaYear, this.btnMesSiguiente, this.btnMesAnterior, this.btnAceptarFecha), Hide.keyboard()});
    }
}
