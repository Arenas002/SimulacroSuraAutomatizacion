package com.magento.stepdefinition.carritodecompras;

import com.magento.pages.EliminarDeCarritoDeComprasPage;
import com.magento.setup.WebUI;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class EliminarDeCarritoDeComprasStepDefinition extends WebUI {


    @Dado("que el usuario ingresa al modulo de ventas")
    public void queElUsuarioIngresaAlModuloDeVentas() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();
            EliminarDeCarritoDeComprasPage eliminarDeCarritoDeComprasPage = new EliminarDeCarritoDeComprasPage(driver,3);
            eliminarDeCarritoDeComprasPage.clickEnVentas();
            eliminarDeCarritoDeComprasPage.clickEnChaquetas();
            eliminarDeCarritoDeComprasPage.obtenerProductos();

        }catch (Exception exception){
            mensajeError(exception);
        }
    }

    @Cuando("verifica el carrito de compras")
    public void verificaElCarritoDeCompras() {
        try{
            EliminarDeCarritoDeComprasPage eliminarDeCarritoDeComprasPage = new EliminarDeCarritoDeComprasPage(driver,3);
            eliminarDeCarritoDeComprasPage.clickEnCarritoDeCompras();
            eliminarDeCarritoDeComprasPage.clickEnNavegarAlCarrito();
        }catch (Exception exception){
            mensajeError(exception);

        }
    }

    @Y("elimina productos")
    public void eliminaProductos() {
        try{
            EliminarDeCarritoDeComprasPage eliminarDeCarritoDeComprasPage = new EliminarDeCarritoDeComprasPage(driver,3);
            eliminarDeCarritoDeComprasPage.eliminarProducto();
        }catch (Exception exception){
            mensajeError(exception);

        }
    }

    @Entonces("se elimina correctamente el producto")
    public void seEliminaCorrectamenteElProducto() {
        try{
            EliminarDeCarritoDeComprasPage eliminarDeCarritoDeComprasPage = new EliminarDeCarritoDeComprasPage(driver,3);
            Assertions.assertEquals("You have no items in your shopping cart.",eliminarDeCarritoDeComprasPage.mensajeCarrito());
            quiteDriver();
        }catch (Exception exception){
            System.out.println("Aqui esto se volvio mierda pa ");
            mensajeError(exception);

        }
    }
}
