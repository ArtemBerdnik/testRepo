package utils;

import base.TestContext;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JsManager {

    static JavascriptExecutor jsExec() {
        return (JavascriptExecutor) jsWaitDriver();
    }

    static WebDriver jsWaitDriver() {
        return TestContext.getWebDriverManager().getCurrentDriver().getWebDriver();
    }
}
