package core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    
    public static Properties appconfig;

    public static void loadConfig() throws IOException {
        appconfig=loadproperty("src/main/resources/config.properties");
        
    }
    
    private static Properties loadproperty(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }
    
    public static String getBrowser(){
        
      return appconfig.getProperty("browsertype");
    }
    
    public static String getProperty(String property){
        return appconfig.getProperty(property);
    }
}

