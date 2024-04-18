package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWaitManager {
    
    WebDriver driver;
    
    public SeleniumWaitManager(WebDriver driver){
        
        this.driver=driver;
    }
    
    public  WebElement waitForElementToBeClickable(WebElement webElement, int duration){

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
                
    }

    public  WebElement waitForElementToBeClickableUsingBy(By locator, int duration){

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));

    }
    
    public void waitForAlertToAppear(int duration){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.alertIsPresent());
        
    }
    
    public WebElement waitForElementToBeVisible(WebElement webElement, int duration){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
        return  wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    
    
}
