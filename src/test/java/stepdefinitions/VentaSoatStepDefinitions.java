package stepdefinitions;

import com.rimac.app.models.SuscripcionDesdePagos;
import com.rimac.app.questions.VerificarDetalleSeguroPlanVida;
import com.rimac.app.tasks.crossellRenovacion.DiligenciarFormularioSoat;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.actors.OnStage;
import static com.rimac.app.userInterfaces.UiCrossellRenovacion.LBL_MENSAJE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class VentaSoatStepDefinitions {

    @When("navega y diligencia el formulario de registro tu soat en 2 minutos")
    public void navegaYDiligenciaElFormularioDeRegistroTuSoatEnMinutos( DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                DiligenciarFormularioSoat.go(SuscripcionDesdePagos.setData(dataTable).get(0))
        );
    }

    @Then("válido la compra del plan exitosamente {string}")
    public void validoLaCompraDelPlanExitosamente(String mensaje) {
        OnStage.theActorInTheSpotlight().should(seeThat(
                VerificarDetalleSeguroPlanVida.on(mensaje, LBL_MENSAJE)
        ));
    }


}
