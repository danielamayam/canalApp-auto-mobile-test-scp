#Author: Daniel Amaya Marín

@ModuloServiciosVehiculares
Feature: Servicios Vehiculares - Asistencia Vehicular

  @AsistenciaVehicularRepuesto @ScenarioWithoutData @regressionTest
  Scenario Outline: Usuario solicita auxilio mecanico - repuesto
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a asistencias vehiculares desde tramites e inicia el tramite
    And selecciona los datos de asistencia
    Then válido el seguimiento de la asistencia vehicular de la "<placa>"

    Examples: Tabla
      | numeroUsuario | contrasena | placa   |
      | 01317724      | Rimac2020  | GIS-475 |

  @AsistenciaVehicularGrua @SeguimientodeGrua @ScenarioWithoutData @regressionTest
  Scenario Outline: Usuario realizar una solicitud de Grua
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a asistencias vehiculares desde tramites e inicia el tramite
    And selecciona los datos de la asistencia grua
    Then válido el seguimiento de la asistencia vehicular grua de la "<placa>"

    Examples: Tabla
      | numeroUsuario | contrasena | placa   |
      | 01317724      | Rimac2020  | GIS-475 |

  @AsistenciaVehicularProblema @SeguimientoAsistenciaVehicularProblema @ScenarioWithoutData @regressionTest
  Scenario Outline: Usuario solicitar auxilio mecanico - problema
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a asistencias vehiculares desde tramites e inicia el tramite
    And selecciona los datos de la asistencia problema
    Then válido el seguimiento de la asistencia vehicular problema de la "<placa>"

    Examples: Tabla
      | numeroUsuario | contrasena | placa   |
      | 01317724      | Rimac2020  | GIS-475 |


  @NecesitoAyudaAuxilioMecanico @ScenarioWithoutData @regressionTest
  Scenario Outline: Usuario necesita ayuda para seleccionar la asistencia Vehicular - Auxilio Mecanico
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a asistencias vehiculares desde tramites e inicia el tramite
    And selecciona los datos de ayuda mecanico
    Then válido el seguimiento de ayuda mecanico de la "<placa>"

    Examples: Tabla
      | numeroUsuario | contrasena | placa   |
      | 01317724      | Rimac2020  | GIS-475 |

  @NecesitoAyudaGrua @ScenarioWithoutData @regressionTest
  Scenario Outline: Usuario necesita ayuda para seleccionar la asistencia Vehicular - Grua
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a asistencias vehiculares desde tramites e inicia el tramite
    And selecciona los datos de la asistencia grua
    Then válido el mensaje de solicitud

    Examples: Tabla
      | numeroUsuario | contrasena |
      | 01317724      | Rimac2020  |
