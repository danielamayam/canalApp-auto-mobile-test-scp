package com.rimac.app.util;

import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ValoresDeProperties {
    private static final Properties properties = new Properties();
    static EnvironmentVariables variables2 = SystemEnvironmentVariables.createEnvironmentVariables();
    static String ambiente = variables2.getProperty("environment");
    //static String ambiente = "android";

    public static String ambiente() {
        return ambiente;
    }

    static {
        try (FileInputStream fileInputStream = new FileInputStream("serenity.properties")) {
            properties.load(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
