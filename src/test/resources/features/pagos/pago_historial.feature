#Author: Daniel Amaya Marín

@ModuloPagos
Feature: pagos

  @CronogramaPagosVehicular  # Necesita Data para la ejecución
  Scenario Outline: Usuario visualiza el cronograma de pagos de la póliza vehicular
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a las cuotas por pagar del Seguro vehicular desde seguros "<placa>" y "<vigencia>"
    Then válido el listado de las cuotas

    Examples: Tabla
      | numeroUsuario | contrasena | placa   | vigencia   |
      | 70785760      | Rimac2020  | JIR-24H | 29/07/2025 |

  @HistorialPagos
  Scenario Outline: Usuario visualiza el historial de pagos de su poliza vehicular
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa al historial del seguro vehicular "<placa>" "<vigencia>"
    Then válido el listado de pagos realizados

    Examples: Tabla
      | numeroUsuario | contrasena | placa   | vigencia   |
      | 02777945      | Rimac2020  | 15T-039 | 08/07/2025 |

  @DescargaHistorialPagos
  Scenario Outline: Usuario descarga el historial de pagos de su póliza vehicular
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa al historial del seguro vehicular "<placa>" "<vigencia>"
    And descargo el historial de pago
    Then válido la descarga del pdf con el historial de pagos

    Examples: Tabla
      | numeroUsuario | contrasena | placa   | vigencia   |
      | 07525151      | Rimac2020  | ACC-241 | 12/06/2025 |

#  @CronogramaPagosEPS @Pendiente #--------------------------------- ------------------------------
#  Scenario Outline: Usuario visualiza el cronograma de pagos del seguro de salud EPS, cuando el titular es igual al contratante
#    Given que "Daniel" inicia sesión correctamente
#      | numeroUsuario   | contrasena   |
#      | <numeroUsuario> | <contrasena> |
#    When ingresa a las cuotas por pagar del Seguro Planes Medicos EPS
#    Then válido el listado de las cuotas del Seguro Planes Medicos EPS
#
#    Examples: Tabla
#      | tipoDocumento | numeroUsuario | contrasena |
#      | DNI           | 43288728      | Rimac2023  |