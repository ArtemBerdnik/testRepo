package interfaces.impl;

import interfaces.TextInput;
import org.openqa.selenium.WebElement;

public class SimpleTextInput extends SimpleElement implements TextInput {

    public SimpleTextInput(WebElement element) {super(element);}

    @Override
    public void specifyText(String text) {
        this.wrappedElement.sendKeys(text);
    }

    @Override
    public void clear() {
        this.wrappedElement.clear();
    }

    @Override
    public void clearAndSpecifyText(String text) {
        this.wrappedElement.clear();
        this.wrappedElement.sendKeys(text);
    }
}
