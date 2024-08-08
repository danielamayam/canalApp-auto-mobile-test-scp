package com.rimac.app.util.utilidadTecnica.interactions.fechas;

import com.rimac.app.util.utilidadTecnica.interactions.Hide;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class SeleccionaHora implements Interaction {
    private final Target target;
    private final String hora;
    private final Target btnAceptarHora;

    public SeleccionaHora(Target target, String hora, Target btnAceptarHora) {
        this.target = target;
        this.hora = hora;
        this.btnAceptarHora = btnAceptarHora;
    }

    public static SeleccionaHora para(Target target, String hora, Target btnAceptarHora) {
        return (SeleccionaHora) Tasks.instrumented(SeleccionaHora.class, new Object[]{target, hora, btnAceptarHora});
    }

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(new Performable[]{Tap.on(this.target), SeleccionaDataPickerHora.para(this.hora, this.btnAceptarHora), Hide.keyboard()});
    }
}
