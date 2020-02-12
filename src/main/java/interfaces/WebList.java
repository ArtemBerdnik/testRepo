package interfaces;

import java.util.List;

public interface WebList {

    ListItem getItem(int index);

    List<ListItem> getItems();

    int size();
}
