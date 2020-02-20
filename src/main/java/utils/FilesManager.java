package utils;

import javax.xml.bind.PropertyException;

import static base.TestContext.getPropertiesManager;

public class FilesManager {

    public static String getFullPath(String path) {
        String fullPath;
        try {
            fullPath = System.getProperty("user.dir") + "/" + getPropertiesManager().getProperty("resource.path")  + path;
        } catch (PropertyException e) {
           LoggerManager.warn("No such property found");
           fullPath = "src/main/resources/files/";
        }
        return fullPath;
    }
}
