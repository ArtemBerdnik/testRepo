package interfaces.impl;

import interfaces.Button;
import org.openqa.selenium.WebElement;

public class SimpleButton extends SimpleElement implements Button {

    public SimpleButton(WebElement element) {
        super(element);
    }

    @Override
    public void click() {
        wrappedElement.click();
    }
}
