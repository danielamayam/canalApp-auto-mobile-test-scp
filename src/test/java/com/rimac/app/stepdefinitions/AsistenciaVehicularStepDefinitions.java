package com.rimac.app.stepdefinitions;

import com.rimac.app.questions.VerificarElemento;
import com.rimac.app.tasks.serviciosVehiculares.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.rimac.app.exceptions.Assertions.EL_TARGET_NO_ES_EL_ESPERADO;
import static com.rimac.app.userInterfaces.UiServiciosVehiculares.BTN_QUE_BUENO;
import static com.rimac.app.userInterfaces.UiServiciosVehiculares.LBL_MENSAJE_CHOFER;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class AsistenciaVehicularStepDefinitions {
    @When("ingresa a asistencias vehiculares desde tramites e inicia el tramite")
    public void ingresaAAsistenciasVehicularesDesdeTramitesEIniciaElTramite() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegaHastaAsistenciasVehiculares.go()
        );
    }

    @When("selecciona los datos de asistencia")
    public void seleccionaLosDatosDeAsistencia() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionaLosDatosAsistenciasVehiculares.go()
        );
    }

    @Then("válido el seguimiento de la asistencia vehicular de la {string}")
    public void validoElSeguimientoDeLaAsistenciaVehicularDeLa(String string) {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_MENSAJE_CHOFER)
        ));
    }

    @When("selecciona los datos de la asistencia grua")
    public void seleccionaLosDatosDeLaAsistenciaGrua() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionaLosDatosAsistenciasVehicularesGrua.go()
        );
    }

    @Then("válido el seguimiento de la asistencia vehicular grua de la {string}")
    public void validoElSeguimientoDeLaAsistenciaVehicularGruaDeLa(String string) {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_MENSAJE_CHOFER)
        ));
    }

    @When("selecciona los datos de la asistencia problema")
    public void seleccionaLosDatosDeLaAsistenciaProblema() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionaLosDatosAsistenciasVehicularesProblema.go()
        );
    }

    @Then("válido el seguimiento de la asistencia vehicular problema de la {string}")
    public void validoElSeguimientoDeLaAsistenciaVehicularProblemaDeLa(String string) {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_MENSAJE_CHOFER)
        ));
    }

    @When("selecciona los datos de ayuda mecanico")
    public void seleccionaLosDatosDeAyudaMecanico() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionaLosDatosAsistenciasVehicularesAuxilioMecanico.go()
        );
    }

    @Then("válido el seguimiento de ayuda mecanico de la {string}")
    public void validoElSeguimientoDeAyudaMecanicoDeLa(String string) {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(BTN_QUE_BUENO)
        ));
    }


    @Then("válido el mensaje de solicitud")
    public void validoElMensajeDeSolicitud() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_MENSAJE_CHOFER)
        ));
    }

}
