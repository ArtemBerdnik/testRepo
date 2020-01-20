package drivers;

import enums.Browser;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.RunTimeTasksManager;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ChromeDriver extends AbstractDriver {

    private static final String WEBDRIVER_PROPERTY_NAME = "webdriver.chrome.driver";

    public ChromeDriver() {
        this(Browser.CHROME);
    }

    private ChromeDriver(Browser browser) {
        super(browser);
    }

    @Override
    protected void createWebDriver() {
        final ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        final String driverPath = Objects.requireNonNull(
                getClass().getClassLoader().getResource("webdrivers/chromedriver.exe")).getPath();
        System.setProperty(WEBDRIVER_PROPERTY_NAME, driverPath);
        webDriver = new org.openqa.selenium.chrome.ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Override
    public void killWebDriverTasks() {
        try {
            RunTimeTasksManager.killTasks(Collections.singletonList("taskkill /F /IM chromedriver.exe"));
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
