#Author: Daniel Amaya Marín

@ModuloPagos_15 @PagoSuscripcion
Feature: pagos


  @SucripcionDesdePagos
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
      ##@externaldata@./src/test/resources/datadriven/Pagos/Pago_suscripcion_data.xlsx@SucripcionDesdePagos@1


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
    ##@externaldata@./src/test/resources/datadriven/Pagos/Pago_suscripcion_data.xlsx@SucripcionDesdePerfil@1


  @SucripcionDesdeAfiliacion
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
    ##@externaldata@./src/test/resources/datadriven/Pagos/Pago_suscripcion_data.xlsx@SucripcionDesdeAfiliacion@1


  @SucripcionDesdeOpcionPagar
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
    ##@externaldata@./src/test/resources/datadriven/Pagos/Pago_suscripcion_data.xlsx@SucripcionDesdeOpcionPagar@1


  @EliminarMedioDePago
  Scenario Outline: Usuario elimina un medio de pago
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a pagos del seguro vehicular "<placa>" "<vigencia>"
    And elimina el medio de pago "<numtarjeta>"
    #Then válido el mensaje de confirmación

    Examples: Tabla
      | numeroUsuario | contrasena | placa   | numtarjeta       | vigencia   |
      | 43220212      | Rimac2020  | ADB-666 | 4551708161768059 | 28/08/2025 |
