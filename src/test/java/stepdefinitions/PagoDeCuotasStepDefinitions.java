package stepdefinitions;

import com.rimac.app.models.SuscripcionDesdePagos;
import com.rimac.app.questions.VerificarElemento;
import com.rimac.app.tasks.pagos.NavegaHastaElHistorialDePagoDespuesDelPago;
import com.rimac.app.tasks.pagos.NavegaHastaPagosEPS;
import com.rimac.app.tasks.pagos.NavegaHastaPagosSoat;
import com.rimac.app.tasks.pagos.SuscribeSuTarjetaConDebitoAutomatico;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import static com.rimac.app.exceptions.Assertions.EL_TARGET_NO_ES_EL_ESPERADO;
import static com.rimac.app.userInterfaces.UiSeguros.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PagoDeCuotasStepDefinitions {

    @When("realiza el pago suscribiendo mi tarjeta con debito automatico")
    public void realizaElPagoSuscribiendoMiTarjetaConDebitoAutomatico(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SuscribeSuTarjetaConDebitoAutomatico.go(SuscripcionDesdePagos.setData(dataTable).get(0))
        );
    }

    @Then("debe mostrar el mensaje Hemos recibido tu pago!")
    public void debeMostrarElMensajeHemosRecibidoTuPago() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_PAGO_EXITOSO)
        ));
    }

    @When("navega hasta el historial de pago")
    public void navegaHastaElHistorialDePago() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegaHastaElHistorialDePagoDespuesDelPago.go()
        );
    }

    @Then("válido la cuota pagada en el historial de pago")
    public void validoLaCuotaPagadaEnElHistorialDePago() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_PAGADO)
        ));
    }

    @When("ingresa a pagos del seguro soat {string} {string}")
    public void ingresaAPagosDelSeguroSoat(String placa, String vigencia) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegaHastaPagosSoat.go(placa,vigencia)
        );
    }

    @Then("válido el detalle del pago anual")
    public void debeMostrarElDetalleDelPagoAnual() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_PAGADO)
        ));
    }

    @When("ingresa a pagos del seguro planes medicos EPS")
    public void ingresaAPagosDelSeguroPlanesMedicosEPS() {
       OnStage.theActorInTheSpotlight().attemptsTo(
               NavegaHastaPagosEPS.go()
       );
    }

    @Then("debe mostrar mensaje {string}")
    public void debeMostrarMensaje(String string) {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_MENSAJE_2)
        ));
    }
}
