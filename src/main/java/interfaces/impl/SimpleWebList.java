package interfaces.impl;

import interfaces.ListItem;
import interfaces.WebList;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SimpleWebList extends SimpleContainer implements WebList {
//TODO add implementation
    public SimpleWebList(WebElement element) {
        super(element);
    }

    @Override
    public ListItem getItem(int index) {
        return null;
    }

    @Override
    public List<ListItem> getItems() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
