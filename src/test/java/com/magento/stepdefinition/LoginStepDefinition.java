package com.magento.stepdefinition;

import com.github.javafaker.Faker;
import com.magento.model.ClienteModel;
import com.magento.pages.LoginPage;
import com.magento.pages.RegistroPage;
import com.magento.setup.WebUI;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.jsontype.impl.AsExistingPropertyTypeSerializer;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class LoginStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(LoginStepDefinition.class);
    private ClienteModel clienteModel;
    @Dado("que el usuario ingresa al formulario inicio de session")
    public void queElUsuarioIngresaAlFormularioInicioDeSession() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();
            RegistroPage registroPage = new RegistroPage(driver,3);
            LoginPage loginPage = new LoginPage(driver,3);
            generarCliente();
            registroPage.clickRegistro();
            registroPage.diligenciarCamposRegistro(clienteModel);
            registroPage.presionarBotonEnviar();
            loginPage.clickEnActionSwith();
            loginPage.clickEnCerrarSession();
            loginPage.clickEnLinkLoing();
        }catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
            quiteDriver();
        }
    }

    @Cuando("inicia session en el sistema")
    public void iniciaSessionEnElSistema() {
        try{
            LoginPage loginPage = new LoginPage(driver,3);
            loginPage.diligenciarLogin(clienteModel);
            loginPage.clickEnBotonLogin();
        }catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
            quiteDriver();
        }
    }

    @Entonces("el usuario ingresa a su cuenta exitosamente")
    public void elUsuarioIngresaASuCuentaExitosamente() {
        try{
            LoginPage loginPage = new LoginPage(driver,7);
            Assertions.assertTrue(loginPage.obtenerNombreLogin().contains(clienteModel.getCorreo()));
            quiteDriver();
        }catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
            quiteDriver();
        }
    }

    @Cuando("inicia session con un correo no registrado")
    public void iniciaSessionConUnCorreoNoRegistrado() {
        try{
            LoginPage loginPage = new LoginPage(driver,3);
            generarCliente();
            loginPage.diligenciarLogin(clienteModel);
            loginPage.clickEnBotonLogin();
        }catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
            quiteDriver();
        }
    }

    @Entonces("se visualiza un mensaje de error de datos incorrectos")
    public void seVisualizaUnMensajeDeErrorDeDatosIncorrectos() {
        try{
            LoginPage loginPage = new LoginPage(driver,3);
            Assertions.assertEquals("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.",loginPage.obtenerMensajeDeErrorLogin());
            quiteDriver();
        }catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.error(exception.getMessage(),exception);
            quiteDriver();
        }
    }

    private void generarCliente(){
        Faker faker = new Faker();
        clienteModel= new ClienteModel();
        clienteModel.setNombre(faker.name().firstName());
        clienteModel.setApellido(faker.name().lastName());
        clienteModel.setCorreo(clienteModel.getNombre()+clienteModel.getApellido()+"@gmail.com");
        clienteModel.setContraseña("Zxcvbnm12");
    }
}
