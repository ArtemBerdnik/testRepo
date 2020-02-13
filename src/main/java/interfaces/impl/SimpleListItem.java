package interfaces.impl;

import interfaces.ListItem;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SimpleListItem extends SimpleElement implements ListItem {

    public SimpleListItem(WebElement element) {
        super(element);
    }

    @Override
    public List<ListItem> findElementsInContainer(String css) {
        return null;
    }
}
