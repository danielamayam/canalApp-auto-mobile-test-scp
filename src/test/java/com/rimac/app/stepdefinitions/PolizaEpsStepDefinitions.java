package com.rimac.app.stepdefinitions;

import com.rimac.app.questions.VerificarElemento;
import com.rimac.app.tasks.consultaSalud.NavegaHastaElDetallePoliza;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.rimac.app.exceptions.Assertions.EL_TARGET_NO_ES_EL_ESPERADO;
import static com.rimac.app.userInterfaces.UiConsultasVida.LBL_NUMERO_DE_POLIZA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PolizaEpsStepDefinitions {

    @When("ingresa al detalle del seguro de Salud")
    public void ingresaAlDetalleDelSeguroDeSalud() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegaHastaElDetallePoliza.go()
        );
    }

    @Then("válido el numero de poliza")
    public void validoElNumeroDePoliza() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_NUMERO_DE_POLIZA)
        ));
    }

}
