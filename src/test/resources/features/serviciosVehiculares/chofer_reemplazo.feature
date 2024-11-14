#Author: Daniel Amaya Marín

@ModuloServiciosVehiculares_7 @Regresion
Feature: Servicios Vehiculares - Chofer Reemplazo

  @ChoferReemplazo @SeguimientoChoferReemplazo @TestCaseKey:TDARA-T448
  Scenario Outline: Usuario solicitar chofer de reemplazo
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a chofer remplazo desde tramites e inicia el tramite con la "<placa>" del vehiculo
    And válido el seguimiento de chofer de reemplazo de la  "<placa>"

    Examples: Tabla
      | numeroUsuario | contrasena | placa  |
  ##@externaldata@./src/test/resources/datadriven/serviciosVehiculares/Asistencia_vehicular.xlsx@ChoferReemplazo@1

  

  @CancelarChoferReemplazo @TestCaseKey:TDARA-T449
  Scenario Outline: Cancelar  Chofer de reemplazo
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When se cancela la solicitud de chofer de reemplazo de la "<placa>"
    Then se debe mostrar un mensaje
    And se valida que no se muestre en el home la solicitud de la "<placa>"

    Examples: Tabla
      | numeroUsuario | contrasena | placa  |
      | 01317724      | Rimac2020  | ASR977 |
