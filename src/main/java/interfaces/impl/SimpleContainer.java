package interfaces.impl;

import interfaces.Container;
import org.openqa.selenium.WebElement;

public class SimpleContainer extends SimpleElement implements Container {

    public SimpleContainer(WebElement element) {
        super(element);
    }

}
