import base.BaseTest;
import base.TestContext;
import enums.Users;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pageobjects.HomePage;
import pageobjects.LoginPortalPage;

@Feature("Login page")
class LoginPageTest extends BaseTest {

    private HomePage homePage = PageFactory.initElements(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver(), HomePage.class);
    private LoginPortalPage loginPortalPage = PageFactory.initElements(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver(), LoginPortalPage.class);

    @Test
    @Description("Open a Login page and login with incorrect credentials")
    void loginWithIncorrectCredentials() {
        homePage.openLoginPortalPage();
        loginPortalPage.tryToLogin(Users.INCORRECT_USER);
        loginPortalPage.verifyLoginFailed();
    }
}
