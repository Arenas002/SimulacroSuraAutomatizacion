package com.magento.pages;

import com.magento.common.BasePage;
import com.magento.model.ClienteModel;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.Select;



import java.util.List;




public class ProcesoDeCompraPage extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(ProcesoDeCompraPage.class);
    private static final String CORREO_ELECTRONICO = "pruebasofka@pihey.com";
    private static final String CONTRASEÑA = "Qwerty12";


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
    @FindBy(id = "ui-id-8")
    private WebElement navegarAVentas;
    @CacheLookup
    @FindBy(id = "ui-id-8")
    private WebElement navegarAVentas2;



    @CacheLookup
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[4]/div[2]/div/div/ul[1]/li[6]/a")
    private WebElement navegarShort;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[4]/div[2]/div/div/ul[2]/li[2]/a")
    private WebElement navegarChaquetas;

    @CacheLookup
    @FindBy(id = "top-cart-btn-checkout")
    private WebElement botonRealizarCompra;

    @CacheLookup
    @FindBy(id = "HT1W9XA")
    private WebElement direccion;

    @CacheLookup
    @FindBy(id = "LD3FCX3")
    private WebElement ciudad;

    @CacheLookup
    @FindBy(id = "A99AMDW")
    private WebElement codigoPostal;

    @CacheLookup
    @FindBy(id = "O18C49P")
    private WebElement telefono;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a")
    private WebElement carritoDeCompras;










    public ProcesoDeCompraPage(WebDriver driver, int segundos) {
        super(driver, segundos);
        pageFactoryInitElement(driver,this);
    }

    public void clickEnlogin(){
        clickEnElemento(loginLink);
    }
    public void clickEnBotonLogin(){
        clickEnElemento(botonLogin);
    }

    public void clickEnVentas(){
        clickEnElemento(navegarAVentas);
    }
    public void clickShort(){
        clickEnElemento(navegarShort);
    }
    public void clickChaquetas(){
        clickEnElemento(navegarChaquetas);
    }

    public void clickBotonRealizarCompra(){
        clickEnElemento(carritoDeCompras);
        clickEnElemento(botonRealizarCompra);
    }


    public void diligenciarLogin(){
        try{
            escribirEnCampoTexto(correo,CORREO_ELECTRONICO);
            escribirEnCampoTexto(contraseña,CONTRASEÑA);

        }catch (Exception exception){
            LOGGER.error("Error al diligenciar los daos del formulario de login");
        }
    }

    public void agregarProductosMujer() throws InterruptedException {
        clickEnVentas();
        clickShort();
        List<WebElement> listaDeTallas=driver.findElements(By.id("option-label-size-143-item-172"));
        List<WebElement> listaDeColores=driver.findElements(By.id("option-label-color-93-item-58"));
        List<WebElement> listaDeBotones=driver.findElements(By.cssSelector("button.action.tocart.primary"));

        for(int i = 0; i < 2; i++){
            clickEnElemento(listaDeTallas.get(i));
            clickEnElemento(listaDeColores.get(i));
            clickEnElemento(listaDeBotones.get(i));

            Thread.sleep(1000);

        }
    }


    public void agregarProductosHombre() throws InterruptedException {
        clickEnElemento(navegarAVentas2);
        clickChaquetas();
        List<WebElement> listaDeTallas=driver.findElements(By.id("option-label-size-143-item-169"));
        List<WebElement> listaDeColores=driver.findElements(By.id("option-label-color-93-item-49"));
        List<WebElement> listaDeBotones=driver.findElements(By.cssSelector("button.action.tocart.primary"));

        for(int i = 0; i < 2; i++){
            clickEnElemento(listaDeTallas.get(i));
            clickEnElemento(listaDeColores.get(i));
            clickEnElemento(listaDeBotones.get(i));

            Thread.sleep(1000);

        }
    }

    public String selecionarEstado(){
        Select listaSelect = new Select(driver.findElement(By.className("select")));
        listaSelect.selectByVisibleText("California");
//        listaSelect.selectByIndex(12);
        return listaSelect.getFirstSelectedOption().getText();
    }
}
