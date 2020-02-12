package interfaces.impl;

import interfaces.ListItem;
import org.openqa.selenium.WebElement;

public class SimpleListItem extends SimpleElement implements ListItem {

    public SimpleListItem(WebElement element) {
        super(element);
    }


}
