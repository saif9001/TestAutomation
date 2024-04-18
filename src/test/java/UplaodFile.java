import core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class UplaodFile  extends BaseTest{
    

    
    @Test(groups = {"Smoke Test"})
 public void uploadFile(){
     
     
     getDriver().navigate().to("https://www.foundiseeker/registratzion");
     WebElement uploadResume=getDriver().findElement(By.xpath("//input[@type='file']"));
//     WebgetDriver()Wait wait=new WebgetDriver()Wait(getDriver(), Duration.ofSeconds(20));
//     wait.until(ExpectedConditions.elementToBeClickable(uploadResume));
     
     uploadResume.sendKeys("C:\\Users\\saifsultan\\Downloads\\Resume (3).pdf");
     System.out.println("Test");
     
     WebElement uploadedFileDetails=getDriver().findElement(By.xpath("//div[@class='f15']"));

     String uploadedFileNameDisplayed=uploadedFileDetails.getText();
     uploadedFileNameDisplayed= uploadedFileNameDisplayed.replaceAll("\\s", "");
     Assert.assertEquals("sss","jjj");
//     Assert.assertEquals(uploadedFileNameDisplayed,"Resume (3).pdf0.06MB");
 }  
 
// 
//    @Test(alwaysRun = true,groups = {"Test"})
//    public void scrollTestUsingJavaScript() throws InterruptedException {
//
//     getDriver().navigate().to("https://www.grammarly.com/plagiarism-checker");
//     JavascriptExecutor js= (JavascriptExecutor)getDriver();
//     js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
//        //js.executeScript("window.scrollBy(0,1500)", "");
////        WebElement scanbutton=getDriver().findElement(By.xpath("//b[text()='Scan for plagiarism']"));
////
////        js.executeScript("arguments[0].scrollIntoView(true);", scanbutton);
////        
//       System.out.println("Test 2");
////        
////        WebElement anotherButton=getDriver().findElement(By.xpath("//a[@class='headerItemLink_CLKm5yp3 headerItemTopLevel_CLKm5yp3 headerItemTopLevelBold_CLKm5yp3']"));
////        js.executeScript("arguments[0].scrollIntoView(true);", anotherButton);
//          Thread.sleep(10000);
//
//        js.executeScript("window.scrollTo(document.body.scrollHeight,0)","");
//
//        System.out.println("Testing");
// }
//
// @Test(groups = {"Test"})
//    public void scrollUsingSendKeys(){
//
//     getDriver().get("https://www.grammarly.com/plagiarism-checker");
//     Actions actions=new Actions(getDriver());
//     actions.sendKeys(Keys.PAGE_DOWN).build().perform();
//          Actions actions1=new Actions(getDriver());
//
//     System.out.println("Testttt");
// }
//
//
//
// @Test(dependsOnGroups = {"Test"})
//    public void scrollUsingActionClass(){
//
//     getDriver().get("https://www.grammarly.com/plagiarism-checker");
//     String pageTitle=getDriver().getTitle();
//     String pageSource=getDriver().getPageSource();
//     System.out.println("PageTitle:"+pageTitle);
//     System.out.println("PageTitle:"+pageSource);
//     WebElement scanButton=getDriver().findElement(By.xpath("//b[text()='Scan for plagiarism']"));
//     Actions actions=new Actions(getDriver());
//     actions.scrollToElement(scanButton).perform();
//     WebElement checkYourTextNow=getDriver().findElement(By.xpath("//b[contains(text(),'Check your text now')]"));
//     actions.scrollToElement(checkYourTextNow).perform();
//     System.out.println("Testtt");
//
//     actions.keyDown(Keys.CONTROL).perform();
// }

 
 
 
}
