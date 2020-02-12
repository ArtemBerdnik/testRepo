package pageobjects;

import base.TestContext;
import interfaces.impl.SimpleButton;
import interfaces.impl.SimpleTextArea;
import interfaces.impl.SimpleTextInput;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CustomFieldDecorator;
import utils.LoggerManager;
import utils.TestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactUsPage extends AbstractPage {

    @FindBy(css = ".section_header")
    private SimpleTextArea pageHeader;

    @FindBy(css = "[name ='first_name']")
    private SimpleTextInput firstName;

    @FindBy(css = "[name ='last_name']")
    private SimpleTextInput lastName;

    @FindBy(css = "[name ='email']")
    private SimpleTextInput emailAddress;

    @FindBy(css = "[name ='message']")
    private SimpleTextInput message;

    @FindBy(css = "[type='reset']")
    private SimpleButton resetButton;

    @FindBy(css = "[type='submit']")
    private SimpleButton submitButton;

    @FindBy(css = "#contact_reply h1")
    private SimpleTextArea messageSuccessfullySent;

    private static final String ERROR_EMAIL_PAGE_URL = "http://webdriveruniversity.com/Contact-Us/contact_us.php";
    private static final String MESSAGE_ABOUT_SUCCESSFUL_SENDING = "Thank You for your Message!";

    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    //============================Methods===================================//

    @Step
    public void fillInForm(String fName, String lName, String email, String msg) {
        firstName.specifyText(fName);
        LoggerManager.info("First name is set");
        lastName.specifyText(lName);
        LoggerManager.info("Last name is set");
        emailAddress.specifyText(email);
        LoggerManager.info("Email address  is set");
        message.specifyText(msg);
        LoggerManager.info("Message is set");
    }

    @Step
    public void resetValues() {
        resetButton.click();
        LoggerManager.info("Reset button is clicked");
    }

    @Step
    public void submitForm() {
        submitButton.click();
        LoggerManager.info("Submit is clicked");
    }

    //============================Checks===================================//

    @Step
    public void verifyMessageAboutIncorrectEmail() {
        Assertions.assertEquals(ERROR_EMAIL_PAGE_URL,
                TestContext.getWebDriverManager().getCurrentDriver().getWebDriver().getCurrentUrl());
        TestUtils.takeScreenshot(driver);
    }

    @Step
    public void checkMessageWasSent() {
        Assertions.assertAll(
                () -> assertTrue(messageSuccessfullySent.isDisplayed()),
                () -> assertEquals(messageSuccessfullySent.getText(), MESSAGE_ABOUT_SUCCESSFUL_SENDING)
        );
        TestUtils.takeScreenshot(driver);
    }

    @Step
    public void checkValuesAreReset() {
        Assertions.assertAll(
                () -> assertTrue(firstName.getText().isEmpty()),
                () -> assertTrue(lastName.getText().isEmpty()),
                () -> assertTrue(emailAddress.getText().isEmpty()),
                () -> assertTrue(message.getText().isEmpty())
        );
        TestUtils.takeScreenshot(driver);
    }

}
