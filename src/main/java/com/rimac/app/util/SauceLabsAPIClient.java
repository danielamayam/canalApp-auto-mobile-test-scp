package com.rimac.app.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class SauceLabsAPIClient {

    public String getJobId(String platform) {

        String apiUrl = "https://api.us-west-1.saucelabs.com/v1/rdc/jobs";
        String username = "daniel.cerquera";
        String token = "a8917a2c-e152-4c0b-b2c0-4fac36b684ca";
        String jobId = null;
        int limit = 2;

        try {
            URL url = new URL(apiUrl + "?limit=" + limit);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set basic authentication header
            String auth = username + ":" + token;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
            conn.setRequestProperty("Authorization", "Basic " + encodedAuth);

            conn.setRequestMethod("GET");

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonResponse = objectMapper.readTree(reader);

            // Close resources
            reader.close();
            conn.disconnect();




            // Process JSON response to get the job ID
            JsonNode entities = jsonResponse.get("entities");
            if (entities.isArray() && entities.size() > 0) {
                JsonNode selectedEntity = null;

                // Iterar sobre las entidades para encontrar el job adecuado
                for (JsonNode entity : entities) {
                    String os = entity.get("os").asText().toLowerCase();  // Convertir a minúsculas para comparar
                    String consolidatedStatus = entity.get("consolidated_status").asText().toLowerCase();  // Convertir a minúsculas para comparar

                    // Validar que el consolidated_status no sea "passed"
                    if ((!consolidatedStatus.equals("passed")) && os.equalsIgnoreCase(ValoresDeProperties.ambiente())) {
                        // Si no hay entidad seleccionada aún, tomar esta como la seleccionada
                        if (selectedEntity == null) {
                            selectedEntity = entity;
                        } else {
                            // Si ya hay una entidad seleccionada, comparar el OS
                            String selectedOs = selectedEntity.get("os").asText().toLowerCase();
                            if (os.equals(selectedOs)) {
                                // Si tienen el mismo OS, tomar el primer registro encontrado
                                selectedEntity = entity;
                            }
                        }
                    }
                }

                // Si se encontró una entidad válida, tomar su ID
                if (selectedEntity != null) {
                    jobId = selectedEntity.get("id").asText();
                } else {
                    System.out.println("No entities found with valid criteria.");
                }
            } else {
                System.out.println("No entities found in the JSON response.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jobId;
    }

}
