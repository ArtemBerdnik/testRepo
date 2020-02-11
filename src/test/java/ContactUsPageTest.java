import base.BaseTest;
import base.TestContext;
import org.junit.jupiter.api.Test;
import pageobjects.ContactUsPage;
import pageobjects.HomePage;

import static enums.Users.CORRECT_USER;
import static enums.Users.INCORRECT_USER;

class ContactUsPageTest extends BaseTest {

    private ContactUsPage contactUsPage = new ContactUsPage(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver());
    private HomePage homePage = new HomePage(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver());


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
