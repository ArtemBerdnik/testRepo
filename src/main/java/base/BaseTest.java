package base;

import enums.Browser;
import enums.PropertiesResource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import javax.xml.bind.PropertyException;

public class BaseTest {

    @BeforeAll
    static void beforeAll() {
        String propertiesFile = ClassLoader.getSystemResource("application.properties").getPath();
        TestContext.getPropertiesManager()
                .setPropertiesResource(PropertiesResource.SYSTEM)
                .setPropertiesResource(PropertiesResource.FILE)
                .setPropertiesFile(propertiesFile);

        Browser browser;

        try {
            browser = Browser.valueOf(TestContext.getPropertiesManager().getProperty("browser").toUpperCase());
        } catch (PropertyException e) {
            browser = Browser.CHROME;
        }

        TestContext.getWebDriverManager().setCurrentDriver(browser);
        TestContext.getWebDriverManager().getCurrentDriver().getWebDriver().manage().window().maximize();
    }

    @AfterAll
    static void afterAll() {
        TestContext.getWebDriverManager().destroyCurrentWebDriver();
    }

    @BeforeEach
    void beforeEach() {
        try {
            TestContext.getWebDriverManager().getCurrentDriver().getWebDriver().get(TestContext.getPropertiesManager().getProperty("site.url"));
        } catch (PropertyException e) {
            throw new RuntimeException("Incorrect url specified");
        }
    }
}
