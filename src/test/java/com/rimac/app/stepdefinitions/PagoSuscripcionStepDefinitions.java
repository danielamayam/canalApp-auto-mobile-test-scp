package com.rimac.app.stepdefinitions;

import com.rimac.app.models.Login;
import com.rimac.app.models.SuscripcionDesdePagos;
import com.rimac.app.questions.VerificarElemento;
import com.rimac.app.tasks.login.InicioDeSesion;
import com.rimac.app.tasks.pagos.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.rimac.app.exceptions.Assertions.EL_TARGET_NO_ES_EL_ESPERADO;
import static com.rimac.app.userInterfaces.UiSeguros.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PagoSuscripcionStepDefinitions {

    @Given("que {string} inicia sesión correctamente")
    public void queIniciaSesionCorrectamente(String actor, DataTable dataTable) {
        OnStage.theActorCalled(actor).wasAbleTo(InicioDeSesion.go(Login.setData(dataTable).get(0)));
    }

    @When("ingresa los datos bancarios de su tarjeta")
    public void ingresaLosDatosBancariosDeSuTarjeta(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SuscribeSuTarjetaDesdePagos.go(SuscripcionDesdePagos.setData(dataTable).get(0))
        );
    }
    @Then("válido que se haya agregado la tarjeta a mis tarjetas {string}")
    public void validoQueSeHayaAgregadoLaTarjetaAMisTarjetas(String numeroTarjeta) {
        String ultimos4Caracteres = numeroTarjeta.length() > 4 ? numeroTarjeta.substring(numeroTarjeta.length() - 4) : numeroTarjeta;
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_NUMERO_TARJETA(ultimos4Caracteres))
        ));
    }

    @When("ingresa los datos bancarios de su tarjeta desde perfil")
    public void ingresaLosDatosBancariosDeSuTarjetaDesdePerfil(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SuscribeSuTarjetaDesdePerfil.go(SuscripcionDesdePagos.setData(dataTable).get(0))
        );
    }

    @When("ingresa a pagos del seguro vehicular {string} {string}")
    public void ingresaAPagosDelSeguroVehicular(String placa, String vigencia) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegaHastaPagos.go(placa, vigencia)
        );
    }
    @When("ingresa los datos de su tarjeta")
    public void ingresaLosDatosDeSuTarjeta(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AfiliarTarjetaDesdePagos.go(SuscripcionDesdePagos.setData(dataTable).get(0))
        );
    }

    @Then("válido el mensaje de afiliacion exitoso")
    public void validoElMensajeDeAfiliacionExitoso() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_TARJETA_CAMBIADA)
        ));
    }

    @When("realiza el pago suscribiendo mi tarjeta")
    public void realizaElPagoSuscribiendoMiTarjeta(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                PagoSuscribiendoTarjeta.go(SuscripcionDesdePagos.setData(dataTable).get(0))
        );
    }

    @Then("válido el mensaje de confirmación")
    public void validoElMensajeDeConfirmacion() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_PAGO_EXITOSO)
        ));
    }

    @When("realiza el pago seleccionando la tarjeta asociada {string}")
    public void realizaElPagoSeleccionandoLaTarjetaAsociada(String numeroTarjeta) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                PagoConTarjetaAsociada.go(numeroTarjeta)
        );
    }
}
