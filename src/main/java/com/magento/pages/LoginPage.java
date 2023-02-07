package com.magento.pages;

import com.magento.common.BasePage;
import com.magento.model.ClienteModel;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(LoginPage.class);
    ClienteModel clienteModel;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
    private WebElement loginLink;

    @CacheLookup
    @FindBy(id = "email")
    private WebElement correo;

    @CacheLookup
    @FindBy(id = "pass")
    private WebElement contraseña;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"send2\"]")
    private WebElement botonLogin;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
    private WebElement actionSwith;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")
    private WebElement cerrarSession;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'The account sign-in was incorrect or your account ')]")
    private WebElement mensajeErrorLogin;


    @CacheLookup
    @FindBy(xpath = "//body/div[2]/main[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/p[1]")
    private WebElement nombreConfirmacionLogin;





    public LoginPage(WebDriver driver, int segundos) {
        super(driver, segundos);
        pageFactoryInitElement(driver,this);
    }

    public void clickEnLinkLoing(){
        clickEnElemento(loginLink);
    }

    public void diligenciarLogin(ClienteModel clienteModel){
        try{
            escribirEnCampoTexto(correo,clienteModel.getCorreo());
            escribirEnCampoTexto(contraseña,clienteModel.getContraseña());

        }catch (Exception exception){
            LOGGER.error("Error al diligenciar los daos del formulario de login");
        }
    }

    public void clickEnBotonLogin(){
        clickEnElemento(botonLogin);
    }
    public void clickEnActionSwith(){
        clickEnElemento(actionSwith);
    }
    public void clickEnCerrarSession(){
        clickEnElemento(cerrarSession);
    }

    public void diligenciarLoginCorreoNoRegistrado(ClienteModel clienteModel){
        try{
            escribirEnCampoTexto(correo,clienteModel.getCorreo());
            escribirEnCampoTexto(contraseña,clienteModel.getContraseña());

        }catch (Exception exception){
            LOGGER.error("Error al diligenciar los daos del formulario de login");
        }
    }

    public String obtenerMensajeDeErrorLogin(){
        return obtenerTextoDeElemento(mensajeErrorLogin);
    }

public String obtenerNombreLogin(){
    return obtenerTextoDeElemento(nombreConfirmacionLogin);
    }
}
