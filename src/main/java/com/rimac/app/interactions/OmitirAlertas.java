package com.rimac.app.interactions;

import com.rimac.app.util.utilidadTecnica.interactions.builders.Tap;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

import static com.rimac.app.userInterfaces.UIAlertas.*;

public class OmitirAlertas implements Interaction {

    private int intentos;

    public static OmitirAlertas home(int intentos) {
        return Tasks.instrumented(OmitirAlertas.class, intentos);
    }

    public OmitirAlertas(int intentos) {
        this.intentos = intentos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        Target[] targets = {
                AHORANOREGISTROHUELLA_BTN,
                TALVEZMASTARDE_BTN,
                CERRAREMAIL_BTN,
                ACTIVARINSPECCIONVEHICULAR_BTN,
                ENTERATEPORAHORA_BTN,
                ESTARBIEN_BTN,
                RENOVARSE_BTN,
                CERRAR_MODALES_CAMPANNIAS_BTN
        };

        for (Target target : targets) {
            boolean isVisible = false;
            for (int attempts = 0; attempts < 2; attempts++) {
                isVisible = target.resolveFor(actor).isVisible();
                if (isVisible) {
                    break;
                }
            }
            if (isVisible) {
                actor.attemptsTo(
                        Tap.on(target),
                        EsperarElemento.por(5)
                );
                continue;
            }
        }

    }
}
