import base.BaseTest;
import base.TestContext;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pageobjects.ButtonClicksPage;
import pageobjects.HomePage;

class ButtonClicksTest extends BaseTest {

    private HomePage homePage = new HomePage(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver());
    private ButtonClicksPage buttonClicksPage = PageFactory.initElements(
            TestContext.getWebDriverManager().getCurrentDriver().getWebDriver(), ButtonClicksPage.class);

    @Test
    void clickButtonTest() {
        homePage.openButtonsClickPage();

        buttonClicksPage.clickActionButton();
        buttonClicksPage.checkTextInActionElementButton();
        buttonClicksPage.closeModalWindow();

        buttonClicksPage.clickWebElementButton();
        buttonClicksPage.checkTextInWebElementButton();
        buttonClicksPage.closeModalWindow();

        buttonClicksPage.clickJsButton();
        buttonClicksPage.checkTextInJsElementButton();
        buttonClicksPage.closeModalWindow();

    }
}
