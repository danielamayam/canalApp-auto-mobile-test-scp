package com.rimac.app.tasks.serviciosDeSalud;

import com.rimac.app.interactions.app.IniciarReembolso;
import com.rimac.app.interactions.app.MenuItem;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import com.rimac.app.models.Reembolso;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.rimac.app.userInterfaces.UiMenu.BTN_SERVICIOS;
import static com.rimac.app.userInterfaces.UiSeguros.BTN_VER_DETALLE;
import static com.rimac.app.userInterfaces.UiServiciosDeSalud.BTN_REEMBOLSO_DE_SALUD;

public class DiligencioDatosReembolsoSeguros implements Task {

    private Reembolso reembolso;

    public DiligencioDatosReembolsoSeguros(Reembolso reembolso){
        this.reembolso = reembolso;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

                actor.attemptsTo(
                        MenuItem.seguros(),
                        Tap.on(BTN_VER_DETALLE),
                        Tap.on(BTN_SERVICIOS),
                        Scroll.on(BTN_REEMBOLSO_DE_SALUD),
                        Tap.on(BTN_REEMBOLSO_DE_SALUD),
                        IniciarReembolso.go(reembolso.getProductoContratante(), reembolso.getTipoCobertura())
                );
    }

    public static DiligencioDatosReembolsoSeguros go(Reembolso reembolso){
        return Tasks.instrumented(DiligencioDatosReembolsoSeguros.class, reembolso);
    }
}
