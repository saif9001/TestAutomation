import core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonPractice extends BaseTest {
    
    
    @Test
    public void checkBoxAndRadioButton(){
         getDriver().get("https://demoqa.com/checkbox");
         WebElement homeCheckBox=getDriver().findElement(By.xpath("//span[text()='Home']//preceding-sibling::span[@class='rct-node-icon']//preceding-sibling::span//*[@class='rct-icon rct-icon-uncheck']"));
         homeCheckBox.click();
         System.out.println("Tttttt");
         WebElement deskTop=getDriver().findElement(By.xpath("//span[text()='Desktop']//preceding-sibling::span[@class='rct-node-icon']//preceding-sibling::span//*[@class='rct-icon rct-icon-check']"));
         WebElement document=getDriver().findElement(By.xpath("//span[text()='Documents']//preceding-sibling::span[@class='rct-node-icon']//preceding-sibling::span//*[@class='rct-icon rct-icon-check']"));
         WebElement downLoads=getDriver().findElement(By.xpath("//span[text()='Downloads']//preceding-sibling::span[@class='rct-node-icon']//preceding-sibling::span//*[@class='rct-icon rct-icon-check']"));
         WebElement homeCheckBox1=getDriver().findElement(By.xpath("//span[text()='Home']//preceding-sibling::span[@class='rct-node-icon']//preceding-sibling::span//*[@class='rct-icon rct-icon-check']"));
         
         String valuee=downLoads.getAttribute("class");
         Assert.assertEquals(true,homeCheckBox1.isDisplayed());
         Assert.assertEquals(true,deskTop.isDisplayed());
         Assert.assertEquals(true,document.isDisplayed());
         Assert.assertEquals(true,downLoads.isDisplayed());
         boolean checkselectedValue=downLoads.isSelected();
         System.out.println(checkselectedValue);
//        homeCheckBox1.click();
        
        System.out.println("Tttttt");
    }
}
