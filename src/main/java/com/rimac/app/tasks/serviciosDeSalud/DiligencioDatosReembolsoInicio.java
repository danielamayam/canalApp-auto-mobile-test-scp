package com.rimac.app.tasks.serviciosDeSalud;

import com.rimac.app.interactions.EsperarElemento;
import com.rimac.app.interactions.Hide;
import com.rimac.app.interactions.Swipe;
import com.rimac.app.interactions.app.IniciarReembolso;
import com.rimac.app.interactions.builders.Scroll;
import com.rimac.app.interactions.builders.Tap;
import com.rimac.app.models.Reembolso;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.rimac.app.userInterfaces.UiCrossellRenovacion.BTN_CONTINUAR;
import static com.rimac.app.userInterfaces.UiServiciosDeSalud.*;
import static com.rimac.app.userInterfaces.UiServiciosDeSalud.LBL_CARGAR_DOCUMENTOS;

public class DiligencioDatosReembolsoInicio implements Task {

    private Reembolso reembolso;

    public DiligencioDatosReembolsoInicio(Reembolso reembolso){
        this.reembolso = reembolso;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Swipe.as(actor).fromBottom().toTop(),
                Tap.on(BTN_REEMBOLSO_DE_SALUD),
                IniciarReembolso.go(reembolso.getProductoContratante(), reembolso.getTipoCobertura())
        );
    }

    public static DiligencioDatosReembolsoInicio go(Reembolso reembolso){
        return Tasks.instrumented(DiligencioDatosReembolsoInicio.class, reembolso);
    }


}
