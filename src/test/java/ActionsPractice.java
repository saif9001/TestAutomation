import core.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsPractice extends BaseTest {
    @BeforeTest
    public void befortest(){
        System.out.println("Before Test Print Action file");
    }

    @AfterTest
    public void aftertest(){
        System.out.println("After Test Print Action ");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite print action Action File");
    }

    @Test
    public void actionsPractice(){

       getDriver().navigate().to("https://www.browserstack.com/");

        WebElement clickButton=getDriver().findElement(By.xpath("//a[@id='signupModalProductButton']"));
        Actions actions=new Actions(getDriver());
        
        Actions actions1=new Actions(getDriver());
       
       
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.elementToBeClickable(clickButton));
        actions.click(clickButton).build().perform();
        
        System.out.println("Testingg");
    }
    
//    @Test
//    public void performHoverActionActions(){
//        driver.get("https://www.browserstack.com/guide/mouse-hover-in-selenium");
//        
//        WebElement product=driver.findElement(By.xpath("//*[@id='product-menu-toggle']"));
//        
//      //  WebElement prodcuttt=driver.findElement(By.cssSelector("button.product-dropdown-toggle.dropdown-toggle.hide-sm.hide-xs"));
//        
//        Actions actions=new Actions(driver);
//        
//        
//        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOf(product));
//        actions.moveToElement(product).build().perform();
//        System.out.println("Test");
//    }
//    
//    @Test
//    public void dragAndDropAction(){
//        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
//        WebElement sourceElement=driver.findElement(By.id("column-a"));
//        WebElement targetElement=driver.findElement(By.id("column-b"));
//        Actions actions=new Actions(driver);
////        actions.dragAndDrop(sourceElement,targetElement).build().perform();
////        System.out.println("Test");
////        actions.dragAndDrop(targetElement,sourceElement).build().perform();
////        System.out.println("Test");
//        
//        actions.clickAndHold(sourceElement).moveToElement(targetElement).release().build().perform();
//        System.out.println("Test");
//        
//    }
//
//    @Test
//    public void multipleAction() throws InterruptedException {
//        driver.get("https://demoqa.com/buttons");
//        //  WebElement emailORPhone=driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']"));
//        Actions actions=new Actions(driver);
//        //  Action actionobj= actions.click(emailORPhone).keyDown(Keys.SHIFT).sendKeys("test").keyUp(Keys.SHIFT).build();
//        WebElement doubleClickButton=driver.findElement(By.id("doubleClickBtn"));
//        WebElement rightClickButton=driver.findElement(By.id("rightClickBtn"));
//        actions.doubleClick(doubleClickButton).perform();
//        Thread.sleep(10000);
//        actions.contextClick(rightClickButton).perform();
//
//        System.out.println("Testttt");
//    }
}
