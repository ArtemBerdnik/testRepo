package pageobjects;

import interfaces.ListItem;
import interfaces.impl.SimpleButton;
import interfaces.impl.SimpleContainer;
import interfaces.impl.SimpleElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ActionsManager;
import utils.CustomFieldDecorator;

import java.util.List;

public class ActionsPage extends AbstractPage {

    @FindBy(css = ".thumbnail #draggable")
    private SimpleElement elementToBeDragAndDropped;

    @FindBy(css = ".thumbnail #droppable")
    private SimpleContainer containerToDropTo;

    @FindBy(css = "#double-click")
    private SimpleButton buttonToBeDoubleClicked;

    @FindBy(css = "#div-hover")
    private SimpleContainer containerWithHoverButtons;

    @FindBy(css = "[class='list-alert']")
    private SimpleButton linkToBeClicked;

    @FindBy(css = "[id='click-box']")
    private SimpleButton buttonToBeHold;

    private static final String TEXT_IN_CONTAINER_AFTER_DROP = "Dropped!";
    private static final String BACKGROUND_COLOR_IN_CONTAINER_AFTER_DROP = "background-color: rgb(244, 89, 80); height: 100%;";
    private static final String BACKGROUND_COLOR_IN_BUTTON_AFTER_DOUBLECLICK = "rgba(147, 203, 90, 1)";
    private static final String TEXT_IN_ALERT = "Well done you clicked on the link!";
    private static final String INITIAL_TEXT_IN_HOLDING_BUTTON = "Click and Hold!";
    private static final String TEXT_IN_BUTTON_WHILE_HOLDING = "Well done! keep holding that click now.....";
    private static final String TEXT_IN_HOLDING_BUTTON_AFTER_RELEASE = "Dont release me!!!";


    public ActionsPage(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    //==============================Methods==================================/

    @Step
    public void dragAndDropElement() {
        ActionsManager.dragElementFromTo(elementToBeDragAndDropped, containerToDropTo);
    }

    @Step
    public void doubleClickButton() {
        ActionsManager.doubleClickElement(buttonToBeDoubleClicked);
    }

    @Step
    private void clickAndHoldButton() {
        ActionsManager.clickAndHold(buttonToBeHold);
    }

    @Step
    private void releaseButton() {
        ActionsManager.releaseButton(buttonToBeHold);
    }

    @Step
    public void hoverOverDropdownAndClick() {
        List<ListItem> buttonsUponHovering = containerWithHoverButtons.findElementsInContainer("a");
        containerWithHoverButtons.findElementsInContainer("button").forEach(button -> {
            ActionsManager.hoverOverElement(button);
            buttonsUponHovering.forEach(link -> {
                if (link.getWrappedElement().isDisplayed()) {
                    link.getWrappedElement().click();
                    Alert alert = driver.switchTo().alert();
                    Assertions.assertEquals(alert.getText(), TEXT_IN_ALERT);
                    alert.dismiss();
                }
            });
        });
    }

    //==============================Checks==================================/

    @Step
    public void checkThatElementIsCorrectlyDragAndDropped() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(containerToDropTo.findElementsInContainer("b").get(0).getText(),
                        TEXT_IN_CONTAINER_AFTER_DROP),
                () -> Assertions.assertEquals(containerToDropTo.findElementsInContainer("p").get(0).getWrappedElement().getAttribute("style"),
                        BACKGROUND_COLOR_IN_CONTAINER_AFTER_DROP)
        );
    }

    @Step
    public void checkThatElementChangedItsColorAfterDoubleClick() {
        Assertions.assertEquals(buttonToBeDoubleClicked.getWrappedElement().getCssValue("background-color"),
                BACKGROUND_COLOR_IN_BUTTON_AFTER_DOUBLECLICK);
    }

    @Step
    public void checkTextWhileButtonIsHold() {
        Assertions.assertEquals(buttonToBeHold.getText(), INITIAL_TEXT_IN_HOLDING_BUTTON);
        clickAndHoldButton();
        Assertions.assertEquals(buttonToBeHold.getText(), TEXT_IN_BUTTON_WHILE_HOLDING);
        releaseButton();
        Assertions.assertEquals(buttonToBeHold.getText(), TEXT_IN_HOLDING_BUTTON_AFTER_RELEASE);
    }
}
