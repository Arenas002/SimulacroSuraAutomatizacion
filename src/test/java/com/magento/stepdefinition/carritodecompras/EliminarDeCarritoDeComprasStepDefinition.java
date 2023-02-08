package com.magento.stepdefinition.carritodecompras;

import com.magento.pages.EliminarDeCarritoDeComprasPage;
import com.magento.setup.WebUI;
import com.magento.stepdefinition.login.LoginStepDefinition;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class EliminarDeCarritoDeComprasStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(EliminarDeCarritoDeComprasStepDefinition.class);
    @Dado("que el usuario ingresa al modulo de ventas")
    public void queElUsuarioIngresaAlModuloDeVentas() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();
            EliminarDeCarritoDeComprasPage eliminarDeCarritoDeComprasPage = new EliminarDeCarritoDeComprasPage(driver,3);
            eliminarDeCarritoDeComprasPage.clickEnVentas();
            eliminarDeCarritoDeComprasPage.clickEnChaquetas();
//            eliminarDeCarritoDeComprasPage.clickEnTallaL();
            eliminarDeCarritoDeComprasPage.obtenerProductos();

        }catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
            quiteDriver();
        }
    }

    @Cuando("verifica el carrito de compras")
    public void verificaElCarritoDeCompras() {
        try{

        }catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
            quiteDriver();
        }
    }

    @Y("elimina productos")
    public void eliminaProductos() {
        try{

        }catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
            quiteDriver();
        }
    }

    @Entonces("se elimina correctamente el producto")
    public void seEliminaCorrectamenteElProducto() {
        try{

        }catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
            quiteDriver();
        }
    }
}
