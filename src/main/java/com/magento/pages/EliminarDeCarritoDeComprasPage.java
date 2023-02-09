package com.magento.pages;

import com.magento.common.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class EliminarDeCarritoDeComprasPage extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(EliminarDeCarritoDeComprasPage.class);


    @CacheLookup
    @FindBy(id = "ui-id-8")
    private WebElement navegarAVentas;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[4]/div[2]/div/div/ul[1]/li[2]/a")
    private WebElement chaquetasLink;

    @CacheLookup
    @FindBy(css = " div.swatch-option.text#option-label-size-143-item-168")
    private WebElement tallaM;

    @CacheLookup
    @FindBy(css = "button.action-primary.action-accept")
    private WebElement botonOk;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a")
    private WebElement carritoDeCompras;

    @CacheLookup
    @FindBy(css = "ol.products.list.items.product-items li div.product-item-info div.swatch-option.text#option-label-size-143-item-168")
    private WebElement listaProductos;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"shopping-cart-table\"]/tbody[1]/tr[2]/td/div/a[2]")
    private WebElement eliminarProducto1;
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"shopping-cart-table\"]/tbody[2]/tr[2]/td/div/a[2]")
    private WebElement eliminarProducto2;
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"shopping-cart-table\"]/tbody/tr[2]/td/div/a[2]")
    private WebElement eliminarProducto3;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a")
    private WebElement navegarAlCarrito;

    @CacheLookup
    @FindBy(xpath = "//p[contains(text(),'You have no items in your shopping cart.')]")
    private WebElement mensajeCarritoVacio;


    public EliminarDeCarritoDeComprasPage(WebDriver driver, int segundos) {
        super(driver, segundos);
        pageFactoryInitElement(driver,this);
    }

    public void clickEnVentas(){
        clickEnElemento(navegarAVentas);
    }
    public void clickEnChaquetas(){
        clickEnElemento(chaquetasLink);
    }


    public void obtenerProductos() throws InterruptedException {
        List<WebElement> listaDeTallas=driver.findElements(By.id("option-label-size-143-item-168"));
//        listaDeTallas.forEach(elemento -> {clickEnElemento(elemento);});

        List<WebElement> listaDeColores=driver.findElements(By.id("option-label-color-93-item-50"));
//        listaDeColores.forEach(elemento -> {clickEnElemento(elemento);});

        List<WebElement> listaDeBotones=driver.findElements(By.cssSelector("button.action.tocart.primary"));

//        List<WebElement> listaDeTarjetas=driver.findElements(By.className("product-item-info"));


        for(int i = 0; i < 3; i++){
            clickEnElemento(listaDeTallas.get(i));
            clickEnElemento(listaDeColores.get(i));
            clickEnElemento(listaDeBotones.get(i));

                Thread.sleep(1000);

            }
        }
       public void clickEnCarritoDeCompras(){
        clickEnElemento(carritoDeCompras);
       }
       public void clickEnNavegarAlCarrito(){
        clickEnElemento(navegarAlCarrito);
       }

       public void eliminarProducto(){
try{
    clickEnElemento(eliminarProducto1);
    clickEnElemento(eliminarProducto2);
    clickEnElemento(eliminarProducto3);

}catch (Exception exception){
    LOGGER.error("Error al eliminar los productos");
}



       }

       public String mensajeCarrito(){
        return obtenerTextoDeElemento(mensajeCarritoVacio);
       }

    }





