import base.BaseTest;
import base.TestContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pageobjects.ContactUsPage;
import pageobjects.HomePage;

import static enums.Users.CORRECT_USER;
import static enums.Users.INCORRECT_USER;

class ContactUsPageTest extends BaseTest {

    private ContactUsPage contactUsPage = PageFactory.initElements(TestContext.getWebDriverManager()
            .getCurrentDriver().getWebDriver(), ContactUsPage.class);
    private HomePage homePage = PageFactory.initElements(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver(),
            HomePage.class);

//    @AfterEach
//    void afterEach() {
//        TestContext.getWebDriverManager().getCurrentDriver().getWebDriver().close();
//    }

    @Test
    void checkInvalidEmailCase() {
        homePage.openContactUsPage();
        contactUsPage.fillInForm(INCORRECT_USER.getFirstName(), INCORRECT_USER.getLastName(),
                INCORRECT_USER.getEmail(), "Test message");
        contactUsPage.submitForm();
        contactUsPage.verifyMessageAboutIncorrectEmail();
    }

    @Test
    void checkSuccessfulMessageSending() {
        homePage.openContactUsPage();
        contactUsPage.fillInForm(CORRECT_USER.getFirstName(), CORRECT_USER.getLastName(),
                CORRECT_USER.getEmail(), "Test message");
        contactUsPage.submitForm();
        contactUsPage.checkMessageWasSent();
    }

    @Test
    void checkResetButtonFunctionality() {
        homePage.openContactUsPage();
        contactUsPage.fillInForm(CORRECT_USER.getFirstName(), CORRECT_USER.getLastName(),
                CORRECT_USER.getEmail(), "Test message");
        contactUsPage.resetValues();
        contactUsPage.checkValuesAreReset();
    }
}
