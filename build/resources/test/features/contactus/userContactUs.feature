# new feature
# Tags: optional

Feature: Atencion al cliente para visitantes de la pagina web
  Como visitante de la pagina web de ParaBank
  quiero ponerme en contacto con un trabajador del banco
  para consultar informacion que necesito

  Scenario: Visitante de la pagina quiere acceder a la opcion de Contact Us
    When el usuario visitante de la pagina se encuentra en el home
    Then existe una opcion de Contact Us
    And lo redirige a la pagina correcta

    Scenario: Envio de mensaje para contacto exitoso
      Given el usuario visitante se encuentra en la pagina de Contact us
      When llena la informacion de todos los campos y valida su accion
      Then aparece un mensaje de atencion al cliente que lo contactara pronto