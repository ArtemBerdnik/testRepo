package pageobjects;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LoggerManager;
import utils.TestUtils;

import java.util.List;

import static utils.ActionsManager.hoverOverElement;
import static utils.ActionsManager.moveToElementAndClick;

public class ToDoListPage extends AbstractPage {

    @FindBy(css = "#plus-icon")
    private WebElement plusIcon;

    @FindBy(css = "[placeholder='Add new todo']")
    private WebElement addNewToDoItemInput;

    @FindBy(css = "#container ul li")
    private List<WebElement> toDoItems;

    @FindBy(css = "[class = 'fa fa-trash']")
    private WebElement trashIcon;

    //================================Methods===================================//

    @Step
    public void addNewToDoItem(String item) {
        addNewToDoItemInput.sendKeys(item);
        LoggerManager.info(String.format("The following todo item is set: %s", item));
    }

    @Step
    public void deleteToDoItem(String item) {
        WebElement todoToBeRemoved = toDoItems.stream()
                .filter(todo -> todo.getText().equals(item))
                .findFirst()
                .get();
        hoverOverElement(todoToBeRemoved);
        trashIcon.findElement(By.xpath(String.format("//*[contains(text(),'%s')]//../span", item))).click();
        TestUtils.waitForElementToBeInvisible(todoToBeRemoved, 3);
        LoggerManager.info(String.format("The following todo item is removed: %s", item));
    }

    //================================Checks===================================//

    @Step
    public void checkItemIsRemoved(String toDoItem) {
        Assertions.assertFalse(toDoItems.stream().anyMatch(item -> item.getText().equals(toDoItem)));
    }

}
