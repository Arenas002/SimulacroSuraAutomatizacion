package com.magento.pages;

import com.magento.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AgregarProductosAlCarritoDeComprasPage extends BasePage {

    @CacheLookup
    @FindBy(id = "ui-id-8")
    private WebElement navegarAVentas;

    @CacheLookup
    @FindBy(id = "ui-id-8")
    private WebElement navegarAVentas1;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[4]/div[2]/div/div/ul[1]/li[3]/a")
    private WebElement navegarCamisetasMujer;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[4]/div[2]/div/div/ul[2]/li[4]/a")
    private WebElement navegarPantalonesHombre;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[4]/div[2]/div/div/ul[3]/li[1]/a")
    private WebElement navegarBolsos;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a")
    private WebElement carritoDeCompras;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a")
    private WebElement navegarACarritoDeCompras;

    public AgregarProductosAlCarritoDeComprasPage(WebDriver driver, int segundos) {
        super(driver, segundos);
        pageFactoryInitElement(driver,this);
    }

    public void clickVentas(){
        clickEnElemento(navegarAVentas);
    }
    public void clickVentas1(){
        clickEnElemento(navegarAVentas1);
    }

    public void clickCamisetasMujer(){
        clickEnElemento(navegarCamisetasMujer);
    }

    public void clickPantalonesHombre(){
        clickEnElemento(navegarPantalonesHombre);
    }
    public void clickCarritoCompras(){
        clickEnElemento(carritoDeCompras);
    }

    public void clickBolsos(){
        clickEnElemento(navegarBolsos);
    }
    public void clickLinkCarrito(){
        clickEnElemento(navegarACarritoDeCompras);
    }


    public void agregarProductosMujer() throws InterruptedException {
        clickCamisetasMujer();
        List<WebElement> listaDeTallas=driver.findElements(By.id("option-label-size-143-item-166"));
        List<WebElement> listaDeColores=driver.findElements(By.id("option-label-color-93-item-49"));
        List<WebElement> listaDeBotones=driver.findElements(By.cssSelector("button.action.tocart.primary"));

        for(int i = 0; i < 2; i++){
            clickEnElemento(listaDeTallas.get(i));
            clickEnElemento(listaDeColores.get(i));
            clickEnElemento(listaDeBotones.get(i));

            Thread.sleep(1000);

        }
    }

    public void agregarProductosHombre() throws InterruptedException {
        clickVentas();
        clickPantalonesHombre();
        List<WebElement> listaDeTallas=driver.findElements(By.id("option-label-size-143-item-176"));
        List<WebElement> listaDeColores=driver.findElements(By.id("option-label-color-93-item-50"));
        List<WebElement> listaDeBotones=driver.findElements(By.cssSelector("button.action.tocart.primary"));

        for(int i = 0; i < 2; i++){
            clickEnElemento(listaDeTallas.get(i));
            clickEnElemento(listaDeColores.get(i));
            clickEnElemento(listaDeBotones.get(i));

            Thread.sleep(1000);

        }
    }

    public void agregarProductosbolsos() throws InterruptedException {
        clickVentas1();
        clickBolsos();
        List<WebElement> listaDeBotones=driver.findElements(By.cssSelector("button.action.tocart.primary"));
        List<WebElement> listaDeTarjetas=driver.findElements(By.className("product-item-info"));


        for(int i = 0; i < 2; i++){
            Actions accion = new Actions(driver);
            accion.moveToElement(listaDeTarjetas.get(i)).build().perform();
            clickEnElemento(listaDeBotones.get(i));

            Thread.sleep(1000);

        }
    }

public List<WebElement> obtenerProductosDeCarrito(){
    List<WebElement> listaDeBotones=driver.findElements(By.cssSelector("tbody.cart.item"));
    return listaDeBotones;

}






}
