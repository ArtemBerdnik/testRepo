package utils;

import interfaces.Element;
import lombok.NonNull;

public class JsActions extends JsManager {

    public static void clickElement(@NonNull Element element) {
        jsExec().executeScript("arguments[0].click();", element.getWrappedElement());
    }
}
