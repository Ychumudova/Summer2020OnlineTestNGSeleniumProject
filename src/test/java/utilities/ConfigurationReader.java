package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //custom configuration file and will provide access to values based on key names
    // we use to load custom .properties files
    private static Properties configFile;

    static {
        // execute only once. we want to load this file only once
        //how we can connect with the class:
        try {

            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            //checked exception = related to InputOutput exception

            configFile = new Properties();
            configFile.load(fileInputStream); // load exceprion handled with catch block
            fileInputStream.close();

        } catch (IOException e) {
            System.out.println("file was not loaded");
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){
        return configFile.getProperty(key);
    }
}
