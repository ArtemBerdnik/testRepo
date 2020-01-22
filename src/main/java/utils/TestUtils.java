package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class TestUtils {

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void clickAndSwitchToNewTab(WebDriver driver, WebElement newPageLink) {
        String oldTab = driver.getWindowHandle();
        String pageName = newPageLink.getText();
        newPageLink.click();
        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));
        takeScreenshot(driver);
        LoggerManager.info("Switched to a tab with " + pageName);
    }
}
