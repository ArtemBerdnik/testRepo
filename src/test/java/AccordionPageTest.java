import base.BaseTest;
import base.TestContext;
import org.junit.jupiter.api.Test;
import pageobjects.AccordionPage;
import pageobjects.HomePage;

public class AccordionPageTest extends BaseTest {

    private HomePage homePage = new HomePage(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver());
    private AccordionPage accordionPage = new AccordionPage(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver());

    @Test
    void checkMessagesUnderAccordions() {
        homePage.openAccordionPage();

        accordionPage.clickManualAccordion();
        accordionPage.checkTextUnderManualAccordion();

        accordionPage.clickAutomationAccordion();
        accordionPage.checkTextUnderAutomationAccordion();

        accordionPage.clickCucumberAccordion();
        accordionPage.checkTextUnderCucumberAccordion();

        accordionPage.clickAccordionWithDelay();
        accordionPage.checkTextUnderClickingAccordion();
    }
}
