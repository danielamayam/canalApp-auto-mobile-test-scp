#Author: Daniel Amaya Marín

@ModuloCrossellRenovacion_1 @Regresion
Feature: Venta SOAT

  @CompraSOATDigital @TestCaseKey:TDARA-T193
  Scenario Outline: Usuario compra un plan SOAT digital
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When navega y diligencia el formulario de registro tu soat en 2 minutos "<placa>"
      | numtarjeta   | cvv   | fecha   |
      | <numtarjeta> | <cvv> | <fecha> |
    Then válido la compra del plan exitosamente "¡Listo! Estamos por enviar tu SOAT"

    Examples: Tabla
      | numeroUsuario | contrasena | placa  | numtarjeta       | cvv | fecha |
    ##@externaldata@/Users/chm3572/Documents/datadriven/crossellRenovacion/Venta_soat_data.xlsx@CompraSOATDigital@1

