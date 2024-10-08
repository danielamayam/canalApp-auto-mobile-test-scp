#Author: Daniel Amaya Marín

@ModuloConsultasVehicularySoat_4 @Regresion
Feature: Consulta vehicular y soat - Poliza Vehicular


  @ConsultaNumeroDePolizaVehiSoat
  Scenario Outline: Usuario consulta el numero de la poliza - soat
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa al resumen del seguro soat "<placa>"
    Then válido el número de póliza soat "<numeroPoliza>"

    Examples: Tabla
      | numeroUsuario | contrasena | placa | numeroPoliza |
    ##@externaldata@./src/test/resources/datadriven/consultasVehicularYSOAT/Poliza_vehicular_data.xlsx@ConsultaNumeroDePolizaVehiSoat@1



  @ConsultarDeudasSaldosdePoliza
  Scenario Outline: Usuario consulta deuda y saldo de la poliza - vehicular
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa el historial del seguro vehicular "<placa>" "<vigencia>"
    Then válido la cuota pagada en el historial

    Examples: Tabla
      | numeroUsuario | contrasena | placa | vigencia |
    ##@externaldata@./src/test/resources/datadriven/consultasVehicularYSOAT/Poliza_vehicular_data.xlsx@ConsultarDeudasSaldosdePoliza@1



  @DescargaPolizaVehicularDigital
  Scenario Outline: Usuario descarga póliza digital del seguro vehicular
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When descargar la póliza digital del seguro vehicular "<placa>" "<vigencia>"
    Then válido la descarga del pdf con la información

    Examples: Tabla
      | numeroUsuario | contrasena | placa | vigencia |
    ##@externaldata@./src/test/resources/datadriven/consultasVehicularYSOAT/Poliza_vehicular_data.xlsx@DescargaPolizaVehicularDigital@1



  @ConsultaCoberturas
  Scenario Outline: Usuario consulta la cobertura del seguro vehicular
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When navega hasta la cobertura del seguro "<placa>" "<vigencia>"
    Then válido la cobertura del seguro

    Examples: Tabla
      | numeroUsuario | contrasena | placa | vigencia |
      ##@externaldata@./src/test/resources/datadriven/consultasVehicularYSOAT/Poliza_vehicular_data.xlsx@ConsultaCoberturas@1

