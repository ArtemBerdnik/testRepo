package pageobjects;

import base.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractPage {

    WebDriver driver = TestContext.getWebDriverManager().getCurrentDriver().getWebDriver();

    //================================Methods==========================//

    //================================Assertions==========================//

    public void verifyTextInElement(WebElement element, String expectedText) {
        assertEquals(element.getText(), expectedText);
    }

}

