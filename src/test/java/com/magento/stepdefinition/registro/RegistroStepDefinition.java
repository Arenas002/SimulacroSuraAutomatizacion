package com.magento.stepdefinition.registro;

import com.github.javafaker.Faker;
import com.magento.model.ClienteModel;
import com.magento.pages.RegistroPage;
import com.magento.setup.WebUI;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class RegistroStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(RegistroStepDefinition.class);
    private ClienteModel clienteModel;

    @Dado("que el usuario ingresa al formulario de registro")
    public void queElUsuarioIngresaAlFormularioDeRegistro() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();
            generarPersona();
            RegistroPage registroPage = new RegistroPage(driver,3);
            registroPage.clickRegistro();
        }catch(Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
            quiteDriver();
        }
    }

    @Cuando("se registra en el sistema")
    public void seRegistraEnElSistema() {
        try{
        RegistroPage registroPage = new RegistroPage(driver,3);
        registroPage.diligenciarCamposRegistro(clienteModel);
        registroPage.presionarBotonEnviar();
        }catch(Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
            quiteDriver();
        }
    }

    @Entonces("se visualiza un mensaje de éxito")
    public void seVisualizaUnMensajeDeÉxito() {
        try{
            RegistroPage registroPage = new RegistroPage(driver,3);
            Assertions.assertEquals("Thank you for registering with Fake Online Clothing Store.",registroPage.obtenerMensajeDeTexto());
            quiteDriver();
        }catch(Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
            quiteDriver();
        }
    }

    @Cuando("se registra sin correo electrónico")
    public void seRegistraSinCorreoElectrónico() {
        try{
            RegistroPage registroPage = new RegistroPage(driver,3);
            registroPage.diligenciarCamposRegistroSinCorreo(clienteModel);
            registroPage.presionarBotonEnviar();
        }catch(Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
            quiteDriver();
        }
    }

    @Entonces("se visualiza un mensaje de campo requerido")
    public void seVisualizaUnMensajeDeCampoRequerido() {
        try{
            RegistroPage registroPage = new RegistroPage(driver,3);
            Assertions.assertEquals("This is a required field.",registroPage.obtenerMensajeErrorCorreo());
            quiteDriver();
        }catch(Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
            quiteDriver();
        }
    }

    private void generarPersona(){
        Faker faker = new Faker();
        clienteModel= new ClienteModel();
        clienteModel.setNombre(faker.name().firstName());
        clienteModel.setApellido(faker.name().lastName());
        clienteModel.setCorreo(clienteModel.getNombre()+clienteModel.getApellido()+"@gmail.com");
        clienteModel.setContraseña("Zxcvbnm12");
    }
}
