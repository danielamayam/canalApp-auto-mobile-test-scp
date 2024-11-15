#Author: Daniel Amaya Marín

@ModuloConsultasVida_9 @Regresion
Feature: Consultas Vida - Plan Vida Contigo

  @DescargaManualdeUsoPlanVidaContigo @TestCaseKey:TDARA-T188
  Scenario Outline: Usuario descarga el manual de uso de su poliza desde poliza del producto vida contigo
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When descarga el manual desde el detalle del seguro plan vida contigo desde el home "<vigencia>"
    Then válido que se haya descargado el manual correctamente

    Examples: Tabla
      | numeroUsuario | contrasena | vigencia |
    ##@externaldata@/Users/chm3572/Documents/datadriven/consultasVida/Plan_vida_data.xlsx@Scenario1@1





  @ConsultarDeudasSaldoVidaContigo @TestCaseKey:TDARA-T243
  Scenario Outline: Usuario visualiza la deuda y los saldos de la póliza del producto Vida contigo.
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When selecciona pagos del seguros plan vida contigo desde el home "<vigencia>"
    Then válido la deuda y los saldos de la póliza.

    Examples: Tabla
      | numeroUsuario | contrasena | vigencia |
    ##@externaldata@/Users/chm3572/Documents/datadriven/consultasVida/Plan_vida_data.xlsx@Scenario2@1





  @ConsultarCoberturasPolizaVidaContigo @TestCaseKey:TDARA-T189
  Scenario Outline: Usuario consulta la cobertura de la póliza del producto Vida contigo.
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When selecciona cobertura del seguro plan vida contigo ingresando desde el home "<vigencia>"
    Then válido que se puedan visualizar las coberturas principales y coberturas adicionales

    Examples: Tabla
      | numeroUsuario | contrasena | vigencia |
    ##@externaldata@/Users/chm3572/Documents/datadriven/consultasVida/Plan_vida_data.xlsx@Scenario3@1





  @ConsultarInformacionPolizaVidaContigo @TestCaseKey:TDARA-T190
  Scenario Outline: Usuario consulta la información de la poliza del producto Vida contigo
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa al detalle del seguro plan vida contigo desde el home "<vigencia>"
    Then válido la información de la poliza "<numeroPoliza>" "<vigenciaDesde>" "<contratantePoliza>" "<intermediarioPoliza>"

    Examples: Tabla
      | numeroUsuario | contrasena | vigencia | numeroPoliza | contratantePoliza | intermediarioPoliza | vigenciaDesde |
##@externaldata@/Users/chm3572/Documents/datadriven/consultasVida/Plan_vida_data.xlsx@Scenario4@1


  @ConsultarInformacionDelBeneficiario @TestCaseKey:TDARA-T421
  Scenario Outline: Usuario consulta la información del beneficiario
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa al los beneficiarios del seguro plan vida contigo "<vigencia>"
    Then válido la información del beneficiario "<beneficiario>"

    Examples: Tabla
      | numeroUsuario | contrasena | vigencia   | beneficiario      |
      | 41213620      | Rimac2020  | 15/07/2022 | HEREDEROS LEGALES |
