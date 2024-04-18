import core.BaseTest;
import core.ElementInteraction;
import core.SeleniumWaitManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class ToolQaWidget extends BaseTest {
    
    @Test
    public void readAccordians() throws InterruptedException {
        
        getDriver().get("https://demoqa.com/accordian");
        
        List<WebElement> accordians=getDriver().findElements(By.xpath("//div[@class='card-header']"));
        
        List<WebElement> accordiansText=getDriver().findElements(By.xpath("//div[@class='card-body']//p"));
        int i=0;
        for(WebElement accordianHeader: accordians){
            accordianHeader.click();
            System.out.println(accordianHeader.getText());
           System.out.println(accordiansText.get(i).getText());
           i++;
           Thread.sleep(3000);
            
        }
        
    }
    
    @Test
    public void handleAutomCompleteDropDown() throws InterruptedException {
        getDriver().get("https://demoqa.com/auto-complete");
        //div[@class='auto-complete__menu-list auto-complete__menu-list--is-multi css-11unzgr']//div
        WebElement autoCompleteDropDowntextField=getDriver().findElement(By.xpath("//div[@id='autoCompleteMultipleContainer']//div[@class='auto-complete__control css-yk16xz-control']"));
        SeleniumWaitManager seleniumWaitManager=new SeleniumWaitManager(getDriver());
        seleniumWaitManager.waitForElementToBeClickable(autoCompleteDropDowntextField,10);
        seleniumWaitManager.waitForElementToBeVisible(autoCompleteDropDowntextField,15);
        autoCompleteDropDowntextField.click();
//         autoCompleteDropDowntextField.sendKeys("G");
        ElementInteraction elementInteraction=new ElementInteraction(getDriver());
//        elementInteraction.sendKeyUsingJavaScriptExecutor(autoCompleteDropDowntextField,"G");
        Actions actions=new Actions(getDriver());
        actions.moveToElement(autoCompleteDropDowntextField).sendKeys("G").perform();
         List<WebElement> autoCompleteOptions=getDriver().findElements(By.xpath("//div[@class='auto-complete__menu-list auto-complete__menu-list--is-multi css-11unzgr']//div"));
        for(WebElement autocompleteoption: autoCompleteOptions){
            if(autocompleteoption.getText().equals("Indigo")){
                autocompleteoption.click();
                break;
            }
        }
        Thread.sleep(6000);
        List<WebElement>crossbuttons=getDriver().findElements(By.xpath("//div[@class='css-1rhbuit-multiValue auto-complete__multi-value']//div[@class='css-xb97g8 auto-complete__multi-value__remove']"));
        for(WebElement crossbutton: crossbuttons){
            crossbutton.click();
          break;
        }
        Thread.sleep(6000);
        
    }
    
    @Test
    public void handSlider() throws InterruptedException {
       getDriver().navigate().to("https://demoqa.com/slider");
       WebElement slideBar=getDriver().findElement(By.xpath("//*[@class='range-slider range-slider--primary']"));
       Actions actions=new Actions(getDriver());
        int minValue = 0; // Replace with actual minimum value
        int maxValue = 100; // Replace with actual maximum value

        // Set the desired value you want to slide to
        int desiredValue = 10; // Replace with the value you want to set

        // Calculate the percentage of the slider to move
        double percentageToMove = (double) (desiredValue - minValue) / (maxValue - minValue);

        // Calculate the offset based on the slider's width
        int xOffset = (int) (slideBar.getSize().getWidth() * percentageToMove);
        actions.clickAndHold(slideBar)
                .moveByOffset(xOffset, 0)
                .release()
                .perform();
        
        Thread.sleep(1000);
       
       
    }
    
    @Test
    public void handleToolTip() throws InterruptedException {
        getDriver().get("https://demoqa.com/tool-tips");
        WebElement buttonTooltip=getDriver().findElement(By.id("toolTipButton"));
        Actions actions=new Actions(getDriver());
       // actions.moveToElement(buttonTooltip).perform();
        WebElement tooltip=getDriver().findElement(By.xpath("//div[@class='tooltip-inner']"));
        System.out.println(tooltip.getText());
        
        Thread.sleep(1000);
        
    }
}
