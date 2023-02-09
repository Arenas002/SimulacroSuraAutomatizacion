package com.magento.stepdefinition.procesodecompras;

import com.github.javafaker.Faker;
import com.magento.model.DatosCompraModel;
import com.magento.pages.ProcesoDeCompraPage;
import com.magento.setup.WebUI;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class ProcesoDeComprasStepDefinition extends WebUI {

    DatosCompraModel datosCompraModel;
    private static final Logger LOGGER = Logger.getLogger(ProcesoDeComprasStepDefinition.class);
    @Dado("que el usuario ingresa productos al carrito de compras")
    public void queElUsuarioIngresaProductosAlCarritoDeCompras() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();
            ProcesoDeCompraPage procesoDeCompraPage = new ProcesoDeCompraPage(driver,3);
            procesoDeCompraPage.agregarProductosMujer();
            procesoDeCompraPage.agregarProductosHombre();

        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);

        }
    }

    @Cuando("se realiza el proceso de compra")
    public void seRealizaElProcesoDeCompra() {
        try{
            ProcesoDeCompraPage procesoDeCompraPage = new ProcesoDeCompraPage(driver,3);
            procesoDeCompraPage.clickBotonRealizarCompra();
            generarDireccion();
            procesoDeCompraPage.diligenciarFormularioCompra(datosCompraModel);
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);

        }
    }

    @Entonces("se visualiza un mensaje de exito")
    public void seVisualizaUnMensajeDeExito() {
        try{
            ProcesoDeCompraPage procesoDeCompraPage = new ProcesoDeCompraPage(driver,3);
            Assertions.assertEquals("Thank you for your purchase!",procesoDeCompraPage.obtenerMensajeDeTexto());
            quiteDriver();
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);

        }
    }

    private void generarDireccion(){
        Faker faker = new Faker();
        datosCompraModel= new DatosCompraModel();
        datosCompraModel.setNombre(faker.name().firstName());
        datosCompraModel.setApellido(faker.name().lastName());
        datosCompraModel.setCorreo(faker.name().firstName()+faker.name().lastName()+"@gmail.com");
        datosCompraModel.setDireccion(faker.address().fullAddress());
        datosCompraModel.setCiudad(faker.address().city());
        datosCompraModel.setCodigoPostal(faker.address().zipCode());
        datosCompraModel.setTelefono(faker.phoneNumber().cellPhone());

    }
}
