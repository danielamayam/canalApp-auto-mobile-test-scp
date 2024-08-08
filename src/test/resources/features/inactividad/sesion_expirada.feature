#Author: Daniel Amaya Marín

@ModuloInactividad
Feature: Consultas Vida - Plan Vida Flexible

  @TiempoInactividadConsultasVida @TiempoInactividad
  Scenario Outline: Usuario espera 15 min de inactividad en el modulo de consultas vida
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa al detalle del seguro plan vida flexible "<vigencia>"
    And se mantiene inactivo por 15 minutos
    Then válido el mensaje de tiempo inactivo

    Examples: Tabla
      | numeroUsuario | contrasena | vigencia   |
      | 44853375      | Rimac2020  | 04/01/2046 |

  @TiempoInactividadPerfil @TiempoInactividad
  Scenario Outline: Usuario espera 15 min de inactividad en el modulo Perfil
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When navega hasta la informacion del perfil
    And se mantiene inactivo por 15 minutos
    Then válido el mensaje de tiempo inactivo

    Examples: Tabla
      | numeroUsuario | contrasena |
      | 44926877      | Rimac2020  |

  @TiempoInactividadConsultasSalud @TiempoInactividad
  Scenario Outline: Usuario espera 15 min de inactividad en el modulo de seguro Consulta Salud
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When navega al detalle del seguro planes medicos EPS
    And se mantiene inactivo por 15 minutos
    Then válido el mensaje de tiempo inactivo

    Examples: Tabla
      | numeroUsuario | contrasena |
      | 10318552      | Rimac2020  |

  @TiempoInactividadConsultaVehicularySoat @TiempoInactividad
  Scenario Outline: Usuario espera 15 min de inactividad en el modulo de Consulta Vehicular SOAT
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa al detalle de la "<placa>" "<vigencia>" del seguro vehicular
    And se mantiene inactivo por 15 minutos
    Then válido el mensaje de tiempo inactivo

    Examples: Tabla
      | numeroUsuario | contrasena | placa      | vigencia   |
      | 10020310      | Rimac2020  | En trámite | 06/12/2024 |


  @TiempoInactividadOnboarding @TiempoInactividad
  Scenario Outline: Usuario espera 15 min de inactividad  despues de realizar exitozamente el inicio de sesión
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    And se mantiene inactivo por 15 minutos
    Then válido el mensaje de tiempo inactivo

    Examples: Tabla
      | numeroUsuario | contrasena |
      | 40861606      | Rimac2021  |


  @TiempoInactividadPagos @TiempoInactividad
  Scenario Outline: Usuario espera 15 min de inactividad en el modulo de pagos
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa al detalle del Seguro SOAT desde Seguros "<placa>" "<vigencia>"
    And se mantiene inactivo por 15 minutos
    Then válido el mensaje de tiempo inactivo

    Examples: Tabla
      | numeroUsuario | contrasena | placa   | vigencia   |
      | 44926877      | Rimac2020  | AXV-266 | 08/03/2025 |


  @TiempoInactividadServiciodeSalud @TiempoInactividad
  Scenario Outline: Usuario espera 15 min de inactividad en el modulo Servicio de salud
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When registra los datos del reembolso de salud sin beneficiario con tipo de cobertura desde tramites
      | productoContratante   | lugarAtencion   | tipoCobertura   |
      | <productoContratante> | <lugarAtencion> | <tipoCobertura> |
    And adjuntamos los documentos y comprobantes del reembolso con tipo de cobertura "<tipoCobertura>"
    Then válido seguimiento de reembolso de salud desde tramites
    And se mantiene inactivo por 15 minutos
    And válido el mensaje de tiempo inactivo

    Examples: Tabla
      | numeroUsuario | contrasena | productoContratante                         | lugarAtencion | tipoCobertura |
      | 76243722      | Rimac2020  | AMC COLECTIVA FOLA - Citibank Del Peru S.a. | Lima          | Hospitalario  |


  @TiempoInactividadServiciosSOAT @TiempoInactividad
  Scenario Outline: Usuario espera 15 min de inactividad en el modulo Servicios de SOAT
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When ingresa a la opcion Descuento en asistencias desde tramites
    And se mantiene inactivo por 15 minutos
    Then válido el mensaje de tiempo inactivo

    Examples: Tabla
      | numeroUsuario | contrasena |
      | 40861606      | Rimac2021  |


#  @TiempoInactividadServicioVehicular @TiempoInactividad
#  Scenario Outline: Esperar 15 min de inactividad en Asistencias Vehiculares
#    Given que "Daniel" inicia sesión correctamente
#      | numeroUsuario   | contrasena   |
#      | <numeroUsuario> | <contrasena> |
#    When se ingresa a Asistencias vehiculares desde Tramites y se inicia el tramite con la "<placa>" del vehiculo
#    And selecciono la asistencia "Auxilio mecánico" y el "<problema>" del vehiculo
#    And se mantiene inactivo por 15 minutos
#    Then válido el mensaje de tiempo inactivo
#
#    Examples: Tabla
#      | numeroUsuario | contrasena | placa | problema |
#
#
#  @TiempoInactividadServiciosVida
#  Scenario Outline: Esperar 15 min de inactividad en el modulo de Consultas Vida desde Home
#    Given que "Daniel" inicia sesión correctamente
#      | numeroUsuario   | contrasena   |
#      | <numeroUsuario> | <contrasena> |
#    When deseo conocer el detalle del estado de cuenta del "<año>" y del "<mes>" ingresando desde Home
#    And se mantiene inactivo por 15 minutos
#    Then válido el mensaje de tiempo inactivo
#
#    Examples: Tabla
#      | numeroUsuario | contrasena | mes  | a??o |
#      | 44926877      | Rimac2020  | Mayo | 2022 |
#
#  @TiempoInactividadTramiteYSiniestro
#  Scenario Outline: Esperar 15 min de inactividad en el modulo Tramite y Siniestro
#    Given que "Daniel" inicia sesión correctamente
#      | numeroUsuario   | contrasena   |
#      | <numeroUsuario> | <contrasena> |
#    When ingreso a menu tramites
#    And se mantiene inactivo por 15 minutos
#    Then válido el mensaje de tiempo inactivo
#
#    Examples: Tabla
#      | numeroUsuario | contrasena |
#      | 44926877      | Rimac2020  |
#
#  @TiempoInactividadVentaNueva
#  Scenario Outline: Esperar 15 min de inactividad en el modulo Venta nueva
#    Given que "Daniel" inicia sesión correctamente
#      | numeroUsuario   | contrasena   |
#      | <numeroUsuario> | <contrasena> |
#    When ingreso mis datos bancarios "<numtarjeta>","<cvv>" y "<fecha>" para generar la compra del producto SOAT para el vehiculo "<placa>"
#    And se mantiene inactivo por 15 minutos
#    Then válido el mensaje de tiempo inactivo
#
#    Examples: Tabla
#      | numeroUsuario | contrasena | placa  | numtarjeta       | fecha | cvv |
#      | 44926877      | Rimac2020  | ASQ191 | 4474118355632240 | 03/28 | 111 |
#
#
#  @TiempoInactividadConsultasVida
#  Scenario Outline: Esperar 15 min de inactividad en el modulo de Consultas Vida
#    Given que "Daniel" inicia sesión correctamente
#      | numeroUsuario   | contrasena   |
#      | <numeroUsuario> | <contrasena> |
#    When deseo conocer el detalle del estado de cuenta del "<año>" y del "<mes>"
#    And se mantiene inactivo por 15 minutos
#    Then válido el mensaje de tiempo inactivo
#
#    Examples: Tabla
#      | numeroUsuario | contrasena | mes  | año  |
##      | 44853375      | Rimac2020  | Mayo | 2022 |
#
