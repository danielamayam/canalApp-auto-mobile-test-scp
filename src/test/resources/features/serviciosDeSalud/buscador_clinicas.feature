#Author: Daniel Amaya Marín

@ModuloServiciosDeSalud_7 @Regresion
Feature: Servicios de Salud - Buscador de clinicas


  @BuscadordeClinicasdesdeHome @TestCaseKey:TDARA-T210
  Scenario Outline: Usuario busca una clinica desde el home
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When se filtra la clinica "<nomClinica>" desde el home
    Then válido el copago de la clinica

    Examples: Tabla
      | numeroUsuario | contrasena | nomClinica           |
      ##@externaldata@./src/test/resources/datadriven/serviciosDeSalud/Buscador_clinicas_data.xlsx@BuscadordeClinicasdesdeHome@1


  @BuscadordeClinicasdesdeTramites @TestCaseKey:TDARA-T211
  Scenario Outline: Usuario busca una clinica desde menu tramites
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When se filtra la clinica "<nomClinica>" desde el tramites
    Then válido el copago de la clinica

    Examples: Tabla
      | numeroUsuario | contrasena | nomClinica           |
      ##@externaldata@./src/test/resources/datadriven/serviciosDeSalud/Buscador_clinicas_data.xlsx@BuscadordeClinicasdesdeTramites@1

