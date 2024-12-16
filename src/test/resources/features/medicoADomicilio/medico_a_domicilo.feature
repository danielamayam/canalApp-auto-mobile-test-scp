#Author: Daniel Amaya Marín

@MedicoADomicilio
Feature: Medicó a Domicilio

  @MedicoADomicilioUnaPolizaSinDependientes
  Scenario Outline: Usuario solicita asistencia de medico a domicilio desde el home con una poliza y sin dependientes
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When registra los datos del médico a domicilio desde el home
    Then válido la solicitud de médico a domicilio

    Examples: Tabla
      | numeroUsuario | contrasena |
      | 47937437      | Rimac2020  |

  @MedicoADomicilioUnaPolizaVariosDependientes
  Scenario Outline: Usuario solicita asistencia de medico a domicilio desde el home con una poliza y varios dependientes
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When registra los datos del médico a domicilio desde el home con varios dependientes
    Then válido la solicitud de médico a domicilio

    Examples: Tabla
      | numeroUsuario | contrasena |
      | 41247452      | Rimac2020  |

#  @MedicoADomicilioVariasPolizasSinDependientesDesdeSeguros
#  Scenario Outline: Usuario solicita asistencia de medico a domicilio desde seguros con varias polizas y sin dependientes
#    Given que "Daniel" inicia sesión correctamente
#      | numeroUsuario   | contrasena   |
#      | <numeroUsuario> | <contrasena> |
#    When registra los datos del médico a domicilio desde seguros sin dependientes
#    Then válido la solicitud de médico a domicilio
#
#    Examples: Tabla
#      | numeroUsuario | contrasena |
#      | 06136753      | Rimac2020  |


  @MedicoADomicilioVariasPolizasVariosDependientesDesdeTramites
  Scenario Outline: Usuario solicita asistencia de medico a domicilio desde tramites con varias polizas y varios dependientes
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When registra los datos del médico a domicilio desde tramites con varios dependientes
    Then válido la solicitud de médico a domicilio

    Examples: Tabla
      | numeroUsuario | contrasena |
      | 09873111      | Rimac2020  |


  @MedicoADomicilioCambioDeDireccion
  Scenario Outline: Usuario solicita asistencia de medico a domicilio desde tramites cambiando de dirección
    Given que "Daniel" inicia sesión correctamente
      | numeroUsuario   | contrasena   |
      | <numeroUsuario> | <contrasena> |
    When registra los datos del médico a domicilio desde tramites cambiando de dirección
    Then válido la solicitud de médico a domicilio

    Examples: Tabla
      | numeroUsuario | contrasena |
      | 41188287      | Rimac2020  |

