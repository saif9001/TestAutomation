import core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigateCommand extends BaseTest {
    
    
    @Test
    public void navigationTest(){
        
        getDriver().get("https://toolsqa.com/selenium-webdriver/selenium-navigation-commands/");

        WebElement nextArticle=getDriver().findElement(By.xpath("//*[contains(text(),'Next Article')]"));

        Actions actions=new Actions(getDriver());
        actions.scrollToElement(nextArticle).perform();
        JavascriptExecutor js= (JavascriptExecutor)getDriver();
        
        js.executeScript("arguments[0].click();",nextArticle);
        
        getDriver().navigate().back();

        Assert.assertEquals("Saif","Sheez");
        getDriver().navigate().forward();
        
        
        System.out.println("First Part");
        
            
        }

}
