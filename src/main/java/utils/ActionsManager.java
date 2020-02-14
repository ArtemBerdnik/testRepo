package utils;

import base.TestContext;
import interfaces.Element;
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

    public static void hoverOverElement(Element element) {
        actions.moveToElement(element.getWrappedElement())
                .build()
                .perform();
        LoggerManager.info("Hovered mouse over " + element.getText());

    }

    public static void dragElementFromTo(Element elementToBeDragged, Element elementToDraggedTo) {
        actions.dragAndDrop(elementToBeDragged.getWrappedElement(), elementToDraggedTo.getWrappedElement())
                .build().perform();
    }

    public static void doubleClickElement(Element element) {
        actions.doubleClick(element.getWrappedElement()).build().perform();
    }

    public static void clickAndHold(Element element) {
        actions.clickAndHold(element.getWrappedElement()).build().perform();
    }

    public static void releaseButton(Element element) {
        actions.release(element.getWrappedElement()).build().perform();
    }

}
