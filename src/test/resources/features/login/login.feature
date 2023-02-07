#language: es

Característica: iniciar session en el sistema

  Regla: como  usuario de la aplicación
  quiero iniciar session en el sistema
  para realizar compras

    Antecedentes:
      Dado que el usuario ingresa al formulario inicio de session

    Escenario: 001 - inicio de session exitoso
      Cuando inicia session en el sistema
      Entonces el usuario ingresa a su cuenta exitosamente


    Escenario: 002 - inicio de session incorrecto
      Cuando inicia session con un correo no registrado
      Entonces se visualiza un mensaje de error de datos incorrectos