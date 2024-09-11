#Author: Daniel Amaya Marín

@ModuloConsultasVida_8 @Regresion
Feature: Consultas Vida - Plan Vida Contigo

  @DescargaManualdeUsoPlanVidaContigo
  Scenario Outline: Usuario descarga el manual de uso de su poliza desde poliza del producto vida contigo
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When descarga el manual desde el detalle del seguro plan vida contigo desde el home "<vigencia>"
    Then válido que se haya descargado el manual correctamente

    Examples: Tabla
      | numeroUsuario | contrasena | vigencia   |
    ##@externaldata@./src/test/resources/datadriven/consultasVida/Plan_vida_data.xlsx@Scenario1@1
   |41213620   |Rimac2020   |15/07/2022|



  @ConsultarDeudasSaldoVidaContigo
  Scenario Outline: Usuario visualiza la deuda y los saldos de la póliza del producto Vida contigo.
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When selecciona pagos del seguros plan vida contigo desde el home "<vigencia>"
    Then válido la deuda y los saldos de la póliza.

    Examples: Tabla
      | numeroUsuario | contrasena | vigencia   |
    ##@externaldata@./src/test/resources/datadriven/consultasVida/Plan_vida_data.xlsx@Scenario2@1
   |41213620   |Rimac2020   |15/07/2022|



  @ConsultarCoberturasPolizaVidaContigo
  Scenario Outline: Usuario consulta la cobertura de la póliza del producto Vida contigo.
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When selecciona cobertura del seguro plan vida contigo ingresando desde el home "<vigencia>"
    Then válido que se puedan visualizar las coberturas principales y coberturas adicionales

    Examples: Tabla
      | numeroUsuario | contrasena | vigencia   |
    ##@externaldata@./src/test/resources/datadriven/consultasVida/Plan_vida_data.xlsx@Scenario3@1
   |41213620   |Rimac2020   |15/07/2022|



  @ConsultarInformacionPolizaVidaContigo
  Scenario Outline: Usuario consulta la información de la poliza del producto Vida contigo
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa al detalle del seguro plan vida contigo desde el home "<vigencia>"
    Then válido la información de la poliza "<numeroPoliza>" "<vigenciaDesde>" "<contratantePoliza>" "<intermediarioPoliza>"

    Examples: Tabla
      | numeroUsuario | contrasena | vigencia   | numeroPoliza | contratantePoliza         | intermediarioPoliza          |vigenciaDesde|
##@externaldata@./src/test/resources/datadriven/consultasVida/Plan_vida_data.xlsx@Scenario4@1
   |41213620   |Rimac2020   |15/07/2022   |1300002498   |Kyra Ruperto Emner Abanco   |Diego Alberto Fornoni Ibarra   |Desde 15/07/2022 - 12/12/2131|
