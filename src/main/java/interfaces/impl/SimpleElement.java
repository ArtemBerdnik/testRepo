package interfaces.impl;

import interfaces.Element;
import org.openqa.selenium.WebElement;

public class SimpleElement implements Element {

    protected WebElement wrappedElement;

    public SimpleElement(WebElement element) {
        this.wrappedElement = element;
    }

    @Override
    public String getText() {
        return wrappedElement.getText();
    }

    @Override
    public WebElement getWrappedElement() {
        return wrappedElement;
    }
}
