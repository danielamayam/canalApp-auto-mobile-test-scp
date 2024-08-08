#Author: Daniel Amaya Marín

@ModuloPagos
Feature: pagos


  @SucripcionDesdePagos  # Necesita Data para la ejecución
  Scenario Outline: Usuario suscribe su tarjeta desde medios de pagos
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa los datos bancarios de su tarjeta
      | numtarjeta   | cvv   | fecha   | placa   | vigencia   |
      | <numtarjeta> | <cvv> | <fecha> | <placa> | <vigencia> |
    Then válido que se haya agregado la tarjeta a mis tarjetas "<numtarjeta>"

    Examples: Tabla
      | numeroUsuario | contrasena | numtarjeta       | cvv | fecha | placa   | vigencia   |
      | 70785760      | Rimac2020  | 4474104525811674 | 111 | 03/28 | JIR-24H | 29/07/2025 |

  @SucripcionDesdePerfil
  Scenario Outline: Usuario suscribe su tarjeta desde mi perfil
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa los datos bancarios de su tarjeta desde perfil
      | numtarjeta   | cvv   | fecha   |
      | <numtarjeta> | <cvv> | <fecha> |
    Then válido que se haya agregado la tarjeta a mis tarjetas "<numtarjeta>"

    Examples: Tabla
      | numeroUsuario | contrasena | numtarjeta       | cvv | fecha |
      | 07525151      | Rimac2020  | 4474104525811674 | 111 | 03/28 |

  @SucripcionDesdeAfiliacion  # Necesita Data para la ejecución
  Scenario Outline: Usuario suscribe su tarjeta desde afiliación
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a pagos del seguro vehicular "<placa>" "<vigencia>"
    And ingresa los datos de su tarjeta
      | numtarjeta   | cvv   | fecha   |
      | <numtarjeta> | <cvv> | <fecha> |
    Then válido el mensaje de afiliacion exitoso

    Examples: Tabla
      | numeroUsuario | contrasena | numtarjeta       | cvv | fecha | placa   | vigencia   |
      | 70785760      | Rimac2020  | 5443599980000447 | 111 | 03/28 | JIR-24H | 29/07/2025 |

  @SucripcionDesdeOpcionPagar  # Necesita Data para la ejecución
  Scenario Outline: Usuario suscribe su tarjeta desde la opción pagar
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
      | 70785760      | Rimac2020  | JIR-24H | 4551708161768059 | 03/28 | 111 | 29/07/2025 |





