#Author: Daniel Amaya Marín

Feature: onboarding

  @ValidaVersionMinimaRequerida @TestCaseKey:TDARA-T82
  Scenario: Usuario valida la versión mínima requerida
    Given que "Daniel" ingreso en la aplicacion Rimac
    When espera a que aparezca el mensaje de la versión
    Then válido que aparezca el mensaje de la versión mínima requerida

  @ValidaVersionMinimaRecomendada @TestCaseKey:TDARA-T81
  Scenario: Usuario valida la versión mínima recomendada
    Given que "Daniel" ingreso en la aplicacion Rimac
    When espera a que aparezca el mensaje de la versión
    Then válido que aparezca el mensaje de la versión mínima recomendada
