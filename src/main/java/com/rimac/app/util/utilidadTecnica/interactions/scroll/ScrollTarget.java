package com.rimac.app.util.utilidadTecnica.interactions.scroll;

import com.rimac.app.util.utilidadTecnica.interactions.Swipe;
import com.rimac.app.util.utilidadTecnica.interactions.exceptions.ObjetosException;
import com.rimac.app.util.utilidadTecnica.utils.enums.ConfiguracionInteracciones;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;

public class ScrollTarget implements Interaction {
    private final Target target;
    private int cant = 0;

    public ScrollTarget(Target target) {
        this.target = target;
    }

    public <T extends Actor> void performAs(T actor) {
        while(true) {
            if (!this.target.resolveFor(actor).isCurrentlyVisible() && this.cant <= ConfiguracionInteracciones.CANTIDAD_INTERACCIONES.getOpcionInt()) {
                actor.attemptsTo(new Performable[]{Swipe.as(actor).fromBottom().toTop()});
                ++this.cant;
                if (this.cant != ConfiguracionInteracciones.CANTIDAD_INTERACCIONES.getOpcionInt()) {
                    continue;
                }

                String var10002 = ObjetosException.errorBuscandoObjeto();
                throw new ObjetosException(var10002 + this.target);
            }

            return;
        }
    }
}
