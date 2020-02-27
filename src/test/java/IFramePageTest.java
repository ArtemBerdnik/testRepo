import base.BaseTest;
import base.TestContext;
import org.junit.jupiter.api.Test;
import pageobjects.IFramePage;

public class IFramePageTest extends BaseTest {

   private IFramePage iFramePage = new IFramePage(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver());

    @Test
    void checkWhoAreWeSection() {
        homePage.openIFramePage();
        iFramePage.switchToIFrame();
        iFramePage.verifyWhoAreWeSection();
    }

    @Test
    void checkFindOutMoreButton() {
            homePage.openIFramePage();
            iFramePage.switchToIFrame();
            iFramePage.clickFindOutMoreButton();
            iFramePage.verifyModalWindow();
    }
}
