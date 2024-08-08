#Author: Daniel Amaya Marín

@ModuloCrossellRenovacion
Feature: Venta SOAT

  @CompraSOATDigital @regressionTest # Depende de la data no se ejecuto
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
      | 40861606      | Rimac2021  | ACV578 | 4551708161768059 | 111 | 03/28 |
