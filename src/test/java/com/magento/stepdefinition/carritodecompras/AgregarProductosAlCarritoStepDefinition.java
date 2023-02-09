package com.magento.stepdefinition.carritodecompras;

import com.magento.setup.WebUI;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class AgregarProductosAlCarritoStepDefinition extends WebUI {
    private static final Logger LOGGER = Logger.getLogger(AgregarProductosAlCarritoStepDefinition.class);
    @Dado("que el usuario ingresa a los productos del modulo de venta")
    public void queElUsuarioIngresaALosProductosDelModuloDeVenta() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();
        }catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
            quiteDriver();
        }
    }

    @Cuando("agrega productos de diferentes categorias diferentes al carrito de compras")
    public void agregaProductosDeCategoriasDiferentesAlCarritoDeCompras() {
        try{

        }catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
            quiteDriver();
        }
    }

    @Entonces("se visualizan los productos en el carrito de compras")
    public void seVisualizanLosProductosEnElCarritoDeCompras() {
        try{

        }catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
            quiteDriver();
        }
    }
}
