package interfaces.impl;

import interfaces.FileUploadInput;
import org.openqa.selenium.WebElement;

public class SimpleFileUploadInput extends SimpleElement implements FileUploadInput {

    public SimpleFileUploadInput(WebElement element) {
        super(element);
    }

    @Override
    public void uploadFile(String text) {
        this.wrappedElement.sendKeys(text);
    }

    @Override
    public void clear() {
        this.wrappedElement.clear();
    }
}
