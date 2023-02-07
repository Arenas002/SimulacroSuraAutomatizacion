#language: es

  Característica: registrar un nuevo usuario en el sistema

    Regla: como un  nuevo usuario de la aplicación
          quiero registrarme en el sistema
          para realizar compras

Antecedentes:
  Dado que el usuario ingresa al formulario de registro

    Escenario: 001 - Registro de usuario exitoso
      Cuando se registra en el sistema
      Entonces se visualiza un mensaje de éxito


    Escenario: 002 - Registro de usuario incorrecto
      Cuando se registra sin correo electrónico
      Entonces se visualiza un mensaje de campo requerido
