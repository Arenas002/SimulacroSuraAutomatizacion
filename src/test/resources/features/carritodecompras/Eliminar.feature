#language: es

Característica: Eliminar productos del carrito de compras

  Regla: como usuario de la aplicación
  quiero eliminar productos del carrito de compras
  para modificar la compra a realizar

    Escenario: 001 - Eliminar productos del carrito de compras
      Dado que el usuario ingresa al modulo de ventas
      Cuando verifica el carrito de compras
      Y elimina productos
      Entonces se elimina correctamente el producto
