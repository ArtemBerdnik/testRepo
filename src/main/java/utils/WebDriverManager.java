package utils;

import drivers.AbstractDriver;
import drivers.ChromeDriver;
import enums.Browser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

@NoArgsConstructor
public class WebDriverManager {

    private Browser browser;
    private AbstractDriver currentDriver;

    @Getter(lazy = true)
    private static final WebDriverManager instance = new WebDriverManager();

    private Map<Browser, Class<? extends AbstractDriver>> drivers;

    {
        Map<Browser, Class<? extends AbstractDriver>> temp = new EnumMap<>(Browser.class);
        temp.put(Browser.CHROME, ChromeDriver.class);
//        temp.put(Browser.FIREFOX, FirefoxDriver.class);
//        temp.put(Browser.EDGE, EdgeDriver.class);
        drivers = Collections.unmodifiableMap(temp);
    }

    public AbstractDriver getCurrentDriver() {
        if (currentDriver == null) {
            throw new RuntimeException("Webdriver was not set");
        }
        return currentDriver;
    }

    public WebDriverManager setCurrentDriver() {
        currentDriver = getWebDriver(Objects.requireNonNull(browser));
        return this;
    }

    public WebDriverManager setCurrentDriver(@NonNull Browser browser) {
        setBrowser(browser);
        setCurrentDriver();
        return this;
    }

    public WebDriverManager setBrowser(@NonNull Browser browser) {
        this.browser = browser;
        return this;
    }

    public Browser getBrowser() {
        return browser;
    }

    private AbstractDriver getWebDriver(@NonNull Browser browser) {
        if (!drivers.containsKey(browser)) {
            throw new NoSuchElementException("There's no driver for " + browser);
        }
        Class<? extends AbstractDriver> webDriverClass = drivers.get(browser);
        try {
            return webDriverClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroyCurrentWebDriver() {
        getCurrentDriver().quitWebDriver();
        getCurrentDriver().killWebDriverTasks();
    }
}
