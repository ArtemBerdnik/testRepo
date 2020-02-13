import base.BaseTest;
import base.TestContext;
import org.junit.jupiter.api.Test;
import pageobjects.AjaxLoaderPage;

public class AjaxLoadetTest extends BaseTest {

    private AjaxLoaderPage ajaxLoaderPage = new AjaxLoaderPage(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver());

    @Test
    void verifyClickButtonTest() {
        homePage.openAjaxLoaderPage();
        ajaxLoaderPage.clickClickMeButton();
        ajaxLoaderPage.verifyTextInPopup();
        ajaxLoaderPage.clickCloseButton();
        ajaxLoaderPage.verifyModalWindowIsClosed();
    }
}
