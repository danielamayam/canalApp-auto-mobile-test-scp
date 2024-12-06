#Author: Daniel Amaya Marín

@ModuloConsultasVehicularySoat
Feature: Consulta vehicular y soat - Poliza Vehicular


  @ConsultaNumeroDePolizaVehiSoat @TestCaseKey:TDARA-T185 @Granja
  Scenario Outline: Usuario consulta el numero de la poliza - soat
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa al resumen del seguro soat "<placa>"
    Then válido el número de póliza soat "<numeroPoliza>"

    Examples: Tabla
      | numeroUsuario | contrasena | placa | numeroPoliza |
    ##@externaldata@/Users/chm3572/Documents/datadriven/consultasVehicularYSOAT/Poliza_vehicular_data.xlsx@ConsultaNumeroDePolizaVehiSoat@1


  @ConsultarDeudasSaldosdePoliza @TestCaseKey:TDARA-T186
  Scenario Outline: Usuario consulta deuda y saldo de la poliza - vehicular
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa el historial del seguro vehicular "<placa>" "<vigencia>"
    Then válido la cuota pagada en el historial

    Examples: Tabla
      | numeroUsuario | contrasena | placa | vigencia |
    ##@externaldata@/Users/chm3572/Documents/datadriven/consultasVehicularYSOAT/Poliza_vehicular_data.xlsx@ConsultarDeudasSaldosdePoliza@1


  @DescargaPolizaVehicularDigital @TestCaseKey:TDARA-T187 @Granja
  Scenario Outline: Usuario descarga póliza digital del seguro vehicular
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When descargar la póliza digital del seguro vehicular "<placa>" "<vigencia>"
    Then válido la descarga del pdf con la información

    Examples: Tabla
      | numeroUsuario | contrasena | placa | vigencia |
    ##@externaldata@/Users/chm3572/Documents/datadriven/consultasVehicularYSOAT/Poliza_vehicular_data.xlsx@DescargaPolizaVehicularDigital@1


  @ConsultaCoberturas @TestCaseKey:TDARA-T242 @Granja
  Scenario Outline: Usuario consulta la cobertura del seguro vehicular
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When navega hasta la cobertura del seguro "<placa>" "<vigencia>"
    Then válido la cobertura del seguro

    Examples: Tabla
      | numeroUsuario | contrasena | placa | vigencia |
      ##@externaldata@/Users/chm3572/Documents/datadriven/consultasVehicularYSOAT/Poliza_vehicular_data.xlsx@ConsultaCoberturas@1


#  @ConsultaKilometrosVehicular
#  Scenario Outline: Usuario consulta el consumo de kilometros del seguro vehicular
#    Given que "Daniel" inicia sesión correctamente
#      | numeroUsuario   | contrasena   |
#      | <numeroUsuario> | <contrasena> |
#    When navega hasta el consumo de kilometros del seguro vehicular "<placa>" "<vigencia>"
#    Then válido el consumo de kilometros del seguro vehicular
#
#    Examples: Tabla
#      | numeroUsuario | contrasena | placa | vigencia |
#      |41007984   |Rimac2023   |L0K-152   |01/09/2025|
