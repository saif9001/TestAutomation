package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementInteraction {
    WebDriver driver;
    
    
    
    public ElementInteraction(WebDriver driver){

        this.driver=driver;
    }
    
    //navigate to url
    
    public void navigateTo(String url){
        driver.navigate().to(url);
    }
    
    public void sendKeys(WebElement webElement,String value){
        webElement.sendKeys(value);
        
    }
    
    public void cleartextFields(WebElement webElement){
        webElement.clear();
    }
    
    public  String getAttribute(WebElement webElement,String attribute){
       return webElement.getAttribute(attribute);
       
      
    }
    
    public String getPageTitle(){
      return driver.getTitle();
        
    }
    
    public String getText(WebElement webElement){
       return webElement.getText();
       
    }
    
    public void clickUsingJavaScriptExecutor(WebElement weblement){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",weblement);
    }
    
    public void sendKeyUsingJavaScriptExecutor(WebElement webElement,String values){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].value='"+values+"';",webElement);
    }
    
    public void click(WebElement webElement){
        webElement.click();
        
    }
    
    
    
}
