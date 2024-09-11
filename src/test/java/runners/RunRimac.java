package runners;


import com.rimac.app.util.excel.BeforeSuite;
import com.rimac.app.util.excel.DataToFeature;
import io.cucumber.junit.CucumberOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(RunnerPersonalizado.class)
/*@CucumberOptions(
        features = {"src/test/resources/features/"}
        ,tags = "@reembolsoSaludSinBeneficiariosDesdeSegurosf"
        ,glue = {"stepdefinitions"}
        ,plugin = {"pretty","json:target/cucumber-reports/cucumber.json"}
        ,snippets = CucumberOptions.SnippetType.CAMELCASE
)*/
public class RunRimac {

    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("src/test/resources/features/");
    }
}
