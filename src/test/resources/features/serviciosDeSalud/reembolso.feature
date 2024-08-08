#Author: Daniel Amaya Marín

@ModuloServiciosDeSalud
Feature: Servicios de Salud - Reembolso

  @reembolsoSaludSinBeneficiarioDesdeMenuTramites @seguimientoReembolsoSinBeneficiariosDesdeTramite @regressionTest
  Scenario Outline: Usuario realiza una solicitud de reembolso con cobertura medicinas sin beneficiarios desde menu Tramites
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When registra los datos del reembolso de salud sin beneficiario con tipo de cobertura desde tramites
      | productoContratante   | lugarAtencion   | tipoCobertura   |
      | <productoContratante> | <lugarAtencion> | <tipoCobertura> |
    And adjuntamos los documentos y comprobantes del reembolso con tipo de cobertura "<tipoCobertura>"
    Then válido seguimiento de reembolso de salud desde tramites

    Examples: Tabla
      | numeroUsuario | contrasena | productoContratante                         | lugarAtencion | tipoCobertura |
      | 76243722      | Rimac2020  | AMC COLECTIVA FOLA - Citibank del peru s.a. | Lima          | Hospitalario  |


  @reembolsoSaludSinBeneficiarioaDesdeMenuInicio @seguimientoReembolsoDesdeInicio @regressionTest
  Scenario Outline: Usuario realiza una solicitud de reembolso sin beneficiarios desde menu Inicio
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When registra los datos del reembolso de salud sin beneficiario con tipo de cobertura desde el home
      | productoContratante   | lugarAtencion   | tipoCobertura   |
      | <productoContratante> | <lugarAtencion> | <tipoCobertura> |
    And adjuntamos los documentos y comprobantes del reembolso con tipo de cobertura "<tipoCobertura>"
    Then válido seguimiento de reembolso de salud desde tramites

    Examples: Tabla
      | numeroUsuario | contrasena | productoContratante                         | lugarAtencion | tipoCobertura |
      | 76243722      | Rimac2020  | AMC COLECTIVA FOLA - Citibank Del Peru S.a. | Lima          | Hospitalario  |

#
#  @reembolsoSaludConBeneficiariosDesdeMenuTramites @seguimientoReembolsoConBeneficiariosDesdeTramite
#  Scenario Outline: Realizar solicitud de reembolso con cobertura medicinas con beneficiarios desde Tramites
#    Given que "Daniel" inicia sesión correctamente
#      | numeroUsuario   | contrasena   |
#      | <numeroUsuario> | <contrasena> |
#    When registra los datos del reembolso de salud con beneficiario con tipo de cobertura desde tramites
#      | productoContratante   | paciente   | lugarAtencion   | tipoCobertura   |
#      | <productoContratante> | <paciente> | <lugarAtencion> | <tipoCobertura> |
#    And adjuntamos los documentos y comprobantes del reembolso con tipo de cobertura "<tipoCobertura>"
#    Then válido seguimiento de reembolso de salud desde tramites
#
#    Examples: Tabla
#      | numeroUsuario | contrasena | productoContratante                | paciente                                 | lugarAtencion | tipoCobertura |
#      | 10392464      | Rimac2020  | PLANES MEDICOS EPS - Medifarma s a | Madueño Armacanque Herzop Myki - Titular | Lima          | Medicinas     |
#
#  @reembolsoOdontologicoDesdeMenuTramites @seguimientoReembolsoOdontologico @ModuloServiciosDeSalud_4_16
#  Scenario Outline: Realizar solicitud de reembolso cliente con cobertura odontologica con beneficiarios desde menu Tramites
#    Given realiza el login con credenciales
#      | tipoID   | id   | password   |
#      | <tipoID> | <id> | <password> |
#    When se ingresa a Reembolso de Salud desde Tramites y se inicia el tramite
#    And se registra los datos del reembolso con beneficiario con tipo de cobertura y tratamiento
#      | productoContratante   | paciente   | lugarAtencion   | tipoCobertura   | tipoTratamiento   |
#      | <productoContratante> | <paciente> | <lugarAtencion> | <tipoCobertura> | <tipoTratamiento> |
#    And registra sus datos de contacto
#    And adjuntamos los documentos y comprobantes del reembolso con tipo de cobertura "<tipoCobertura>"
#    Then debe aparecer el mensaje: "Solicitud de reembolso recibida"
#    And se ingresa al Seguimiento de Reembolso de Salud desde Tramites
#    And debe aparecer el monto del reembolso solicitado
#
#    Examples:
#    ###DATOS###@ServiciosSalud|1@reembolsoOdontologicoDesdeMenuT
#      | 0 | tipoID | id       | password  | productoContratante                | paciente                                 | lugarAtencion | tipoCobertura | tipoTratamiento |
#      | 1 | DNI    | 10392464 | Rimac2020 | PLANES MEDICOS EPS - Medifarma s a | Madueño Armacanque Herzop Myki - Titular | Lima          | Odontología   | Ortodoncia      |
#
#
#  @reembolsoSaludSinBeneficiariosDesdeSeguros
#  Scenario Outline: Realizar solicitud de reembolso sin beneficiarios desde detalle de seguro salud
#    Given que "Daniel" inicia sesión correctamente
#      | numeroUsuario   | contrasena   |
#      | <numeroUsuario> | <contrasena> |
#    When registra los datos del reembolso de salud sin beneficiario con tipo de cobertura desde seguros
#      | productoContratante   | lugarAtencion   | tipoCobertura   |
#      | <productoContratante> | <lugarAtencion> | <tipoCobertura> |
#    And adjuntamos los documentos y comprobantes del reembolso con tipo de cobertura "<tipoCobertura>"
#    Then válido seguimiento de reembolso de salud desde tramites
#
#    Examples: Tabla
#      | numeroUsuario | contrasena | seguro             | productoContratante                         | lugarAtencion | tipoCobertura |
#      | 76243722      | Rimac2020  | Amc Colectiva Fola | AMC COLECTIVA FOLA - Citibank del peru s.a. | Lima          | Hospitalario  |
