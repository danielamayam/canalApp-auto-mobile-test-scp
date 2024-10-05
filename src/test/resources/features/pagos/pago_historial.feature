#Author: Daniel Amaya Marín

@ModuloPagos_15
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
    ##@externaldata@./src/test/resources/datadriven/Pagos/Pago_historial_data.xlsx@CronogramaPagosVehicular@1


  @HistorialPagos
  Scenario Outline: Usuario visualiza el historial de pagos de su poliza vehicular
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa al historial del seguro vehicular "<placa>" "<vigencia>"
    Then válido el listado de pagos realizados

    Examples: Tabla
      | numeroUsuario | contrasena | placa   | vigencia   |
    ##@externaldata@./src/test/resources/datadriven/Pagos/Pago_historial_data.xlsx@HistorialPagos@1


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
  ##@externaldata@./src/test/resources/datadriven/Pagos/Pago_historial_data.xlsx@DescargaHistorialPagos@1


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
