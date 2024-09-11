package stepdefinitions;

import com.rimac.app.questions.VerificarDetalleSeguroPlanVida;
import com.rimac.app.questions.VerificarElemento;
import com.rimac.app.tasks.consultasVehicularYSOAT.DescargarPolizaDigital;
import com.rimac.app.tasks.consultasVehicularYSOAT.NavegaHastaElHistorialSeguroVehicular;
import com.rimac.app.tasks.consultasVehicularYSOAT.NavegaHastaElResumen;
import com.rimac.app.tasks.consultasVehicularYSOAT.NavegaHastaLaCobertura;
import com.rimac.app.tasks.pagos.NavegaHastaPagos;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import static com.rimac.app.exceptions.Assertions.EL_TARGET_NO_ES_EL_ESPERADO;
import static com.rimac.app.userInterfaces.UiConsultasVehicularSoat.LBL_NUMERO_POLIZA;
import static com.rimac.app.userInterfaces.UiConsultasVida.PDF_VIEW;
import static com.rimac.app.userInterfaces.UiSeguros.LBL_PAGADO;
import static com.rimac.app.userInterfaces.UiServiciosVehiculares.BTN_ACCIDENTES_PERSONALES;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PolizaVehicularStepDefinitions {

    @When("ingresa al resumen del seguro soat {string}")
    public void seIngresaAlResumenDelSeguroSoat(String placa) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegaHastaElResumen.go(placa)
        );
    }

    @Then("válido el número de póliza soat {string}")
    public void validoElNumeroDePolizaSoat(String numeroPoliza) {
        OnStage.theActorInTheSpotlight().should(seeThat(
                VerificarDetalleSeguroPlanVida.on(numeroPoliza, LBL_NUMERO_POLIZA)
        ));
    }

    @When("ingresa el historial del seguro vehicular {string} {string}")
    public void seIngresaAlDetalleDelSeguroVehicular(String placa, String vigencia) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegaHastaPagos.go(placa, vigencia),
                NavegaHastaElHistorialSeguroVehicular.go()
        );
    }

    @Then("válido la cuota pagada en el historial")
    public void validoLaCuotaPagadaEnElHistorial() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_PAGADO)
        ));
    }

    @When("descargar la póliza digital del seguro vehicular {string} {string}")
    public void seDescargarLaPolizaDigitalDelSeguroVehicular(String placa, String vigencia) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                DescargarPolizaDigital.go(placa, vigencia)
        );
    }
    @Then("válido la descarga del pdf con la información")
    public void validoLaDescargaDelPdfConLaInformacion() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(PDF_VIEW)
        ));
    }

    @When("navega hasta la cobertura del seguro {string} {string}")
    public void navegaHastaLaCoberturaDelSeguro(String placa, String vigencia) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegaHastaLaCobertura.go(placa, vigencia)
        );

    }
    @Then("válido la cobertura del seguro")
    public void validoLaCoberturaDelSeguro() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(BTN_ACCIDENTES_PERSONALES)
        ));
    }
}
