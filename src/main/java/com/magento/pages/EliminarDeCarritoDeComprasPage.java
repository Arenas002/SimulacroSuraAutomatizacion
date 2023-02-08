package com.magento.pages;

import com.magento.common.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

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
    @FindBy(xpath = "//*[@id=\"send2\"]")
    private WebElement botonLogin;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
    private WebElement actionSwith;

    @CacheLookup
    @FindBy(css = "ol.products.list.items.product-items li div.product-item-info div.swatch-option.text#option-label-size-143-item-168")
    private WebElement listaProductos;

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

    public  void Scrow()
//    public void clickEnTallaL(){
//        clickEnElemento(tallaL);
//    }

    public void obtenerProductos(){
        List<WebElement> productos = obtenerProductosElementos(listaProductos);
        List<WebElement> productosFiltrados= new ArrayList<>();
        for(WebElement elementos: productos){
           productosFiltrados.add(elementos);

        }
        for(int i = 0; i < productosFiltrados.size(); i++){
            clickEnElemento(tallaM);
        }

    }

}
