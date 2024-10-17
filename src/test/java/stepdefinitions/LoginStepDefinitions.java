package stepdefinitions;

import com.rimac.app.models.Login;
import com.rimac.app.questions.VerificarElemento;
import com.rimac.app.questions.VerificarLogin;
import com.rimac.app.tasks.login.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import static com.rimac.app.userInterfaces.UiLogin.LBL_MENSAJE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class LoginStepDefinitions {


    @Given("que {string} ingreso en la aplicacion Rimac")
    public void queIngresoEnLaAplicacionRimac(String actor) {
        OnStage.theActorCalled(actor).wasAbleTo(
                AbreLaApp.rimac()
        );
    }

    @When("se ingresan credenciales correctamente")
    public void seIngresanCredencialesCorrectamente(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                InicioDeSesion.go(Login.setData(dataTable).get(0))
        );
    }

    @Then("válido el inicio de sesión correctamente")
    public void validoElInicioDeSesionCorrectamente() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                VerificarLogin.as()
        ));
    }

    @When("cierra sesión correctamente")
    public void cierraSesionCorrectamente() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CerrarSesion.go()
        );
    }
    @Then("válido el mensaje de la pantalla de contraseña")
    public void validoElMensajeDeLaPantallaDeContrasena() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                VerificarElemento.as(LBL_MENSAJE)
        ));
    }

    @Given("que {string} seleccionó la opción ¿Olvidaste tu contraseña? {string}")
    public void queSeleccionóLaOpciónOlvidasteTuContraseña(String actor, String usuario) {
        OnStage.theActorCalled(actor).wasAbleTo(
                SeleccionarOlvidasteTuContrasena.go(usuario)
        );
    }
    @When("diligencia el código de validación")
    public void diligenciaElCódigoDeValidación() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                DiligenciarCodigoEmail.go()
        );
    }
}
