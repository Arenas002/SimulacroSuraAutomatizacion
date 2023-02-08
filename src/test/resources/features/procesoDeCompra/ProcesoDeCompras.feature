#language: es

Característica: Realizar compra exitosa de productos

  Regla: como usuario de la aplicación
  quiero realizar una compra de productos de diferentes categorias
  para que los productos lleguen a la direccion solicitada

    Escenario: 001 - Realizar compra exitosa de categoria mujer y hombre
      Dado que el usuario ingresa productos al carrito de compras
      Cuando se realiza el proceso de compra
      Entonces se visualiza un mensaje de exito