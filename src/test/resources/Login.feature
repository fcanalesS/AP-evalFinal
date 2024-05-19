Feature: Login de Usuario

  Scenario: Ingreso exitoso con credenciales correctas
    Given Un usuario va a la página de login
    When El usuario ingresa el nombre de usuario "user1" y la contraseña "pass1"
    Then El usuario debería poder acceder exitosamente

  Scenario: Ingreso fallido con contraseña incorrecta
    Given Un usuario va a la página de login
    When El usuario ingresa el nombre de usuario "user1" y la contraseña "incorrecta"
    Then El usuario no debería poder acceder
  