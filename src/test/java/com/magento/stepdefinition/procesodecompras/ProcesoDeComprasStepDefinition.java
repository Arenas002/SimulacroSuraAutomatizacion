package com.magento.stepdefinition.procesodecompras;

import com.magento.pages.ProcesoDeCompraPage;
import com.magento.setup.WebUI;
import com.magento.stepdefinition.login.LoginStepDefinition;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class ProcesoDeComprasStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(ProcesoDeComprasStepDefinition.class);
    @Dado("que el usuario ingresa productos al carrito de compras")
    public void queElUsuarioIngresaProductosAlCarritoDeCompras() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();
            ProcesoDeCompraPage procesoDeCompraPage = new ProcesoDeCompraPage(driver,3);
            procesoDeCompraPage.clickEnlogin();
            procesoDeCompraPage.diligenciarLogin();
            procesoDeCompraPage.clickEnBotonLogin();
            procesoDeCompraPage.agregarProductosMujer();
            procesoDeCompraPage.agregarProductosHombre();

        }catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
            quiteDriver();
        }
    }

    @Cuando("se realiza el proceso de compra")
    public void seRealizaElProcesoDeCompra() {
        try{
            ProcesoDeCompraPage procesoDeCompraPage = new ProcesoDeCompraPage(driver,3);
            procesoDeCompraPage.clickBotonRealizarCompra();
            procesoDeCompraPage.selecionarEstado();
        }catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
            quiteDriver();
        }
    }

    @Entonces("se visualiza un mensaje de exito")
    public void seVisualizaUnMensajeDeExito() {
        try{

        }catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
            quiteDriver();
        }
    }
}
