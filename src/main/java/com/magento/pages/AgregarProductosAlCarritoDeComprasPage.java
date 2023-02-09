package com.magento.pages;

import com.magento.common.BasePage;
import org.openqa.selenium.WebDriver;

public class AgregarProductosAlCarritoDeComprasPage extends BasePage {
    public AgregarProductosAlCarritoDeComprasPage(WebDriver driver, int segundos) {
        super(driver, segundos);
        pageFactoryInitElement(driver,this);
    }
}
