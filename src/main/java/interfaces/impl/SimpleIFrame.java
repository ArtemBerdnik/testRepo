package interfaces.impl;

import interfaces.IFrame;
import org.openqa.selenium.WebElement;

public class SimpleIFrame extends SimpleElement implements IFrame {

    public SimpleIFrame(WebElement element) {
        super(element);
    }

    @Override
    public String getUrl() {
        return this.wrappedElement.getAttribute("src");
    }

}
