package interfaces.impl;

import interfaces.TextArea;
import org.openqa.selenium.WebElement;

public class SimpleTextArea extends SimpleElement implements TextArea {

    public SimpleTextArea(WebElement element) {
        super(element);
    }

}
