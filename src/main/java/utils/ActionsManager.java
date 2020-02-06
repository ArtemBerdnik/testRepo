package utils;

import base.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsManager {

    private static Actions actions = new Actions(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver());

    public static void moveToElementAndClick(WebElement element) {
        actions.moveToElement(element)
                .click()
                .build()
                .perform();
        LoggerManager.info(element.getText() + " is clicked");
    }

    public static void hoverOverElement(WebElement element) {
        actions.moveToElement(element)
                .build()
                .perform();
        LoggerManager.info("Hovered mouse over " + element.getText());

    }

}
