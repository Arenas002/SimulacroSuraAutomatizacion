package com.magento.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/procesoDeCompra/ProcesoDeCompras.feature"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","html:target/register-cucumber-reports.html"},
        glue = "com.magento.stepdefinition.procesodecompras"
)
public class ProcesoDeCompraRunner {
}
