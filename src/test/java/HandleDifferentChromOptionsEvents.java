import core.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandleDifferentChromOptionsEvents extends BaseTest {
    
    
    @Test
    
    public void acceptBrowserNotification(){
        
        getDriver().get("https://www.justdial.com/");
        //driver.switchTo().alert().accept();
        getDriver().findElement(By.xpath("//div[text()='Hotels']")).click();
        System.out.println("Test");
        
        
    }
}



