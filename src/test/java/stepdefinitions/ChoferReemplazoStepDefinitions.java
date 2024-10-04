package stepdefinitions;

import com.rimac.app.questions.VerificarElemento;
import com.rimac.app.tasks.serviciosVehiculares.CancelarChoferRemplazo;
import com.rimac.app.tasks.serviciosVehiculares.GestionarChoferRemplazo;
import com.rimac.app.tasks.serviciosVehiculares.ValidarCancelacionChoferReclamo;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import static com.rimac.app.exceptions.Assertions.EL_TARGET_NO_ES_EL_ESPERADO;
import static com.rimac.app.userInterfaces.UiServiciosVehiculares.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ChoferReemplazoStepDefinitions {

    @When("ingresa a chofer remplazo desde tramites e inicia el tramite con la {string} del vehiculo")
    public void ingresaAChoferRemplazoDesdeTramitesEIniciaElTramiteConLaDelVehiculo(String placa) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GestionarChoferRemplazo.go(placa)
        );
    }

    @When("válido el seguimiento de chofer de reemplazo de la  {string}")
    public void validoElSeguimientoDeChoferDeReemplazoDeLa(String placa) {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_SOLICITUD_CHOFER_REMPLAZO)
        ));
    }

    @When("se cancela la solicitud de chofer de reemplazo de la {string}")
    public void seCancelaLaSolicitudDeChoferDeReemplazoDeLa(String placa) {
       OnStage.theActorInTheSpotlight().attemptsTo(
               CancelarChoferRemplazo.go(placa)
       );
    }
    @Then("se debe mostrar un mensaje")
    public void seDebeMostrarUnMensaje() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_SOLICITUD_CANCELADA)
        ));
    }
    @Then("se valida que no se muestre en el home la solicitud de la {string}")
    public void seValidaQueNoSeMuestreEnElHomeLaSolicitudDeLa(String placa) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ValidarCancelacionChoferReclamo.go(placa)
        );
    }
}
