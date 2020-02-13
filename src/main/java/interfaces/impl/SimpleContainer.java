package interfaces.impl;

import interfaces.Container;
import interfaces.ListItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SimpleContainer extends SimpleElement implements Container {

    public SimpleContainer(WebElement element) {
        super(element);
    }

    @Override
    public List<ListItem> findElementsInContainer(String css) {
        List<ListItem> items = new ArrayList<>();
        wrappedElement.findElements(By.cssSelector(css)).forEach(element -> items.add(new SimpleListItem(element)));
        return items;
    }

}
