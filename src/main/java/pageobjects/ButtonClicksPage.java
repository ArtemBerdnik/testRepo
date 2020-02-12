package pageobjects;

import base.TestContext;
import interfaces.impl.SimpleButton;
import interfaces.impl.SimpleContainer;
import interfaces.impl.SimpleTextArea;
import interfaces.impl.SimpleWebList;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CustomFieldDecorator;
import utils.JsActions;
import utils.LoggerManager;
import utils.TestUtils;

public class ButtonClicksPage extends AbstractPage{

    @FindBy(css = "#button1")
    private SimpleButton webElementButton;

    @FindBy(css = "#button2")
    private SimpleButton jsButton;

    @FindBy(css = "#button3")
    private SimpleButton actionButton;

    @FindBy(css = "[class='modal fade in show'] .modal-content")
    private SimpleContainer modalWindowAfterClick;

    @FindBy(css = "[class='modal fade in show'] .modal-content p")
    private SimpleTextArea modalWindowBody;

    @FindBy(css = "[class='modal fade in show'] .modal-content ul li")
    private SimpleWebList modalWindowBodyList;

    @FindBy(css = "[class='modal fade in show'] .close")
    private SimpleButton closeModalWindowButton;

    @FindBy(css = "[class='modal fade show']")
    private SimpleContainer modalWindowWhichIsShown;

    private final String TEXT_IN_WEB_ELEMENT_POPUP = "Well done for successfully using the click() method!";
    private final String TEXT_IN_ACTION_ELEMENT_POPUP = "Advanced user interactions (API) has been developed to enable you to perform more complex interactions such as:";
    private final String TEXT_IN_JS_ELEMENT_POPUP = "We can use JavaScript code if all else fails! Remember always try to use the WebDriver Library method(s) first such as WebElement.click(). (The Selenium development team have spent allot of time developing WebDriver functions etc).";

    public ButtonClicksPage(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }
    //================================Actions====================================//

    @Step
    public void clickWebElementButton() {
        TestUtils.waitForElementToBeClickable(webElementButton, 5);
        webElementButton.click();
        LoggerManager.info("Web Element button is clicked");
    }

    @Step
    public void clickJsButton() {
        TestUtils.waitForElementToBeClickable(jsButton, 5);
        JsActions.clickElement(jsButton);
        LoggerManager.info("Js button is clicked");
    }

    @Step
    public void clickActionButton() {
        Actions actions = new Actions(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver());
        TestUtils.waitForElementToBeClickable(actionButton, 5);
        actions.click(actionButton.getWrappedElement())
                .build()
                .perform();
        LoggerManager.info("Action button is clicked");
    }

    @Step
    public void closeModalWindow() {
        TestUtils.waitForElementToBeClickable(closeModalWindowButton, 5);
        closeModalWindowButton.click();
        try {
            modalWindowWhichIsShown.getWrappedElement().click();
        }
        catch (Exception e) {
            LoggerManager.warn("No modal window here. Skip this");
        }
        LoggerManager.info("Close modal window button is clicked");
    }

    //================================Checks====================================//

    @Step
    public void checkTextInWebElementButton() {
        verifyTextInElement(modalWindowBody, TEXT_IN_WEB_ELEMENT_POPUP);
    }

    @Step
    public void checkTextInJsElementButton() {
        verifyTextInElement(modalWindowBody, TEXT_IN_JS_ELEMENT_POPUP);
    }

    @Step
    public void checkTextInActionElementButton() {
        TestUtils.waitForElementToBeVisible(modalWindowBody, 60);
        verifyTextInElement(modalWindowBody, TEXT_IN_ACTION_ELEMENT_POPUP);
    }

}
