package pageobjects;

import interfaces.impl.SimpleButton;
import interfaces.impl.SimpleContainer;
import interfaces.impl.SimpleTextArea;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CustomFieldDecorator;
import utils.JsWaiter;
import utils.TestUtils;

public class AjaxLoaderPage extends AbstractPage {

    @FindBy(css = "#button1")
    private SimpleButton clickMeButton;

    @FindBy(css = ".modal-content")
    private SimpleContainer modalWindow;

    @FindBy(css = ".modal-content .modal-title")
    private SimpleTextArea modalTitle;

    @FindBy(css = ".modal-content .modal-body")
    private SimpleTextArea modalBody;

    @FindBy(css = ".modal-content [class='btn btn-default']")
    private SimpleButton closeButton;

    private final String MODAL_TITLE = "Well Done For Waiting....!!!";
    private final String MODAL_BODY = "The waiting game can be a tricky one; this exercise will hopefully improve your understandings of the various types of waits.";

    private JsWaiter waiter = new JsWaiter(10);

    public AjaxLoaderPage(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    //===================Methods==============================

    @Step
    public void clickClickMeButton() {
        waiter.waitAllActionsToBeCompleted();
        clickMeButton.click();
    }

    @Step
    public void clickCloseButton() {
        closeButton.click();
    }

    //===================Checks==============================

    @Step
    public void verifyTextInPopup() {
        TestUtils.waitForElementToBeVisible(modalWindow, 3);
        verifyTextInElement(modalTitle, MODAL_TITLE);
        verifyTextInElement(modalBody, MODAL_BODY);
    }

    @Step
    public void verifyModalWindowIsClosed() {
        TestUtils.waitForElementToBeInvisible(modalWindow, 3);
        Assertions.assertFalse(modalWindow.isDisplayed());
    }

}
