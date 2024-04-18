import core.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;



import java.util.HashMap;

public class HandleBorwserBhevaiour  extends BaseTest {


    @Test
    public void allowBlockNotifications() {

//        driver.get("https://webcamtests.com/");
//        WebElement testMyCam=driver.findElement(By.id("webcam-launcher"));
//        testMyCam.click();

         getDriver().get("https://whatmylocation.com/");
        // driver.findElement(By.cssSelector("input.c-toggle.js-example-toggle")).click();
        System.out.println("Testttt");

        System.out.println("dhdhhjdhjdj");
    }

}
    