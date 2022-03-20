# new feature
# Tags: optional

Feature: Registro para nuevos usuarios
  Como cliente del banco ParaBank
  quiero poder registrarme en su pagina web
  para utilizar los distintos servicios que ofrecen en linea

  Background: Usuario dentro de la pagina de registro
    Given que el cliente se encuentra en la pagina de registro de ParaBank

  Scenario: Registro exitoso de nuevo usuario
    When ingresa su informacion en todos los campos obligatorios y confirma la accion
    Then la pagina le muestra al usuario mensaje de bienvenida con su username y la confirmacion de su registro

  Scenario: Registro fallido de nuevo usuario cuando la contrasena y su campo de confirmacion no coinciden
    When al ingresar su informacion en los campos obligatorios se equivoca confirmando la contrasena y confirma la accion
    Then el usuario recibe un mensaje de error que dice "Passwords did not match."