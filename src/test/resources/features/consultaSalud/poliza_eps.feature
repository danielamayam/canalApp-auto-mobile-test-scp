#Author: Daniel Amaya Marín

@ModuloConsultaSalud_1 @Regresion
Feature: Consulta Salud - Plan Medico EPS

  @ConsultaNumeroDePoliza
  Scenario Outline: Usuario consulta el numero de poliza
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa al detalle del seguro de Salud
    Then válido el numero de poliza
    Examples: Tabla
      | numeroUsuario | contrasena |
    ##@externaldata@./src/test/resources/datadriven/ModuloConsultaSalud/Poliza_eps_data.xlsx@ConsultaNumeroDePoliza@1
   |10318552   |Rimac2020|

  @ConsultaCoberturaDeLaPoliza
  Scenario Outline: Usuario consulta las coberturas de la poliza
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa la cobertura del seguro de Salud
    Then válido la cobertura del seguro
    Examples: Tabla
      | numeroUsuario | contrasena |
    ##@externaldata@./src/test/resources/datadriven/ModuloConsultaSalud/Poliza_eps_data.xlsx@ConsultaNumeroDePoliza@1
   |10318552   |Rimac2020|

