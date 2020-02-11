import base.BaseTest;
import base.TestContext;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pageobjects.HomePage;
import pageobjects.ToDoListPage;

public class ToDoPageTest extends BaseTest {

    private HomePage homePage = new HomePage(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver());
    private ToDoListPage toDoListPage = PageFactory.initElements(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver(), ToDoListPage.class);

    @Test
    public void checkItemCanBeRemoved() {
        homePage.openToDoListPage();
        toDoListPage.deleteToDoItem("Buy new robes");
        toDoListPage.checkItemIsRemoved("Buy new robes");
    }

}
