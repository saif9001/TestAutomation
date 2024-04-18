import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.beans.binding.ObjectExpression;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utilities.CommonUtilities;

import java.io.IOException;

public class LuanchDifferentBrowser {
    
    
    
    public static void main(String[] args) throws IOException {
        
//        LuanchDifferentBrowser luanchDifferentBrowser=new LuanchDifferentBrowser();
//        luanchDifferentBrowser.launchBrowsers("Firefox");
        
        
    }

    public void launchBrowsers(String browserTobeUsed) {

        if (browserTobeUsed.equalsIgnoreCase("Chrome")) {

          System.setProperty("webdriver.chrome.driver","D:\\Tax\\New folder dd\\chromedriver-win64\\chromedriver.exe");

           ChromeOptions chromeOptions=new ChromeOptions();
           chromeOptions.addArguments("--incognito");
           chromeOptions.addArguments("--window-size=800,600");
           WebDriver driver=new ChromeDriver(chromeOptions);
          // driver.manage().window().maximize();
            driver.get("https://github.com/mozilla/geckodriver/releases");
            System.out.println("Browser ran in headless mode");
            //         WebDriverManager.chromedriver().setup();
//          WebDriver driver=new ChromeDriver();
        }


            if (browserTobeUsed.equalsIgnoreCase("Firefox")) {

//          System.setProperty("webdriver.gecko.drive","D:\\firefox\\geckodriver.exe");
//          WebDriver driver=new FirefoxDriver();
//          driver.manage().window().maximize();
//          driver.get("https://github.com/mozilla/geckodriver/releases");
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions=new FirefoxOptions();
                firefoxOptions.addArguments("--private");
                firefoxOptions.addArguments("--width=800");
                firefoxOptions.addArguments("--height=600");
                firefoxOptions.addArguments("--disable-notifications");
                WebDriver driver = new FirefoxDriver(firefoxOptions);
                driver.get("https://github.com/mozilla/geckodriver/releases");
                System.out.println("Yest");

            }

            if (browserTobeUsed.equalsIgnoreCase("Edge")) {

                System.setProperty("webdriver.edge.driver", "D:\\Microsfrt_Edge\\msedgedriver.exe");
                WebDriver driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.get("https://github.com/mozilla/geckodriver/releases");
            }
        }
        
        

    }


