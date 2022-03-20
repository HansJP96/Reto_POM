# new feature
# Tags: optional

Feature: Inicio de sesion para clientes
  Como cliente del banco ParaBank que ya se encuentra registrado en la pagina web
  quiero iniciar sesion en la pagina web del banco
  para poder utilizar los servicios que ofrecen

  Background: Usuario dentro del home de la pagina web con cuenta existente
    Given que el cliente se encuentra en el home de la pagina

  Scenario: Inicio de sesion exitoso
    When digita su username: "pablo99", su contrasena: "qwert" y confirma su accion
    Then el usuario observa un mensaje que dice "Welcome Pablo Colombia"

  Scenario: Inicio de sesion fallido por contrasena incorrecta
    When digita su username: "pablo99", una contrasena incorrecta: "zxcvb" y confirma su accion
    Then el usuario observa un mensaje de error relacionado a sus credenciales