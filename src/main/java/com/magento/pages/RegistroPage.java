package com.magento.pages;

import com.magento.common.BasePage;
import com.magento.model.ClienteModel;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegistroPage extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(RegistroPage.class);


    @CacheLookup
    @FindBy(id = "firstname")
    private WebElement nombre;

    @CacheLookup
    @FindBy(id = "lastname")
    private WebElement apellido;

    @CacheLookup
    @FindBy(id = "email_address")
    private WebElement correo;

    @CacheLookup
    @FindBy(id = "password")
    private WebElement contraseña;

    @CacheLookup
    @FindBy(id = "password-confirmation")
    private WebElement confirmarContraseña;

    @CacheLookup
    @FindBy(linkText= "Create an Account")
    private WebElement crearUsuario;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"form-validate\"]/div/div[1]/button/span")
    private WebElement botonRegistrarse;


    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Thank you for registering with Fake Online Clothin')]")
    private WebElement mensajeDeValidacion;


    @CacheLookup
    @FindBy(id = "email_address-error")
    private WebElement mensajeErrorCorreo;





    public RegistroPage(WebDriver driver, int segundos) {
        super(driver, segundos);
        pageFactoryInitElement(driver,this);
    }

    public void clickRegistro(){clickEnElemento(crearUsuario);}

    public void diligenciarCamposRegistro(ClienteModel clienteModel) {
        try {
            escribirEnCampoTexto(nombre, clienteModel.getNombre());
            escribirEnCampoTexto(apellido, clienteModel.getApellido());
            escribirEnCampoTexto(correo, clienteModel.getCorreo());
            escribirEnCampoTexto(contraseña, clienteModel.getContraseña());
            escribirEnCampoTexto(confirmarContraseña, clienteModel.getContraseña());
        }catch (Exception exception){
            LOGGER.error("Error llenando los campos de registro");
        }
    }

    public void presionarBotonEnviar(){
        clickEnElemento(botonRegistrarse);
    }

    public String obtenerMensajeDeTexto(){
        return obtenerTextoDeElemento(mensajeDeValidacion);
    }

    public void diligenciarCamposRegistroSinCorreo(ClienteModel clienteModel) {
        try {
            escribirEnCampoTexto(nombre, clienteModel.getNombre());
            escribirEnCampoTexto(apellido, clienteModel.getApellido());
            escribirEnCampoTexto(contraseña, clienteModel.getContraseña());
            escribirEnCampoTexto(confirmarContraseña, clienteModel.getContraseña());
        }catch (Exception exception){
            LOGGER.error("Error llenando los campos de registro");
        }
    }

    public String obtenerMensajeErrorCorreo(){
        return obtenerTextoDeElemento(mensajeErrorCorreo);
    }
}
