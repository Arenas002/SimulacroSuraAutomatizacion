package com.magento.pages;

import com.magento.common.BasePage;
import com.magento.model.DatosCompraModel;
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
    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[1]/div/input")
    private WebElement nombre;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[2]/div/input")
    private WebElement apellido;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[1]/fieldset/div/div/input")
    private WebElement correo;
    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/fieldset/div/div[1]/div/input")
    private WebElement direccion;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[4]/div/input")
    private WebElement ciudad;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[7]/div/input")
    private WebElement codigoPostal;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[9]/div/input")
    private WebElement telefono;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a")
    private WebElement carritoDeCompras;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/div/button")
    private WebElement botonSiguiente;
    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/form/div[1]/table/tbody/tr[1]/td[1]/input")
    private WebElement metodosDeEnvio;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")
    private WebElement botonHacerCompra;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/main/div[1]/h1/span")
    private WebElement mensajeExitoso;



    public ProcesoDeCompraPage(WebDriver driver, int segundos) {
        super(driver, segundos);
        pageFactoryInitElement(driver,this);
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
    public void clickSiguiente(){
        clickEnElemento(botonSiguiente);
    }

    public void clickBotonRealizarCompra(){
        clickEnElemento(carritoDeCompras);
        clickEnElemento(botonRealizarCompra);
    }
    public void clickMetodoDeEnvio(){
        clickEnElemento(metodosDeEnvio);
    }
    public void clickBotonHacerCompra(){
        clickJava(botonHacerCompra);
    }

    public String obtenerMensajeDeTexto(){
        return obtenerTextoDeElemento(mensajeExitoso);
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
        return listaSelect.getFirstSelectedOption().getText();
    }

public void diligenciarFormularioCompra(DatosCompraModel datosCompraModel){
        try{

            escribirEnCampoTexto(correo,datosCompraModel.getCorreo());
            escribirEnCampoTexto(nombre,datosCompraModel.getNombre());
            escribirEnCampoTexto(apellido,datosCompraModel.getApellido());
            escribirEnCampoTexto(direccion,datosCompraModel.getDireccion());
            escribirEnCampoTexto(ciudad,datosCompraModel.getCiudad());
            selecionarEstado();
            escribirEnCampoTexto(codigoPostal,datosCompraModel.getCodigoPostal());
            escribirEnCampoTexto(telefono,datosCompraModel.getTelefono());
            clickMetodoDeEnvio();
            clickSiguiente();
            clickBotonHacerCompra();
        }catch (Exception exception){
            LOGGER.error("Error llenando los campos de direccion de compra");
        }
}


}
