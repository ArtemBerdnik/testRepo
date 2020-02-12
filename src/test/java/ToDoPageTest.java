import base.BaseTest;
import base.TestContext;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.ToDoListPage;

public class ToDoPageTest extends BaseTest {

    private HomePage homePage = new HomePage(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver());
    private ToDoListPage toDoListPage = new ToDoListPage(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver());

    @Test
    void checkItemCanBeRemoved() {
        homePage.openToDoListPage();
        toDoListPage.deleteToDoItem("Buy new robes");
        toDoListPage.checkItemIsRemoved("Buy new robes");
    }

}
