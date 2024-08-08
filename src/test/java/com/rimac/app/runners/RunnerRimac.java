package com.rimac.app.runners;

import io.cucumber.junit.platform.engine.Constants;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@ExtendWith(SerenityJUnit5Extension.class)
//@SelectClasspathResource("com/rimac/app/stepdefinitions")
//@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME,value = "src/test/resources/features/")
//@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME,value = "com/rimac/app/stepdefinitions")
//@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME,value = "@ModuloPagos")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME,value = "false")
//@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, json:target/cucumber-reports/cucumber.json")
public class RunnerRimac {
}
