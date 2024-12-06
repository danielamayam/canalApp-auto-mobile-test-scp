package stepdefinitions;

import com.rimac.app.interactions.app.EsperaExplicita;
import com.rimac.app.questions.VerificarElemento;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.rimac.app.exceptions.Assertions.EL_TARGET_NO_ES_EL_ESPERADO;
import static com.rimac.app.userInterfaces.UiLogin.ALERTA_MINIMA_RECOMENDADA;
import static com.rimac.app.userInterfaces.UiLogin.ALERTA_MINIMO_REQUERIDA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class NoFuncionalStepDefinitions {

    @Then("válido que aparezca el mensaje de la versión mínima requerida")
    public void válidoQueAparezcaElMensajeDeLaVersionMinimaRequerida() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(ALERTA_MINIMO_REQUERIDA)
        ));
    }

    @When("espera a que aparezca el mensaje de la versión")
    public void esperaAQueAparezcaElMensajeDeLaVersion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EsperaExplicita.empleada(30)
        );
    }

    @Then("válido que aparezca el mensaje de la versión mínima recomendada")
    public void válidoQueAparezcaElMensajeDeLaVersionMinimaRecomendada() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(ALERTA_MINIMA_RECOMENDADA)
        ));
    }

}
