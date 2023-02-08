package com.magento.pages;

import com.magento.common.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class EliminarDeCarritoDeComprasPage extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(EliminarDeCarritoDeComprasPage.class);


    @CacheLookup
    @FindBy(id = "ui-id-8")
    private WebElement navegarAVentas;

    @CacheLookup
    @FindBy(xpath = "//body/div[2]/main[1]/div[4]/div[2]/div[1]/div[1]/ul[2]/li[2]/a[1]")
    private WebElement chaquetasLink;

    @CacheLookup
    @FindBy(id = "option-label-size-143-item-169")
    private WebElement tallaL;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"send2\"]")
    private WebElement botonLogin;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
    private WebElement actionSwith;

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
    public void clickEnTallaL(){
        clickEnElemento(tallaL);
    }
}
