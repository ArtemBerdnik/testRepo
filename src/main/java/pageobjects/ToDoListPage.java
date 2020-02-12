package pageobjects;

import interfaces.ListItem;
import interfaces.impl.SimpleButton;
import interfaces.impl.SimpleTextInput;
import interfaces.impl.SimpleWebList;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CustomFieldDecorator;
import utils.LoggerManager;
import utils.TestUtils;

import static utils.ActionsManager.hoverOverElement;

public class ToDoListPage extends AbstractPage {

    @FindBy(css = "#plus-icon")
    private SimpleButton plusIcon;

    @FindBy(css = "[placeholder='Add new todo']")
    private SimpleTextInput addNewToDoItemInput;

    @FindBy(css = "#container ul li")
    private SimpleWebList toDoItems;

    @FindBy(css = "[class = 'fa fa-trash']")
    private SimpleButton trashIcon;

    public ToDoListPage(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    //================================Methods===================================//

    @Step
    public void addNewToDoItem(String item) {
        addNewToDoItemInput.specifyText(item);
        LoggerManager.info(String.format("The following todo item is set: %s", item));
    }

    @Step
    public void deleteToDoItem(String item) {
        ListItem todoToBeRemoved = toDoItems.getItems().stream()
                .filter(todo -> todo.getWrappedElement().getText().equals(item))
                .findFirst()
                .get();
        hoverOverElement(todoToBeRemoved.getWrappedElement());
        trashIcon.getWrappedElement().findElement(By.xpath(String.format("//*[contains(text(),'%s')]//../span", item))).click();
        TestUtils.waitForElementToBeInvisible(todoToBeRemoved, 3);
        LoggerManager.info(String.format("The following todo item is removed: %s", item));
    }

    //================================Checks===================================//

    @Step
    public void checkItemIsRemoved(String toDoItem) {
        Assertions.assertFalse(toDoItems.getItems().stream().anyMatch(item -> item.getText().equals(toDoItem)));
    }

}
