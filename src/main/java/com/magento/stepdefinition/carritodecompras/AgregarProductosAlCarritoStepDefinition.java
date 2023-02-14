package com.magento.stepdefinition.carritodecompras;

import com.magento.pages.AgregarProductosAlCarritoDeComprasPage;
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
            AgregarProductosAlCarritoDeComprasPage agregarProductosAlCarritoDeComprasPage = new AgregarProductosAlCarritoDeComprasPage(driver,3);
            agregarProductosAlCarritoDeComprasPage.clickVentas();
        }catch (Exception exception){
            mensajeError(exception);
        }
    }

    @Cuando("agrega productos de diferentes categorias diferentes al carrito de compras")
    public void agregaProductosDeCategoriasDiferentesAlCarritoDeCompras() {
        try{
            AgregarProductosAlCarritoDeComprasPage agregarProductosAlCarritoDeComprasPage = new AgregarProductosAlCarritoDeComprasPage(driver,3);
            agregarProductosAlCarritoDeComprasPage.agregarProductosMujeres();
            agregarProductosAlCarritoDeComprasPage.agregarProductosHombre();
            agregarProductosAlCarritoDeComprasPage.agregarProductosbolsos();
            agregarProductosAlCarritoDeComprasPage.clickCarritoCompras();
            agregarProductosAlCarritoDeComprasPage.clickLinkCarrito();
        }catch (Exception exception){
            mensajeError(exception);
        }
    }

    @Entonces("se visualizan los productos en el carrito de compras")
    public void seVisualizanLosProductosEnElCarritoDeCompras() {
        try{
            AgregarProductosAlCarritoDeComprasPage agregarProductosAlCarritoDeComprasPage = new AgregarProductosAlCarritoDeComprasPage(driver,3);
            Assertions.assertEquals(6, agregarProductosAlCarritoDeComprasPage.obtenerProductosDeCarrito().size());
        }catch (Exception exception){
           mensajeError(exception);
        }finally {
            quiteDriver();
        }
    }
}
