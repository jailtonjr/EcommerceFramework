package co.mercadolibre.framework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "src/test/resources/conf/general.properties";


    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("general.properties not found at " + propertyFilePath);
        }
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("Url is not defined into the property file.");
    }

    public int getTimeout() {
        String timeout = properties.getProperty("timeout");
        if (timeout != null) return Integer.parseInt(timeout);
        else throw new RuntimeException("Timeout is not defined into the property file.");
    }

    public long getSeconds() {
        String seconds = properties.getProperty("seconds");
        if (seconds != null) return Long.parseLong(seconds);
        else throw new RuntimeException("Seconds is not defined into the property file.");
    }

}