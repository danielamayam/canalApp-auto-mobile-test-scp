package com.rimac.app.tasks.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.annotations.Step;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.json.JSONObject;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class ActualizarEjecucionZephyrScale implements Task {
    static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

    private static final String API_BASE_URL = variables.getProperty("JIRA-URL");;
    private static final String BEARER_TOKEN = variables.getProperty("JIRA-KEY");;

    private final String testCaseKey;
    private final String testCycleKey;
    private final String status;
    private final String comment;
    private final long duration;

    public ActualizarEjecucionZephyrScale(String testCaseKey, String testCycleKey, String status, String comment, long duration) {
        this.testCaseKey = testCaseKey;
        this.testCycleKey = testCycleKey;
        this.status = status;
        this.comment = comment;
        this.duration = duration;
    }

    @Override
    @Step("{0} actualiza la ejecución para el caso de prueba #testCaseKey en el ciclo #testCycleKey con estado #status")
    public <T extends Actor> void performAs(T actor) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            JSONObject createExecution = new JSONObject();
            createExecution.put("projectKey", obtenerProjectKey(testCaseKey));
            createExecution.put("testCaseKey", testCaseKey);
            createExecution.put("testCycleKey", testCycleKey);
            createExecution.put("statusName", mapearEstado(status));
            createExecution.put("comment", comment);
            createExecution.put("executionTime", duration);


            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_BASE_URL + "/testexecutions"))
                    .header("Authorization", "Bearer " + BEARER_TOKEN)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(createExecution.toString()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 201) {
                throw new RuntimeException("Error al crear/actualizar la ejecución de prueba: " + response.body());
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al interactuar con Zephyr Scale API", e);
        }
    }

    private String mapearEstado(String estado) {
        switch (estado.toLowerCase()) {
            case "passed":
                return "Pass";
            case "failed":
                return "Fail";
            case "blocked":
                return "Blocked";
            case "not executed":
                return "Not Executed";
            default:
                return estado;
        }
    }

    private String obtenerProjectKey(String testCaseKey) {
        return testCaseKey.split("-")[0];
    }

    public static ActualizarEjecucionZephyrScale conResultado(String testCaseKey, String testCycleKey, String status, String comment, long duration) {
        return Tasks.instrumented(ActualizarEjecucionZephyrScale.class, testCaseKey, testCycleKey, status, comment, duration);
    }
}