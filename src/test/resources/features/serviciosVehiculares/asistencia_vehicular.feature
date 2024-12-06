#Author: Daniel Amaya Marín

@ModuloServiciosVehiculares
Feature: Servicios Vehiculares - Asistencia Vehicular

  @AsistenciaVehicularRepuesto @SeguimientoAsistenciaVehicularRepuesto @TestCaseKey:TDARA-T212 @TestCaseKey:TDARA-T444
  Scenario Outline: Usuario solicita auxilio mecanico - repuesto
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a asistencias vehiculares desde tramites e inicia el tramite
    And selecciona los datos de asistencia
    Then válido el seguimiento de la asistencia vehicular de la "<placa>"

    Examples: Tabla
      | numeroUsuario | contrasena | placa   |
    ##@externaldata@/Users/chm3572/Documents/datadriven/serviciosVehiculares/Asistencia_vehicular.xlsx@AsistenciaVehicularRepuesto@1


  @AsistenciaVehicularGrua @SeguimientodeGrua @TestCaseKey:TDARA-T213 @TestCaseKey:TDARA-T445
  Scenario Outline: Usuario realizar una solicitud de Grua
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a asistencias vehiculares desde tramites e inicia el tramite
    And selecciona los datos de la asistencia grua
    Then válido el seguimiento de la asistencia vehicular grua de la "<placa>"

    Examples: Tabla
      | numeroUsuario | contrasena | placa   |
    ##@externaldata@/Users/chm3572/Documents/datadriven/serviciosVehiculares/Asistencia_vehicular.xlsx@AsistenciaVehicularGrua@1


  @AsistenciaVehicularProblema @SeguimientoAsistenciaVehicularProblema @TestCaseKey:TDARA-T214 @TestCaseKey:TDARA-T446
  Scenario Outline: Usuario solicitar auxilio mecanico - problema
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a asistencias vehiculares desde tramites e inicia el tramite
    And selecciona los datos de la asistencia problema
    Then válido el seguimiento de la asistencia vehicular problema de la "<placa>"

    Examples: Tabla
      | numeroUsuario | contrasena | placa   |
    ##@externaldata@/Users/chm3572/Documents/datadriven/serviciosVehiculares/Asistencia_vehicular.xlsx@AsistenciaVehicularProblema@1


  @NecesitoAyudaAuxilioMecanico @TestCaseKey:TDARA-T215
  Scenario Outline: Usuario necesita ayuda para seleccionar la asistencia Vehicular - Auxilio Mecanico
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a asistencias vehiculares desde tramites e inicia el tramite
    And selecciona los datos de ayuda mecanico
    Then válido el seguimiento de ayuda mecanico de la "<placa>"

    Examples: Tabla
      | numeroUsuario | contrasena | placa   |
    ##@externaldata@/Users/chm3572/Documents/datadriven/serviciosVehiculares/Asistencia_vehicular.xlsx@NecesitoAyudaAuxilioMecanico@1


  @NecesitoAyudaGrua @TestCaseKey:TDARA-T447
  Scenario Outline: Usuario necesita ayuda para seleccionar la asistencia Vehicular - Grua
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a asistencias vehiculares desde tramites e inicia el tramite
    And selecciona los datos de la asistencia grua
    Then válido el mensaje de solicitud

    Examples: Tabla
      | numeroUsuario | contrasena |
    ##@externaldata@/Users/chm3572/Documents/datadriven/serviciosVehiculares/Asistencia_vehicular.xlsx@NecesitoAyudaGrua@1



