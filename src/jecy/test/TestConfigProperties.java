package jecy.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfigProperties {

    private static Properties readProperties(){
        Properties properties = new Properties();
        InputStream is = Object.class.getResourceAsStream("/resources/config.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static void main(String[] args) {
        Properties properties = readProperties();
        System.out.println("Test env=" + properties.get("env"));
        System.out.println("user=" + properties.get("user"));
        System.out.println("password=" + properties.get("password"));
    }
}
