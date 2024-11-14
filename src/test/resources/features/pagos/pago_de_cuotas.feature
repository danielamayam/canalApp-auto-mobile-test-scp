#Author: Daniel Amaya Marín

@ModuloPagos_15 @PagoDeCuotas
Feature: Pagos


  @PagoSinTarjetaAsociada @TestCaseKey:TDARA-T196
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
      | numeroUsuario | contrasena | placa | numtarjeta | fecha | cvv | vigencia |
    ##@externaldata@./src/test/resources/datadriven/Pagos/Pago_de_cuotas_data.xlsx@PagoSinTarjetaAsociada@1


  @PagoAfiliadoDebitoAuto @TestCaseKey:TDARA-T197
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
      | numeroUsuario | contrasena | placa | numtarjeta | fecha | cvv | vigencia |
    ##@externaldata@./src/test/resources/datadriven/Pagos/Pago_de_cuotas_data.xlsx@PagoAfiliadoDebitoAuto@1


  @PagoConValidacionHistorial @TestCaseKey:TDARA-T198
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
      | numeroUsuario | contrasena | placa | numtarjeta | fecha | cvv | vigencia |
    ##@externaldata@./src/test/resources/datadriven/Pagos/Pago_de_cuotas_data.xlsx@PagoConValidacionHistorial@1


  @PagoConTarjetaAsociada @TestCaseKey:TDARA-T199
  Scenario Outline: Usuario realiza el pago del seguro vehicular con tarjeta asociada
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a pagos del seguro vehicular "<placa>" "<vigencia>"
    And realiza el pago seleccionando la tarjeta asociada "<numtarjeta>"
    Then válido el mensaje de confirmación

    Examples: Tabla
      | numeroUsuario | contrasena | placa | numtarjeta | vigencia |
     ##@externaldata@./src/test/resources/datadriven/Pagos/Pago_de_cuotas_data.xlsx@PagoConTarjetaAsociada@1


  @PagoAsociandoTarjeta @TestCaseKey:TDARA-T200
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
      | numeroUsuario | contrasena | placa | numtarjeta | fecha | cvv | vigencia |
         ##@externaldata@./src/test/resources/datadriven/Pagos/Pago_de_cuotas_data.xlsx@PagoAsociandoTarjeta@1


  @PagoPolizaSoat @TestCaseKey:TDARA-T201
  Scenario Outline: Usuario valida pago de poliza SOAT
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a pagos del seguro soat "<placa>" "<vigencia>"
    Then válido el detalle del pago anual

    Examples: Tabla
      | numeroUsuario | contrasena | placa | vigencia |
    ##@externaldata@./src/test/resources/datadriven/Pagos/Pago_de_cuotas_data.xlsx@PagoPolizaSoat@1


  @PagoInfoNoDisponible @TestCaseKey:TDARA-T202
  Scenario Outline: Usuario valida la pantalla de pago cuando el pagador es diferente al asegurado
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a pagos del seguro planes medicos EPS
    Then debe mostrar mensaje "<mensaje>"

    Examples: Tabla
      | numeroUsuario | contrasena | mensaje |
##@externaldata@./src/test/resources/datadriven/Pagos/Pago_de_cuotas_data.xlsx@PagoInfoNoDisponible@1
