package stepdefinitions;

import com.rimac.app.questions.VerificarElemento;
import com.rimac.app.tasks.pagos.DescargaDelHistorialDePago;
import com.rimac.app.tasks.pagos.NavegaHastaElHistorialDePagos;
import com.rimac.app.tasks.pagos.NavegaHastaElListadoDeCuotas;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import static com.rimac.app.exceptions.Assertions.EL_TARGET_NO_ES_EL_ESPERADO;
import static com.rimac.app.userInterfaces.UiSeguros.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PagoHistorialStepDefinitions {

    @When("ingresa a las cuotas por pagar del Seguro vehicular desde seguros {string} y {string}")
    public void ingresaALasCuotasPorPagarDelSeguroVehicularDesdeSeguros(String placa, String vigencia) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegaHastaElListadoDeCuotas.vehiculos(placa, vigencia)
        );
    }
    @Then("válido el listado de las cuotas")
    public void validoElListadoDeLasCuotas() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(CHKlISTADO)
        ));
    }

    @When("ingresa al historial del seguro vehicular {string} {string}")
    public void ingresaAlHistorialDelSeguroVehicular(String placa, String vigencia) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegaHastaElHistorialDePagos.go(placa, vigencia)
        );
    }

    @Then("válido el listado de pagos realizados")
    public void validoElListadoDePagosRealizados() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_PAGADO)
        ));
    }

    @When("descargo el historial de pago")
    public void seDescargaElHistorialDePago() {
       OnStage.theActorInTheSpotlight().attemptsTo(
               DescargaDelHistorialDePago.go()
       );
    }
    @Then("válido la descarga del pdf con el historial de pagos")
    public void validoLaDescargaDelPdfConElHistorialDePagos() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(PDF_HISTORIAL)
        ));
    }

    @When("ingresa a las cuotas por pagar del Seguro Planes Medicos EPS")
    public void ingresaALasCuotasPorPagarDelSeguroPlanesMedicosEPS() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegaHastaElListadoDeCuotas.eps()
        );
    }

    @Then("válido el listado de las cuotas del Seguro Planes Medicos EPS")
    public void validoElListadoDeLasCuotasDelSeguroPlanesMedicosEPS() {

    }


}
