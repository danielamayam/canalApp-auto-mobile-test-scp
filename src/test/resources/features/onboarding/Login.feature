#Author: Daniel Amaya Marín

@Onboarding
Feature: onboarding

  @Login @TestCaseKey:TDARA-T194
  Scenario Outline: Usuario inicia sesión en Rimac para acceder a todos los servicios
    Given que "Daniel" ingreso en la aplicacion Rimac
    When se ingresan credenciales correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    Then válido el inicio de sesión correctamente

    Examples: Tabla
      | numeroUsuario | contrasena |
       ##@externaldata@/Users/chm3572/Documents/datadriven/Onboarding/Login_data.xlsx@Login@1


  @LogOut @TestCaseKey:TDARA-T195
  Scenario Outline: Usuario cierra sesión después de iniciar sesión en Rimac
    Given que "Daniel" ingreso en la aplicacion Rimac
    When se ingresan credenciales correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    And cierra sesión correctamente
    Then válido el mensaje de la pantalla de contraseña

    Examples:Tabla
      | numeroUsuario | contrasena |
    ##@externaldata@/Users/chm3572/Documents/datadriven/Onboarding/Login_data.xlsx@LogOut@1


  @OlvidasteTuContrasenia @TestCaseKey:TDARA-T938
  Scenario Outline: Usuario recupera su contraseña
    Given que "Daniel" seleccionó la opción ¿Olvidaste tu contraseña? "<numeroUsuario>"
    When diligencia el código de validación

    Examples:Tabla
      | numeroUsuario |
      | 45778112      |
