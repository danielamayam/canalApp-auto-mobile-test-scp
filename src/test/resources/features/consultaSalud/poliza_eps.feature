#Author: Daniel Amaya Marín

@ModuloConsultaSalud
Feature: Consulta Salud - Plan Medico EPS

  @ConsultaNumeroDePoliza @TestCaseKey:TDARA-T184
  Scenario Outline: Usuario consulta el numero de poliza
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa al detalle del seguro de Salud
    Then válido el numero de poliza
    Examples: Tabla
      | numeroUsuario | contrasena |
    ##@externaldata@/Users/chm3572/Documents/datadriven/ModuloConsultaSalud/Poliza_eps_data.xlsx@ConsultaNumeroDePoliza@1

  @ConsultaCoberturaDeLaPoliza @TestCaseKey:TDARA-T420
  Scenario Outline: Usuario consulta las coberturas de la poliza
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa la cobertura del seguro de Salud
    Then válido la cobertura del seguro
    Examples: Tabla
      | numeroUsuario | contrasena |
    ##@externaldata@/Users/chm3572/Documents/datadriven/ModuloConsultaSalud/Poliza_eps_data.xlsx@ConsultaNumeroDePoliza@1

#
#  @ConsultaDeudaYSaldo
#  Scenario Outline: Usuario consulta su deuda y saldo del seguro de salud
#    Given que "Daniel" inicia sesión correctamente
#      | numeroUsuario   | contrasena   |
#      | <numeroUsuario> | <contrasena> |
#    When selecciona pagos del seguro salud desde el home "<vigencia>"
#    Then válido la deuda del seguro
#
#    Examples: Tabla
#      | numeroUsuario | contrasena | vigencia   |
#      | 72670678      | Rimac2020  | 09/07/2025 |
#
#  @DescargaPolizaDigital
#  Scenario Outline: Usuario descarga póliza digital del seguro de salud
#    Given que "Daniel" inicia sesión correctamente
#      | numeroUsuario   | contrasena   |
#      | <numeroUsuario> | <contrasena> |
#    When descargar la póliza digital del seguro de salud "<placa>" "<vigencia>"
#    Then válido la descarga del pdf con la información
#
#    Examples: Tabla
#      | numeroUsuario | contrasena | vigencia   |
#      | 72670678      | Rimac2020  | 09/07/2025 |



