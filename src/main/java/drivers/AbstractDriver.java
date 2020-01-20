package drivers;

import enums.Browser;
import org.openqa.selenium.WebDriver;
import lombok.NonNull;

public abstract class AbstractDriver {

    WebDriver webDriver;
    private Browser browser;

    AbstractDriver(Browser browser) {
        this.browser = browser;
    }

    public WebDriver getWebDriver() {
        if (!doesWebDriverExist()) {
            createWebDriver();
        }
        return webDriver;
    }

    protected void setWebDriver(@NonNull final WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected boolean doesWebDriverExist() {
        return webDriver != null;
    }

    protected abstract void createWebDriver();

    public void quitWebDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    public abstract void killWebDriverTasks();

    public void openPage(@NonNull String pageUrl) {
        getWebDriver().get(pageUrl);
    }

}
