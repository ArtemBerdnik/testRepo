package utils;

import base.TestContext;
import interfaces.Element;
import interfaces.impl.SimpleButton;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class TestUtils {

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void clickAndSwitchToNewTab(WebDriver driver, SimpleButton newPageLink) {
        String oldTab = driver.getWindowHandle();
        String pageName = newPageLink.getText();
        newPageLink.click();
        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(0));
        driver.close();
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));
        takeScreenshot(driver);
        LoggerManager.info("Switched to a tab with " + pageName);
    }

    public static void waitForElementToBeClickable(Element element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver(), timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element.getWrappedElement()));
        LoggerManager.info(String.format("Wait for %s element for %d seconds", element.getText(), timeoutInSeconds));
    }

    public static void waitForElementToBeVisible(Element element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver(), timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element.getWrappedElement()));
        LoggerManager.info(String.format("Wait for %s element for %d seconds", element.getText(), timeoutInSeconds));
    }

    public static void waitForElementToBeInvisible(Element element, int timeoutInSeconds) {
        String elementName = element.getText();
        WebDriverWait wait = new WebDriverWait(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver(), timeoutInSeconds);
        wait.until(ExpectedConditions.invisibilityOf(element.getWrappedElement()));
        LoggerManager.info(String.format("Wait for %s element for %d seconds", elementName, timeoutInSeconds));
    }

    public static void waitForElementToHaveSpecificText(Element element, String text, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver(), timeoutInSeconds);
        wait.until(ExpectedConditions.textToBePresentInElement(element.getWrappedElement(), text));
        LoggerManager.info(String.format("Wait for %s element for %d seconds", element.getText(), timeoutInSeconds));
    }
}
