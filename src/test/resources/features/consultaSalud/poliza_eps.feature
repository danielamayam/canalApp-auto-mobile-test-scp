#Author: Daniel Amaya Marín

@ModuloConsultaSalud
Feature: Consulta Salud - Plan Medico EPS

  @ConsultaNumeroDePoliza @ScenarioWithoutData @regressionTest
  Scenario Outline: Usuario consulta el numero de poliza
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa al detalle del seguro de Salud
    Then válido el numero de poliza
    Examples: Tabla
      | numeroUsuario | contrasena |
      | 10318552      | Rimac2020  |