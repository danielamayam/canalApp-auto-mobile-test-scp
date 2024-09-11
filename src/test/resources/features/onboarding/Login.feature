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
   |47927254   |Rimac2020|



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
   |10318552   |Rimac2020|


#  @OlvidasteTuContrasenia
#  Scenario Outline: Usuario recupera su contrasena
#    Given se selecciona la opción ¿Olvidaste tu contraseña?
#    And se ingresa el tipo y número de documento: "<tipoID>", "<id>"
#    When se selecciona la opción Responder Preguntas
#    And se ingresa la fecha de nacimiento "<fechaNacimiento>" y los seguros "<seguros>" que cuenta el cliente
#    Then debe permitir el ingreso de una nueva contraseña
#    And debe de aparecer el mensaje de "Tu contraseña fue cambiada con éxito"
#
#    Examples:
#      | tipoID | id       | fechaNacimiento | seguros |
#      | DNI    | 10667872 | 08/01/1978      | SOAT    |
