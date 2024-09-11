package com.rimac.app.tasks.serviciosDeSalud;

import com.rimac.app.interactions.app.FormularioClinica;
import com.rimac.app.interactions.app.MenuItem;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.rimac.app.userInterfaces.UiServiciosDeSalud.BTN_BUSCADOR_DE_CLINICAS;

public class BuscarClinicaDesdeTramites implements Task {

    private String nombre;

    public BuscarClinicaDesdeTramites(String nombre){
        this.nombre = nombre;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MenuItem.tramites(),
                Scroll.on(BTN_BUSCADOR_DE_CLINICAS),
                Tap.on(BTN_BUSCADOR_DE_CLINICAS),
                FormularioClinica.go(nombre)
        );
    }

    public static BuscarClinicaDesdeTramites go(String nombre){
        return Tasks.instrumented(BuscarClinicaDesdeTramites.class, nombre);
    }

}
