#Author: Daniel Amaya Marín

@Onboarding_3 @Regresion
Feature: onboarding

  @Login @ScenarioWithoutData
  Scenario Outline: Usuario inicia sesión en Rimac para acceder a todos los servicios
    Given que "Daniel" ingreso en la aplicacion Rimac
    When se ingresan credenciales correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    Then válido el inicio de sesión correctamente

    Examples: Tabla
      | numeroUsuario | contrasena |
       ##@externaldata@./src/test/resources/datadriven/Onboarding/Login_data.xlsx@Login@1


  @LogOut @ScenarioWithoutData
  Scenario Outline: Usuario cierra sesión después de iniciar sesión en Rimac
    Given que "Daniel" ingreso en la aplicacion Rimac
    When se ingresan credenciales correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    And cierra sesión correctamente
    Then válido el mensaje de la pantalla de contraseña

    Examples:Tabla
      | numeroUsuario | contrasena |
    ##@externaldata@./src/test/resources/datadriven/Onboarding/Login_data.xlsx@LogOut@1


  @OlvidasteTuContrasenia
  Scenario Outline: Usuario recupera su contraseña
    Given que "Daniel" seleccionó la opción ¿Olvidaste tu contraseña? "<numeroUsuario>"
    When diligencia el código de validación "<email>" "<contrasena>"
    And actualiza la contraseña "<newContrasena>"
    Then válido el mensaje "Tu contraseña fue cambiada con éxito"

    Examples:
      | numeroUsuario | email                             | contrasena     | newContrasena |
      | 45778112      | automations_rimac_scp@hotmail.com | Medellin123** | Rimac2020     |
