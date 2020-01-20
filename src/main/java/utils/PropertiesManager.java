package utils;

import enums.PropertiesResource;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.PropertyException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@NoArgsConstructor
public class PropertiesManager {

    @Getter(lazy = true)
    private static final PropertiesManager instance = new PropertiesManager();

    private String propertiesFile;
    private List<PropertiesResource> resources = new ArrayList<>();

    public PropertiesManager setPropertiesResource(PropertiesResource resource) {
        resources.add(resource);
        return this;
    }

    public PropertiesManager setPropertiesFile(String propertiesFile) {
        this.propertiesFile = propertiesFile;
        return this;
    }

    public String getProperty(String key) throws PropertyException {
        if (resources.isEmpty()) {
            throw new PropertyException("No one property was set");
        }

        Optional<String> optional = resources.stream().map(resource -> getProperty(resource, key))
                .filter(prop -> !prop.isEmpty())
                .findFirst();

        return optional.get();
    }

    private String getProperty(PropertiesResource resource, String key) {
        return getProperties(resource).getProperty(key, "");

    }

    private Properties getProperties(PropertiesResource resource) {
        switch (resource) {
            case SYSTEM:
                return getSystemProperties();
            case FILE:
                return getFileProperties();
            default:
                throw new RuntimeException(String.format("There is no a method that returns a Properties class based on '%s' resource", resource));
        }
    }

    private Properties getSystemProperties() {
        return System.getProperties();
    }

    private Properties getFileProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(propertiesFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

}
