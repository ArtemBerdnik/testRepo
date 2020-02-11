package interfaces.impl;

import interfaces.Button;
import org.openqa.selenium.*;

import java.util.List;

public class SimpleButton implements Button {

    protected WebElement wrappedElement;

    public SimpleButton(WebElement element) {
        this.wrappedElement = element;
    }

    @Override
    public String getText() {
        return wrappedElement.getText();
    }

    @Override
    public void click() {
        wrappedElement.click();
    }
}
