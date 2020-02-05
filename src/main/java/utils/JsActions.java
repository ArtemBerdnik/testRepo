package utils;

import lombok.NonNull;
import org.openqa.selenium.WebElement;

public class JsActions extends JsManager {

    public static void clickElement(@NonNull WebElement element) {
        jsExec().executeScript("arguments[0].click();", element);
    }
}
