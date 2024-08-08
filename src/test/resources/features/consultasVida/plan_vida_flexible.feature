#Author: Daniel Amaya Marín

@ModuloConsultasVida
Feature: Consultas Vida - Plan Vida Flexible

  @DescargaEstadoCuentaPlanVidaFlexible @regressionTest
  Scenario Outline: Usuario descarga el estado de cuenta del plan vida flexible
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When descargan las características de mi seguro de vida flexible "<month>" "<year>" "<vigencia>"
    Then válido que se haya descargado correctamente

    Examples: Tabla
      | numeroUsuario | contrasena | month | year | vigencia   |
      | 44853375      | Rimac2020  | Mayo  | 2022 | 04/01/2046 |

  @ConsultarCoberturasPolizaVidaFlexible @ScenarioWithoutData @regressionTest
  Scenario Outline: Usuario consulta la cobertura de la póliza vida flexible
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When selecciona cobertura del seguro plan vida flexible "<vigencia>"
    Then válido que se puedan visualizar las coberturas principales y coberturas adicionales del plan vida flexible

    Examples: Tabla
      | numeroUsuario | contrasena | vigencia   |
      | 44853375      | Rimac2020  | 04/01/2046 |

  @ConsultarDeudasSaldoVidaFlexible @ScenarioWithoutData @regressionTest
  Scenario Outline: Usuario consultar Deudas y Saldos de la Poliza del Producto Flexivida
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When selecciona pagos del seguros plan vida flexible "<vigencia>"
     Then válido la deuda y los saldos de la póliza.

    Examples: Tabla
      | numeroUsuario | contrasena | vigencia   |
      | 44853375      | Rimac2020  | 04/01/2046 |

  @ConsultarInformacionPolizaVidaFlexible @ScenarioWithoutData @regressionTest
  Scenario Outline: Usuario consulta información de la póliza vida flexible
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa al detalle del seguro plan vida flexible "<vigencia>"
    Then válido la información de la poliza flexible "<numeroPoliza>" "<vigenciaDesde>" "<contratantePoliza>"

    Examples: Tabla
      | numeroUsuario | contrasena | vigencia   | numeroPoliza | contratantePoliza        | vigenciaDesde       |
      | 44853375      | Rimac2020  | 04/01/2046 | 21062337     | Yinsem Zeno Mayque Unico | 04/01/2021 - 04/01/2046 |

