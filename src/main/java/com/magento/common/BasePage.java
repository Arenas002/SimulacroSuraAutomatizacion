package com.magento.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class BasePage {
    private static final Logger LOGGER = Logger.getLogger(BasePage.class);
    private static final String WEBDRIVER_NULL_MESSAGE = "\nWARNING!\n\rThe Webdriver is null, please check it.\n";
    protected WebDriver driver;


    public BasePage(WebDriver driver){
        try{
            if(driver == null){
                LOGGER.warn(WEBDRIVER_NULL_MESSAGE);
            }
            this.driver = driver;
        }catch (Exception exception){
            LOGGER.warn(exception.getMessage(),exception);
        }
    }


    public BasePage(WebDriver driver,int segundos){
        try{
            if(driver == null){
                LOGGER.warn(WEBDRIVER_NULL_MESSAGE);
            }
            this.driver = driver;
            WebDriverEsperaImplicita(driver,segundos);
        }catch (Exception exception){
            LOGGER.warn(exception.getMessage(),exception);
        }
    }

   private void WebDriverEsperaImplicita(WebDriver driver,int segundos){
        try{
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(segundos));
        }catch (Exception exception){
            LOGGER.warn(exception.getMessage(),exception);
        }
   }

   protected void pageFactoryInitElement(WebDriver driver,Object page){
       PageFactory.initElements(driver,page);
   }

   //funcionalidades

protected void clickEnElemento(WebElement elemento){
        try{
        elemento.click();
        }catch (Exception exception){
            LOGGER.warn(exception.getMessage(),exception);
        }
    }

protected void escribirEnCampoTexto(WebElement elemento,String value){
        try{
            elemento.clear();
            elemento.sendKeys(value);
        }catch (Exception exception){
            LOGGER.warn(exception.getMessage(),exception);
        }
    }
   protected void scrollOn(WebElement elemento){
        try{
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",elemento);
        }catch (Exception exception){
            LOGGER.warn(exception.getMessage(),exception);
        }
   }

    protected void clickJava(WebElement elemento){
        try{
            ((JavascriptExecutor)driver).executeScript("arguments[0].click(true);",elemento);
        }catch (Exception exception){
            LOGGER.warn(exception.getMessage(),exception);
        }
    }

   protected boolean estaPresente(WebElement elemento){
        try{
            return elemento.isDisplayed();
        }catch (Exception exception){
            LOGGER.warn(exception.getMessage(),exception);
            return false;
        }
   }

   protected String obtenerTextoDeElemento(WebElement elemento){
        try{
            return elemento.getText();
        }catch (Exception exception){
            LOGGER.warn(exception.getMessage(),exception);
            return "";
        }
   }

   protected List<WebElement> obtenerProductosElementos(WebElement elemento){
        return driver.findElements(By.cssSelector(String.valueOf(elemento)));
   }

    public void obtenerProductos(String tallas, String colores, String agregarCarrio) throws InterruptedException {
        List<WebElement> listaDeTallas=driver.findElements(By.id(tallas));
        List<WebElement> listaDeColores=driver.findElements(By.id(colores));
        List<WebElement> listaDeBotones=driver.findElements(By.cssSelector(agregarCarrio));

        for(int i = 0; i < 2; i++){
            clickEnElemento(listaDeTallas.get(i));
            clickEnElemento(listaDeColores.get(i));
            clickEnElemento(listaDeBotones.get(i));

            Thread.sleep(1000);

        }


    }


}
