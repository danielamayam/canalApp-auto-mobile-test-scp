package stepdefinitions;

import com.rimac.app.interactions.app.MenuItem;
import com.rimac.app.questions.VerificarDetalleSeguroPlanVida;
import com.rimac.app.questions.VerificarElemento;
import com.rimac.app.tasks.consultasVida.NavegaHastaCoberturaVidaConTigo;
import com.rimac.app.tasks.consultasVida.NavegaHastaElDetalleVidaConTigo;
import com.rimac.app.tasks.consultasVida.NavegaHastaPagos;
import com.rimac.app.tasks.consultasVida.DescargaPolizaDesdeElDetalle;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import static com.rimac.app.exceptions.Assertions.EL_TARGET_NO_ES_EL_ESPERADO;
import static com.rimac.app.userInterfaces.UiConsultasVida.*;
import static com.rimac.app.userInterfaces.UiSeguros.BTN_PAGAR_CUOTAS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PlanVidaConTigoStepDefinitions {


    @When("descarga el manual desde el detalle del seguro plan vida contigo desde el home {string}")
    public void seDescargaElManualDesdeElDetalleDelSeguroPlanVidaContigoDesdeElHome(String vigencia) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                DescargaPolizaDesdeElDetalle.go(vigencia)
        );
    }

    @Then("válido que se haya descargado el manual correctamente")
    public void validoQueSeHayaDescargadoElManualCorrectamente() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(PDF_VIEW)
        ));
    }

    @When("selecciona pagos del seguros plan vida contigo desde el home {string}")
    public void seleccionaPagosDelSegurosPlanVidaContigoDesdeElHome(String vigencia) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegaHastaPagos.go(vigencia)
        );
    }
    @Then("válido la deuda y los saldos de la póliza.")
    public void validoLaDeudaYLosSaldosDeLaPoliza() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(BTN_PAGAR_CUOTAS)
        ));

    }

    @When("selecciona cobertura del seguro plan vida contigo ingresando desde el home {string}")
    public void seleccionaCoberturaDelSeguroPlanVidaContigoIngresandoDesdeElHome(String vigencia) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegaHastaCoberturaVidaConTigo.go(vigencia)
        );
    }

    @Then("válido que se puedan visualizar las coberturas principales y coberturas adicionales")
    public void validoQueSePuedanVisualizarLasCoberturasPrincipalesYCoberturasAdicionales() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_MAS_SOBRE_TU_SEGURO)
        ));
    }

    @When("ingresa al detalle del seguro plan vida contigo desde el home {string}")
    public void ingresaAlDetalleDelSeguroPlanVidaContigoDesdeElHome(String vigencia) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegaHastaElDetalleVidaConTigo.go(vigencia)
        );
    }

    @Then("válido la información de la poliza {string} {string} {string} {string}")
    public void validoLaInformacionDeLaPoliza(String numeroPoliza, String vigencia, String contratantePoliza, String intermediarioPoliza) {
        OnStage.theActorInTheSpotlight().should(seeThat(
                VerificarDetalleSeguroPlanVida.on(numeroPoliza, LBL_NUMERO_DE_POLIZA))
        );
        OnStage.theActorInTheSpotlight().should(seeThat(
                VerificarDetalleSeguroPlanVida.on(vigencia, LBL_VIGENCIA)
        ));
        OnStage.theActorInTheSpotlight().should(seeThat(
                VerificarDetalleSeguroPlanVida.on(contratantePoliza, LBL_CONTRATANTE)
        ));
        OnStage.theActorInTheSpotlight().should(seeThat(
                VerificarDetalleSeguroPlanVida.on(intermediarioPoliza, LBL_INTERMEDIARIO)
        ));
    }

    @When("ingresa al menu tramites")
    public void ingresaAlMenuTramites() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                MenuItem.tramites()
        );
    }
}
