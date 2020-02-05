package pageobjects;

import base.TestContext;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.JsActions;
import utils.LoggerManager;
import utils.TestUtils;

public class ButtonClicksPage extends AbstractPage{

    @FindBy(css = "#button1")
    private WebElement webElementButton;

    @FindBy(css = "#button2")
    private WebElement jsButton;

    @FindBy(css = "#button3")
    private WebElement actionButton;

    @FindBy(css = "[class='modal fade in show'] .modal-content")
    private WebElement modalWindowAfterClick;

    @FindBy(css = "[class='modal fade in show'] .modal-content p")
    private WebElement modalWindowBody;

    @FindBy(css = "[class='modal fade in show'] .modal-content ul li")
    private WebElement modalWindowBodyList;

    @FindBy(css = "[class='modal fade in show'] .close")
    private WebElement closeModalWindowButton;

    @FindBy(css = "[class='modal fade show']")
    private WebElement modalWindowWhichIsShown;

    private final String TEXT_IN_WEB_ELEMENT_POPUP = "Well done for successfully using the click() method!";
    private final String TEXT_IN_ACTION_ELEMENT_POPUP = "Advanced user interactions (API) has been developed to enable you to perform more complex interactions such as:";
    private final String TEXT_IN_JS_ELEMENT_POPUP = "We can use JavaScript code if all else fails! Remember always try to use the WebDriver Library method(s) first such as WebElement.click(). (The Selenium development team have spent allot of time developing WebDriver functions etc).";

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
        actions.click(actionButton)
                .build()
                .perform();
        LoggerManager.info("Action button is clicked");
    }

    @Step
    public void closeModalWindow() {
        TestUtils.waitForElementToBeClickable(closeModalWindowButton, 5);
        closeModalWindowButton.click();
        try {
            modalWindowWhichIsShown.click();
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
