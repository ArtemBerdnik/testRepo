package interfaces.impl;

import base.TestContext;
import interfaces.Element;
import interfaces.ListItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Proxy;
import java.util.List;

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

    public boolean isDisplayed() {
        return wrappedElement.isDisplayed();
    }

    public List<WebElement> findAllElements() {
        String proxy = ((Proxy) wrappedElement).toString();
        String cssSelector = proxy.split("selector: ")[1].substring(0, proxy.split("selector: ")[1].length()-1);
        return TestContext.getWebDriverManager().getCurrentDriver().getWebDriver().findElements(By.cssSelector(cssSelector));
    }
}
