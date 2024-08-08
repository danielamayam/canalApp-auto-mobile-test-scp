package com.rimac.app.stepdefinitions;

import com.rimac.app.tasks.consultaSalud.NavegaHastaElDetallePoliza;
import com.rimac.app.tasks.consultasVehicularYSOAT.NavegaHastaElResumen;
import com.rimac.app.tasks.inactividad.NavegaHastaDescuentos;
import com.rimac.app.tasks.inactividad.NavegaHastaDetalle;
import com.rimac.app.tasks.inactividad.NavegaHastaPerfil;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

public class SesionExpiradaStepDefinitions {
    @When("navega hasta la informacion del perfil")
    public void navegaHastaLaInformacionDelPerfil() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegaHastaPerfil.go()
        );
    }

    @When("navega al detalle del seguro planes medicos EPS")
    public void navegaAlDetalleDelSeguroPlanesMedicosEPS() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegaHastaElDetallePoliza.go()
        );
    }


    @When("ingresa al detalle de la {string} {string} del seguro vehicular")
    public void ingresaAlDetalleDeLaDelSeguroVehicular(String placa, String vigencia) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegaHastaDetalle.go(placa, vigencia)
        );
    }

    @When("ingresa al detalle del Seguro SOAT desde Seguros {string} {string}")
    public void ingresaAlDetalleDelSeguroSOATDesdeSeguros(String placa, String vigencia) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegaHastaElResumen.go(placa)
        );
    }

    @When("ingresa a la opcion Descuento en asistencias desde tramites")
    public void ingresaALaOpcionDescuentoEnAsistenciasDesdeTramites() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegaHastaDescuentos.go()
        );
    }
}
