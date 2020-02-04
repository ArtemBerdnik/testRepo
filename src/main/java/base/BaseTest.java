package base;

import enums.Browser;
import enums.PropertiesResource;
import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import utils.LoggerManager;

import javax.xml.bind.PropertyException;
import java.util.NoSuchElementException;


import static base.TestContext.*;

public class BaseTest {

    @BeforeAll
    static void beforeAll() {
        BasicConfigurator.configure();
        String propertiesFile = ClassLoader.getSystemResource("application.properties").getPath();
        getPropertiesManager()
                .setPropertiesResource(PropertiesResource.SYSTEM)
                .setPropertiesResource(PropertiesResource.FILE)
                .setPropertiesFile(propertiesFile);

        Browser browser;

        try {
            browser = Browser.valueOf(getPropertiesManager().getProperty("browser").toUpperCase());
        } catch (PropertyException e) {
            LoggerManager.warn("No browser was found in properties. Setting to default " + Browser.CHROME);
            browser = Browser.CHROME;
        }

        getWebDriverManager().setCurrentDriver(browser);
        getWebDriverManager().getCurrentDriver().getWebDriver().manage().window().maximize();
    }

    @AfterAll
    static void afterAll() {
        getWebDriverManager().destroyCurrentWebDriver();
    }

    @BeforeEach
    void beforeEach() {
        try {
            getWebDriverManager().getCurrentDriver().getWebDriver().get(TestContext.getPropertiesManager().getProperty("site.url"));
        } catch (NoSuchElementException | PropertyException e) {
            LoggerManager.fatal("Incorrect URL was specified in properties.");
            getWebDriverManager().destroyCurrentWebDriver();
        }
    }
}
