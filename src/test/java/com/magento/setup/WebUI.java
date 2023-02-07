package com.magento.setup;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static com.magento.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;

public class WebUI {

    private static final String  WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_DRIVER_PATH = "src/test/resources/webdriver/windows/chrome/chromedriver.exe";
    private static final String DEMO_QA_URL ="https://magento.softwaretestingboard.com/";
    protected WebDriver driver;

    protected  void setUpWebDriver(){
        System.setProperty(WEBDRIVER_CHROME_DRIVER,WEBDRIVER_CHROME_DRIVER_PATH);

    }

    protected  void  generalSetUp(){
        driver = new ChromeDriver();
        driver.get(DEMO_QA_URL);
        driver.manage().window().maximize();
    }
    protected void setUpLog4j2(){
        PropertyConfigurator.configure(USER_DIR.value()+LOG4J_PROPERTIES_FILE_PATH.getValue() );
    }
    protected void quiteDriver(){
        driver.quit();
    }
}
