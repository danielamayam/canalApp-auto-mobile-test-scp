package com.rimac.app.stepdefinitions;

import com.rimac.app.questions.VerificarDetalleSeguroPlanVida;
import com.rimac.app.questions.VerificarElemento;
import com.rimac.app.tasks.consultasVida.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.rimac.app.exceptions.Assertions.EL_TARGET_NO_ES_EL_ESPERADO;
import static com.rimac.app.userInterfaces.UiConsultasVida.*;
import static com.rimac.app.userInterfaces.UiInactividad.LBL_MENSAJE_INACTIVIDAD;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PlanVidaFlexibleStepDefinitions {

    @When("descargan las características de mi seguro de vida flexible {string} {string} {string}")
    public void seDescarganLasCaracteristicasDeMiSeguroDeVidaFlexible(String month, String year, String vigencia) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                DescargarEstadoSeguroVidaFlexible.go(month, year, vigencia)
        );
    }

    @Then("válido que se haya descargado correctamente")
    public void validoQueSeHayaDescargadoCorrectamente() {

    }

    @When("selecciona cobertura del seguro plan vida flexible {string}")
    public void seleccionaCoberturaDelSeguroPlanVidaFlexible(String vigencia) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegaHastaCoberturaSeguroVidaFlexible.go(vigencia)
        );
    }

    @Then("válido que se puedan visualizar las coberturas principales y coberturas adicionales del plan vida flexible")
    public void validoQueSePuedanVisualizarLasCoberturas() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(BTN_COBERTURA_ADICIONALES)
        ));
    }

    @When("ingresa al detalle del seguro plan vida flexible {string}")
    public void ingresaAlDetalleDelSeguroPlanVidaFlexible(String vigencia) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegaHastaElDetalleSeguroVidaFlexible.go(vigencia)
        );
    }

    @Then("válido la información de la poliza flexible {string} {string} {string}")
    public void validoLaInformacionDeLaPolizaFlexible(String numeroPoliza, String vigenciaDesde, String contratantePoliza) {
        OnStage.theActorInTheSpotlight().should(seeThat(
                VerificarDetalleSeguroPlanVida.on(numeroPoliza, LBL_NUMERO_DE_POLIZA))
        );
        OnStage.theActorInTheSpotlight().should(seeThat(
                VerificarDetalleSeguroPlanVida.on(vigenciaDesde, LBL_VIGENCIA)
        ));
        OnStage.theActorInTheSpotlight().should(seeThat(
                VerificarDetalleSeguroPlanVida.on(contratantePoliza, LBL_CONTRATANTE)
        ));
    }

    @When("se mantiene inactivo por 15 minutos")
    public void seMantieneInactivoPorMinutos() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EsperarTiempoDeInactividad.go()
        );
    }

    @Then("válido el mensaje de tiempo inactivo")
    public void validoElMensajeParaRetornarAlLoginDesdePlanVidaFlexible() {
        OnStage.theActorInTheSpotlight().should(seeThat(
                EL_TARGET_NO_ES_EL_ESPERADO, VerificarElemento.as(LBL_MENSAJE_INACTIVIDAD)
        ));
    }

    @When("selecciona pagos del seguros plan vida flexible {string}")
    public void seleccionaPagosDelSegurosPlanVidaFlexible(String vigencia) {
     OnStage.theActorInTheSpotlight().attemptsTo(
             NavegaHastaPagosVidaFlexible.go(vigencia)
     );
    }

}
