package utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@UtilityClass
public class Config {
    private static final String CONFIG_FILE_PATH = "src/main/resources/framework.properties";
    private static final Properties PROPERTIES = new Properties();

    static {
        loadPropertyFile();
    }

    private static void loadPropertyFile() {
        try (FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE_PATH)) {
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file: %s".formatted(CONFIG_FILE_PATH), e);
        }
    }

    public static String getProperty(String key) {
        String value = PROPERTIES.getProperty(key);
        if (StringUtils.isBlank(value)) {
            throw new IllegalStateException("Configuration parameter '%s' not found in configuration file".formatted(key));
        }

        return value;
    }
}
