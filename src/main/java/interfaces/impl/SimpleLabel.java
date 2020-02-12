package interfaces.impl;

import interfaces.Label;
import org.openqa.selenium.WebElement;

public class SimpleLabel extends SimpleElement implements Label {

    public SimpleLabel(WebElement element) {
        super(element);
    }

}
