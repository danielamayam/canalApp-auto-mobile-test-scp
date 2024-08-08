package com.rimac.app.stepdefinitions;

import com.rimac.app.questions.VerificarElemento;
import com.rimac.app.tasks.serviciosVehiculares.GestionarChoferRemplazo;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.rimac.app.exceptions.Assertions.EL_TARGET_NO_ES_EL_ESPERADO;
import static com.rimac.app.userInterfaces.UiServiciosVehiculares.LBL_MENSAJE_CHOFER;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ChoferReemplazoStepDefinitions {

    @When("ingresa a chofer remplazo desde tramites e inicia el tramite con la {string} del vehiculo")
    public void ingresaAChoferRemplazoDesdeTramitesEIniciaElTramiteConLaDelVehiculo(String placa) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GestionarChoferRemplazo.go(placa)
        );
    }

    @When("válido el seguimiento de chofer de reemplazo de la  {string}")
    public void validoElSeguimientoDeChoferDeReemplazoDeLa(String string) {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_MENSAJE_CHOFER)
        ));
    }

}
