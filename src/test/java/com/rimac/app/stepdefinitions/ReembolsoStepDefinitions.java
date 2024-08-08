package com.rimac.app.stepdefinitions;

import com.rimac.app.models.Reembolso;
import com.rimac.app.questions.VerificarElemento;
import com.rimac.app.tasks.serviciosDeSalud.AdjuntarDocumentos;
import com.rimac.app.tasks.serviciosDeSalud.DiligencioDatosReembolsoInicio;
import com.rimac.app.tasks.serviciosDeSalud.DiligencioDatosReembolsoTramites;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.rimac.app.exceptions.Assertions.EL_TARGET_NO_ES_EL_ESPERADO;
import static com.rimac.app.userInterfaces.UiReembolso.LBL_SOLICITUD_RECIBIDA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ReembolsoStepDefinitions {

    @When("registra los datos del reembolso de salud sin beneficiario con tipo de cobertura desde tramites")
    public void registraLosDatosDelReembolsoDeSaludSinBeneficiarioConTipoDeCobertura(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                DiligencioDatosReembolsoTramites.go(Reembolso.setData(dataTable).get(0))
        );
    }
    @When("adjuntamos los documentos y comprobantes del reembolso con tipo de cobertura {string}")
    public void adjuntamosLosDocumentosYComprobantesDelReembolsoConTipoDeCobertura(String string) {
        OnStage.theActorInTheSpotlight().attemptsTo(AdjuntarDocumentos.go());
    }

    @When("registra los datos del reembolso de salud sin beneficiario con tipo de cobertura desde el home")
    public void registraLosDatosDelReembolsoDeSaludSinBeneficiarioConTipoDeCoberturaDesdeElHome(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                DiligencioDatosReembolsoInicio.go(Reembolso.setData(dataTable).get(0))
        );
    }

    @Then("válido seguimiento de reembolso de salud desde tramites")
    public void validoSeguimientoDeReembolsoDeSaludDesdeTramites() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_SOLICITUD_RECIBIDA)
        ));
    }


}
