package pageobjects;

import enums.Users;
import interfaces.impl.SimpleButton;
import interfaces.impl.SimpleTextInput;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CustomFieldDecorator;
import utils.TestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPortalPage extends AbstractPage {

    @FindBy(css = "#text")
    private SimpleTextInput usernameField;

    @FindBy(css = "#password")
    private SimpleTextInput passwordField;

    @FindBy(css = "#login-button")
    private SimpleButton loginButton;

    private final String FAILED_LOGIN_MESSAGE = "validation failed";
    private final String FAILED_LOGIN_URL = "/fail.html";

    public LoginPortalPage(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }


    //=========================methods==========================//

    @Step
    public void tryToLogin(Users user) {
        usernameField.specifyText(user.getUsername());
        passwordField.specifyText(user.getPassword());
        loginButton.click();
    }

    //==========================checks===========================//

    @Step
    public void verifyLoginFailed() {
        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(), FAILED_LOGIN_MESSAGE);
        alert.dismiss();
        assertTrue(driver.getCurrentUrl().endsWith(FAILED_LOGIN_URL));
        TestUtils.takeScreenshot(driver);
    }
}
