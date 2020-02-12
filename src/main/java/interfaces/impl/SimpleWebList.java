package interfaces.impl;

import interfaces.ListItem;
import interfaces.WebList;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SimpleWebList extends SimpleContainer implements WebList {

    public SimpleWebList(WebElement element) {
        super(element);
    }

    @Override
    public ListItem getItem(int index) {
        return getItems().get(index);
    }

    @Override
    public List<ListItem> getItems() {
        List<ListItem> webListItems = new ArrayList<>();
        this.findAllElements().forEach(element -> {
            webListItems.add(new SimpleListItem(element));
        });

        return webListItems;
    }

    @Override
    public int size() {
        return this.findAllElements().size();
    }
}
