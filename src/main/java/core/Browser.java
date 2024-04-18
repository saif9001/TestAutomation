package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.openqa.selenium.remote.DesiredCapabilities.*;

public class Browser {

    public WebDriver driver;
   
    
   
    
    public WebDriver getDriver(String browserType){
       
       if (browserType.equals("chrome")) {
          
           WebDriverManager.chromedriver().setup();
             
//             WebDriverManager.chromedriver().create()
//           ChromeOptions op = new ChromeOptions();
//           op.addArguments("window-size=500,250");
//           DesiredCapabilities chrome = DesiredCapabilities.chromedriver();
//           chrome.setCapability(ChromeOptions.CAPABILITY, op);
          //driver= WebDriverManager.chromedriver().avoidBrowserDetection().create();
           //ChromeOptions options = new ChromeOptions();
         //  options.addArguments("incognito");
        //   options.addArguments("incognito");
         //  options.addArguments("start-maximized");
        //   options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
         //  options.add nts("--ignore-ssl-errors=yes");
         //  options.addArguments("--ignore-certificate-errors");
        //  options.setAcceptInsecureCerts(true);
//           System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
//          driver=new ChromeDriver(options);
//           
         //  WebDriverManager.chromedriver().setup();
//         DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
//          desiredCapabilities.setCapability(ChromeOptions.CAPABILITY,options);
//           ChromeOptions chromeOptions=new ChromeOptions();
//           HashMap<String,Integer> contentSetting=new HashMap<String,Integer>();
//           HashMap<String,Object> profile=new HashMap<String,Object>();
//           HashMap<String,Object> prefs=new HashMap<String,Object>();
//           contentSetting.put("media_stream", 2);
//           profile.put("managed_default_content_settings",contentSetting);
//           prefs.put("profile",profile);
//          // chromeOptions.addArguments("--disable-notifications");
//           chromeOptions.addArguments("--disable-notifications");
          
          // chromeOptions.setExperimentalOption("prefs",prefs);
//            
         // chromeOptions.addArguments("--disable-notifications");
           driver=new ChromeDriver();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
           
          //driver= WebDriverManager.chromedriver().capabilities(options).create();;
        }
        
        else if (browserType.equals("firefox")){
            driver=  WebDriverManager.firefoxdriver().create();
        }
        else {
           driver=new ChromeDriver();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));   
       }
        return driver; 
    }
}
