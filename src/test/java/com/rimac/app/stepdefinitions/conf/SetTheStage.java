package com.rimac.app.stepdefinitions.conf;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import java.net.MalformedURLException;

public class SetTheStage {

    @Before
    public void setStage(Scenario scenario) throws MalformedURLException {
        OnStage.setTheStage(new OnlineCast());
    }
}
