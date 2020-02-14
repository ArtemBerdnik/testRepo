import base.BaseTest;
import base.TestContext;
import org.junit.jupiter.api.Test;
import pageobjects.ActionsPage;

public class ActionPageTest extends BaseTest {

    private ActionsPage actionsPage = new ActionsPage(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver());

    @Test
    void checkActionsInThePage() {
        homePage.openActionsPage();

        //Check drag and drop functionality
        actionsPage.dragAndDropElement();
        actionsPage.checkThatElementIsCorrectlyDragAndDropped();

        //Check doubleclick functionality
        actionsPage.doubleClickButton();
        actionsPage.checkThatElementChangedItsColorAfterDoubleClick();

        //Check hovering functionality
        actionsPage.hoverOverDropdownAndClick();

        //Check holding button text
        actionsPage.checkTextWhileButtonIsHold();
    }
}
