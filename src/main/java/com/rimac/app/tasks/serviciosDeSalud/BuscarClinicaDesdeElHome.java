package com.rimac.app.tasks.serviciosDeSalud;

import com.rimac.app.interactions.FormularioClinica;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Scroll;
import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import static com.rimac.app.userInterfaces.UiServiciosDeSalud.*;

public class BuscarClinicaDesdeElHome implements Task {

    private String nombre;

    public BuscarClinicaDesdeElHome(String nombre){
        this.nombre = nombre;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.on(BTN_BUSCADOR_DE_CLINICAS),
                Tap.on(BTN_BUSCADOR_DE_CLINICAS),
                FormularioClinica.go(nombre)
        );
    }

    public static BuscarClinicaDesdeElHome go(String nombre){
        return Tasks.instrumented(BuscarClinicaDesdeElHome.class, nombre);
    }

}