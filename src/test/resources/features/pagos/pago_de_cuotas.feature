#Author: Daniel Amaya Marín

@ModuloPagos
Feature: Pagos


  @PagoSinTarjetaAsociada  # Necesita Data para la ejecución
  Scenario Outline: Usuario paga su seguro vehicular exitosamente sin tarjeta asociada
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a pagos del seguro vehicular "<placa>" "<vigencia>"
    And realiza el pago suscribiendo mi tarjeta
      | numtarjeta   | cvv   | fecha   |
      | <numtarjeta> | <cvv> | <fecha> |
    Then válido el mensaje de confirmación

    Examples: Tabla
      | numeroUsuario | contrasena | placa   | numtarjeta       | fecha | cvv | vigencia   |
      | 70785760      | Rimac2020  | En Trámite | 4551708161768059 | 03/28 | 111 | 28/07/2025 |

  @PagoAfiliadoDebitoAuto  # Necesita Data para la ejecución
  Scenario Outline: Usuario realiza el pago estando afiliado a debito automatico
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a pagos del seguro vehicular "<placa>" "<vigencia>"
    And realiza el pago suscribiendo mi tarjeta con debito automatico
      | numtarjeta   | fecha   | cvv   |
      | <numtarjeta> | <fecha> | <cvv> |
    Then debe mostrar el mensaje Hemos recibido tu pago!

    Examples: Tabla
      | numeroUsuario | contrasena | placa   | numtarjeta       | fecha | cvv | vigencia   |
      | 70785760      | Rimac2020  | En Trámite | 4474118355632240 | 03/28 | 111 | 28/07/2025 |

  @PagoConValidacionHistorial  # Necesita Data para la ejecución
  Scenario Outline: Usuario realiza el pago del seguro vehicular validando el historial de pago
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a pagos del seguro vehicular "<placa>" "<vigencia>"
    And realiza el pago suscribiendo mi tarjeta
      | numtarjeta   | cvv   | fecha   |
      | <numtarjeta> | <cvv> | <fecha> |
    And navega hasta el historial de pago
    Then válido la cuota pagada en el historial de pago

    Examples: Tabla
      | numeroUsuario | contrasena | placa   | numtarjeta       | fecha | cvv | vigencia   |
      | 70785760      | Rimac2020  | En Trámite | 4474118355632240 | 03/28 | 111 | 28/07/2025 |

  @PagoConTarjetaAsociada  # Necesita Data para la ejecución
  Scenario Outline: Usuario realiza el pago del seguro vehicular con tarjeta asociada
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a pagos del seguro vehicular "<placa>" "<vigencia>"
    And realiza el pago seleccionando la tarjeta asociada "<numtarjeta>"
    Then válido el mensaje de confirmación

    Examples: Tabla
      | numeroUsuario | contrasena | placa   | numtarjeta       | vigencia   |
      | 70785760      | Rimac2020  | DR4-9SK | 4551708161768059 | 29/07/2025 |

  @PagoAsociandoTarjeta  # Necesita Data para la ejecución
  Scenario Outline: Usuario realiza pago exitoso asociando tarjeta
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a pagos del seguro vehicular "<placa>" "<vigencia>"
    And realiza el pago suscribiendo mi tarjeta
      | numtarjeta   | cvv   | fecha   |
      | <numtarjeta> | <cvv> | <fecha> |
    Then válido el mensaje de confirmación

    Examples: Tabla
      | numeroUsuario | contrasena | placa   | numtarjeta       | fecha | cvv | vigencia   |
      | 70785760      | Rimac2020  | DR4-9SK | 4551708161768059 | 03/28 | 111 | 29/07/2025 |

  @PagoPolizaSoat
  Scenario Outline: Usuario valida pago de poliza SOAT
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a pagos del seguro soat "<placa>" "<vigencia>"
    Then válido el detalle del pago anual

    Examples: Tabla
      | numeroUsuario | contrasena | placa   | vigencia   |
      | 42321915      | Rimac2020  | AYI-411 | 09-04-2026 |

  @PagoInfoNoDisponible
  Scenario Outline: Usuario valida la pantalla de pago cuando el pagador es diferente al asegurado
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a pagos del seguro planes medicos EPS
    Then debe mostrar mensaje "<mensaje>"

    Examples: Tabla
      | numeroUsuario | contrasena | mensaje                                                                                                                        |
      | 19098669      | Rimac2020  | El estado de cuenta está disponible para el contratante del seguro. Consulta con esa persona o empresa el estado de los pagos. |
