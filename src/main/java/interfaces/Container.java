package interfaces;

import java.util.List;

public interface Container extends Element {

    List<ListItem> findElementsInContainer(String css);
}
