package stepdefinitions;

import com.rimac.app.models.Reembolso;
import com.rimac.app.questions.VerificarElemento;
import com.rimac.app.tasks.serviciosDeSalud.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import static com.rimac.app.exceptions.Assertions.EL_TARGET_NO_ES_EL_ESPERADO;
import static com.rimac.app.userInterfaces.UiReembolso.CARD_REEMBOLSO;
import static com.rimac.app.userInterfaces.UiReembolso.LBL_SOLICITUD_RECIBIDA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ReembolsoStepDefinitions {

    @When("registra los datos del reembolso de salud sin beneficiario con tipo de cobertura desde tramites")
    public void registraLosDatosDelReembolsoDeSaludSinBeneficiarioConTipoDeCobertura(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                DiligencioDatosReembolsoTramites.go(Reembolso.setData(dataTable).get(0))
        );
    }
    @When("adjuntamos los documentos y comprobantes del reembolso con tipo de cobertura")
    public void adjuntamosLosDocumentosYComprobantesDelReembolsoConTipoDeCobertura() {
        OnStage.theActorInTheSpotlight().attemptsTo(AdjuntarDocumentos.go());
    }

    @When("registra los datos del reembolso de salud sin beneficiario con tipo de cobertura desde el home")
    public void registraLosDatosDelReembolsoDeSaludSinBeneficiarioConTipoDeCoberturaDesdeElHome(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                DiligencioDatosReembolsoInicio.go(Reembolso.setData(dataTable).get(0))
        );
    }

    @When("registra los datos del reembolso de salud sin beneficiario con tipo de cobertura desde seguros")
    public void registraLosDatosDelReembolsoDeSaludSinBeneficiarioConTipoDeCoberturaDesdeSeguros(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                DiligencioDatosReembolsoSeguros.go(Reembolso.setData(dataTable).get(0))
        );
    }

    @Then("válido seguimiento de reembolso")
    public void validoSeguimientoDeReembolsoDeSaludDesdeTramites() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(CARD_REEMBOLSO)
        ));
    }

    @When("adjuntamos los documentos y comprobantes del reembolso odontologico")
    public void adjuntamosLosDocumentosYComprobantesDelReembolsoOdontologico() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AdjuntarDocumentosOdontologico.go()
        );
    }


    @When("registra los datos del reembolso odontologico sin beneficiario con tipo de cobertura y tratamiento desde tramites")
    public void registraLosDatosDelReembolsoOdontologicoSinBeneficiarioConTipoDeCoberturaYTratamientoDesdeTramites(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                DiligencioDatosReembolsoOdontologicoTramites.go(Reembolso.setData(dataTable).get(0))
        );
    }

    @When("registra los datos del reembolso de salud con beneficiario con tipo de cobertura desde tramites")
    public void registraLosDatosDelReembolsoDeSaludConBeneficiarioConTipoDeCoberturaDesdeTramites(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                DiligencioDatosReembolsoBeneficiario.go(Reembolso.setData(dataTable).get(0))
        );
    }
    @When("adjuntamos los documentos y comprobantes del reembolso con beneficiario")
    public void adjuntamosLosDocumentosYComprobantesDelReembolsoConBeneficiario() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AdjuntarDocumentosSalud.go()
        );
    }

}
