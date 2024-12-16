package stepdefinitions;

import com.rimac.app.questions.VerificarElemento;
import com.rimac.app.tasks.medicoADomicilio.RegistrandoDireccion;
import com.rimac.app.tasks.medicoADomicilio.SinDependientes;
import com.rimac.app.tasks.medicoADomicilio.VariasPolizasVariosDependientesDesdeTramites;
import com.rimac.app.tasks.medicoADomicilio.VariosDependientes;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import static com.rimac.app.exceptions.Assertions.EL_TARGET_NO_ES_EL_ESPERADO;
import static com.rimac.app.userInterfaces.UiReembolso.LBL_SOLICITUD_RECIBIDA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class MedicoADomiciloStepDefinitions {
    @When("registra los datos del médico a domicilio desde el home")
    public void registraLosDatosDelMedicoADomicilioDesdeElHome() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SinDependientes.go()
        );
    }

    @When("registra los datos del médico a domicilio desde el home con varios dependientes")
    public void registraLosDatosDelMedicoADomicilioDesdeElHomeConVariosDependientes() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VariosDependientes.go()
        );
    }

    @When("registra los datos del médico a domicilio desde tramites con varios dependientes")
    public void registraLosDatosDelMedicoADomicilioDesdeTramitesConVariosDependientes() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VariasPolizasVariosDependientesDesdeTramites.go()
        );
    }

    @When("registra los datos del médico a domicilio desde tramites cambiando de dirección")
    public void registraLosDatosDelMedicoADomicilioDesdeTramitesCambiandoDeDireccion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegistrandoDireccion.go()
        );
    }

    @When("registra los datos del médico a domicilio desde seguros sin dependientes")
    public void registraLosDatosDelMedicoADomicilioDesdeSegurosSinDependientes() {

    }

    @Then("válido la solicitud de médico a domicilio")
    public void validoLaSolicitudDeMedicoADomicilio() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_SOLICITUD_RECIBIDA)
        ));
    }

}
