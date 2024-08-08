package com.rimac.app.util.utilidadTecnica.interactions.fechas;

import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import com.rimac.app.util.utilidadTecnica.utils.FormatoFechas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class SelectMonth implements Interaction {
    private final String fecha;
    private final Target lblFechaMes;
    private final Target btnMesSiguiente;
    private final Target btnMesAnterior;

    public SelectMonth(String fecha, Target lblFechaMes, Target btnMesSiguiente, Target btnMesAnterior) {
        this.fecha = fecha;
        this.lblFechaMes = lblFechaMes;
        this.btnMesSiguiente = btnMesSiguiente;
        this.btnMesAnterior = btnMesAnterior;
    }

    public static SelectMonth conFecha(String fecha, Target lblFechaMes, Target btnMesSiguiente, Target btnMesAnterior) {
        return (SelectMonth) Tasks.instrumented(SelectMonth.class, new Object[]{fecha, lblFechaMes, btnMesSiguiente, btnMesAnterior});
    }

    public <T extends Actor> void performAs(T actor) {
        String fechaCell = this.lblFechaMes.resolveFor(actor).getAttribute("contentDescription");
        int mesActual = Integer.parseInt(FormatoFechas.obtenerMesInt(FormatoFechas.separarFechaGoogle(fechaCell)[1]));
        int mesDeseado = Integer.parseInt(FormatoFechas.obtenerMesInt(FormatoFechas.obtenerMesString(FormatoFechas.separarFecha(this.fecha))));
        if (this.btnMesSiguiente.resolveFor(actor).isCurrentlyVisible()) {
            while(mesActual != mesDeseado) {
                if (mesActual < mesDeseado) {
                    actor.attemptsTo(new Performable[]{Tap.on(this.btnMesSiguiente)});
                } else {
                    actor.attemptsTo(new Performable[]{Tap.on(this.btnMesAnterior)});
                }

                fechaCell = this.lblFechaMes.resolveFor(actor).getAttribute("contentDescription");
                mesActual = Integer.parseInt(FormatoFechas.obtenerMesInt(FormatoFechas.separarFechaGoogle(fechaCell)[1]));
            }
        }

    }
}
