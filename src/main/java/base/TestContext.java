package base;

import lombok.Getter;
import utils.PropertiesManager;
import utils.WebDriverManager;

public class TestContext {

    @Getter(lazy =  true)
    private static final PropertiesManager propertiesManager = PropertiesManager.getInstance();

    @Getter(lazy =  true)
    private static final WebDriverManager webDriverManager = WebDriverManager.getInstance();

}
