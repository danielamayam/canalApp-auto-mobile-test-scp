#Author: Daniel Amaya Marín

@ModuloServiciosDeSalud @regressionTest
Feature: Servicios de Salud - Buscador de clinicas


  @BuscadordeClinicasdesdeHome @ScenarioWithoutData
  Scenario Outline: Usuario busca una clinica desde el home
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When se filtra la clinica "<nomClinica>" desde el home
    Then válido el copago de la clinica

    Examples: Tabla
      | numeroUsuario | contrasena | nomClinica           |
      | 40660901      | Rimac2020  | Clinica Javier Prado |

  @BuscadordeClinicasdesdeTramites @ScenarioWithoutData
  Scenario Outline: Usuario busca una clinica desde menu tramites
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When se filtra la clinica "<nomClinica>" desde el tramites
    Then válido el copago de la clinica

    Examples: Tabla
      | numeroUsuario | contrasena | nomClinica           |
      | 40660901      | Rimac2020  | Clinica Javier Prado |
