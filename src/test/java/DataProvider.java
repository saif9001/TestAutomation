import com.fasterxml.jackson.databind.ser.Serializers;
import core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.CommonUtilities;

import java.time.Duration;

public class DataProvider extends BaseTest {
    
    
    @Test(dataProvider = "testData")
    public void dataProviderFacebookSignUp(String username, String lastName, String phoneNumber) throws InterruptedException {
        getDriver().get("https://www.facebook.com/");
        WebElement button= getDriver().findElement(By.cssSelector("._42ft._4jy0._6lti._4jy6._4jy2.selected._51sy"));
        button.click();
        WebElement userName=getDriver().findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-' and @aria-label='First name']"));
        WebElement passWord=getDriver().findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-' and @name='lastname']"));
        WebElement phoneNumbes=getDriver().findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-' and @type='text'and @name='reg_email__']"));
        userName.clear();
        userName.sendKeys(username);
        passWord.clear();
        passWord.sendKeys(lastName);
        phoneNumbes.clear();
        System.out.println("TestFormat");
    }
    
    @Test()
    @Parameters({"username","password"})
    public void enterCreds(String username, String password){
        getDriver().get("https://www.facebook.com/");
        String actualTitle=getDriver().getTitle();
        System.out.println(actualTitle);
        WebElement button= getDriver().findElement(By.cssSelector("._42ft._4jy0._6lti._4jy6._4jy2.selected._51sy"));
        button.click();
        WebElement userName=getDriver().findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-' and @aria-label='First name']"));
        WebElement passWord=getDriver().findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-' and @name='lastname']"));
        userName.clear();
        userName.sendKeys(username);
        passWord.clear();
        passWord.sendKeys(password);
        System.out.println("Testttt");
    }


   @Test(dataProvider = "readDataFromSheet")
    public void testOne(String userName, String passWord){

        getDriver().get("https://www.facebook.com/");
        System.out.println("Testtt");


    }

    @Test(dataProvider ="readDataFromSheet")
    public void testTwo(String firstName, String lastName, String phoneNumber) {

        getDriver().get("https://www.facebook.com/");
        System.out.println("Testtt");
    }

    @Test(enabled = false,priority = 1)
    public void name(){

    }
}
