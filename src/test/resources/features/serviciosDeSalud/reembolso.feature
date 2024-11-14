#Author: Daniel Amaya Marín

@ModuloServiciosDeSalud_7 @Reembolso
Feature: Servicios de Salud - Reembolso

  @reembolsoSaludSinBeneficiarioDesdeMenuTramites @seguimientoReembolsoSinBeneficiariosDesdeTramite @TestCaseKey:TDARA-T437
  Scenario Outline: Usuario realiza una solicitud de reembolso con cobertura medicinas sin beneficiarios desde menu Tramites
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When registra los datos del reembolso de salud sin beneficiario con tipo de cobertura desde tramites
      | productoContratante   | lugarAtencion   | tipoCobertura   |
      | <productoContratante> | <lugarAtencion> | <tipoCobertura> |
    And adjuntamos los documentos y comprobantes del reembolso con tipo de cobertura
    Then válido seguimiento de reembolso

    Examples: Tabla
      | numeroUsuario | contrasena | productoContratante                         | lugarAtencion | tipoCobertura |
      | 76243722      | Rimac2020  | AMC COLECTIVA FOLA - Citibank Del Peru S.a. | Lima          | Hospitalario  |


  @reembolsoSaludSinBeneficiarioaDesdeMenuInicio @seguimientoReembolsoDesdeInicio @TestCaseKey:TDARA-T439
  Scenario Outline: Usuario realiza una solicitud de reembolso sin beneficiarios desde menu Inicio
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When registra los datos del reembolso de salud sin beneficiario con tipo de cobertura desde el home
      | productoContratante   | lugarAtencion   | tipoCobertura   |
      | <productoContratante> | <lugarAtencion> | <tipoCobertura> |
    And adjuntamos los documentos y comprobantes del reembolso con tipo de cobertura
    Then válido seguimiento de reembolso

    Examples: Tabla
      | numeroUsuario | contrasena | productoContratante                         | lugarAtencion | tipoCobertura |
      | 76243722      | Rimac2020  | AMC COLECTIVA FOLA - Citibank Del Peru S.a. | Lima          | Hospitalario  |


  @reembolsoSaludConBeneficiariosDesdeMenuTramites @seguimientoReembolsoConBeneficiariosDesdeTramite @TestCaseKey:TDARA-T441
  Scenario Outline: Usuario realiza una solicitud de reembolso con cobertura medicinas con beneficiarios desde Tramites
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When registra los datos del reembolso de salud con beneficiario con tipo de cobertura desde tramites
      | productoContratante   | paciente   | lugarAtencion   | tipoCobertura   |
      | <productoContratante> | <paciente> | <lugarAtencion> | <tipoCobertura> |
    And adjuntamos los documentos y comprobantes del reembolso con beneficiario
    Then válido seguimiento de reembolso

    Examples: Tabla
      | numeroUsuario | contrasena | productoContratante                | paciente                        | lugarAtencion | tipoCobertura |
      | 10392464      | Rimac2020  | PLANES MEDICOS EPS - Medifarma S A | Hui Humaliano Heliart - Cónyuge | Lima          | Medicinas     |

  @reembolsoOdontologicoDesdeMenuTramites @seguimientoReembolsoOdontologico @TestCaseKey:TDARA-T429
  Scenario Outline: Usuario realiza una solicitud de reembolso cliente con cobertura odontologica con beneficiarios desde menu Tramites
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When registra los datos del reembolso odontologico sin beneficiario con tipo de cobertura y tratamiento desde tramites
      | productoContratante   | paciente   | lugarAtencion   | tipoCobertura   | tipoTratamiento   |
      | <productoContratante> | <paciente> | <lugarAtencion> | <tipoCobertura> | <tipoTratamiento> |
    And adjuntamos los documentos y comprobantes del reembolso odontologico
    Then válido seguimiento de reembolso

    Examples:
      | numeroUsuario | contrasena | productoContratante                | paciente                                 | lugarAtencion | tipoCobertura | tipoTratamiento |
      | 10392464      | Rimac2020  | PLANES MEDICOS EPS - Medifarma S A | Madueño Armacanque Herzop Myki - Titular | Lima          | Odontología   | Ortodoncia      |


  @reembolsoSaludSinBeneficiariosDesdeSeguros @TestCaseKey:TDARA-T443
  Scenario Outline: Usuario realiza una solicitud de reembolso sin beneficiarios desde detalle de seguro salud
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When registra los datos del reembolso de salud sin beneficiario con tipo de cobertura desde seguros
      | productoContratante   | lugarAtencion   | tipoCobertura   |
      | <productoContratante> | <lugarAtencion> | <tipoCobertura> |
    And adjuntamos los documentos y comprobantes del reembolso con tipo de cobertura
    Then válido seguimiento de reembolso

    Examples: Tabla
      | numeroUsuario | contrasena | productoContratante                         | lugarAtencion | tipoCobertura |
      | 76243722      | Rimac2020  | AMC COLECTIVA FOLA - Citibank Del Peru S.a. | Lima          | Hospitalario  |
