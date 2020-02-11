import base.BaseTest;
import base.TestContext;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;

@Feature("Home Page")
class HomePageTest extends BaseTest {

    private HomePage homePage = new HomePage(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver());

    @Test
    @Description("Check names for elements on Home page")
    void verifyTextForElementsOnHomePage() {
        homePage.verifyTextForContactUsSection();
        homePage.verifyTextForLoginFormSection();
    }
}
