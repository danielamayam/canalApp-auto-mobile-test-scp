package stepdefinitions;

import com.rimac.app.questions.VerificarElemento;
import com.rimac.app.tasks.serviciosDeSalud.BuscarClinicaDesdeElHome;
import com.rimac.app.tasks.serviciosDeSalud.BuscarClinicaDesdeTramites;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import static com.rimac.app.exceptions.Assertions.EL_TARGET_NO_ES_EL_ESPERADO;
import static com.rimac.app.userInterfaces.UiServiciosDeSalud.LBL_COPAGO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class BuscadorClinicasStepDefinitions {


    @When("se filtra la clinica {string} desde el home")
    public void seFiltraLaClinicaDesdeElHome(String nombreClinica) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                BuscarClinicaDesdeElHome.go(nombreClinica)
        );
    }

    @Then("válido el copago de la clinica")
    public void validoElCopagoDeLaClinica() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_COPAGO)
        ));
    }

    @When("se filtra la clinica {string} desde el tramites")
    public void seFiltraLaClinicaDesdeElTramites(String nombreClinica) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                BuscarClinicaDesdeTramites.go(nombreClinica)
        );
    }


}
