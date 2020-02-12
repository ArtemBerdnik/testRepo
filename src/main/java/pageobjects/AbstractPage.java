package pageobjects;

import base.TestContext;
import interfaces.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LoggerManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractPage {

    WebDriver driver = TestContext.getWebDriverManager().getCurrentDriver().getWebDriver();

    //================================Methods==========================//

    //================================Assertions==========================//

    public void verifyTextInElement(Element element, String expectedText) {
        assertEquals(element.getText(), expectedText);
        LoggerManager.info(String.format("Actual text = %s. Expected text = %s", element.getText(), expectedText));
    }

}

