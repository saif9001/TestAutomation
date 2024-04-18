import com.mongodb.operation.DropUserOperation;
import core.BaseTest;
import core.ElementInteraction;
import core.SeleniumWaitManager;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.http.HttpResponse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class ToolsQA extends BaseTest {

    public ToolsQA() throws IOException {
    }

    @Test(description = "Testing")
    public void testFields() throws InterruptedException {
        
        getDriver().navigate().to("https://demoqa.com/text-box");

        WebElement fullName= getDriver().findElement(By.xpath("//input[@placeholder='Full Name']"));
        WebElement email=getDriver().findElement(By.xpath("//input[@type='email']"));
        WebElement textArea=getDriver().findElement(By.id("permanentAddress"));
        
        fullName.sendKeys("Saif Sultan");
        email.sendKeys("saif@gmail.com");
        textArea.sendKeys("Text entered by Saif");
        Thread.sleep(20000);
        
    }
    
    
    @Test(description = "Handling the checkboxes")
    public void testHandleCheckbox() throws InterruptedException {
       
        getDriver().get("https://demoqa.com/checkbox");
        WebElement homeFolderToggleButton=getDriver().findElement(By.xpath("//label[@for='tree-node-home']//preceding-sibling::button[@class='rct-collapse rct-collapse-btn']"));
        
        homeFolderToggleButton.click();
        WebElement deskTopFolderToggleButton=getDriver().findElement(By.xpath("//label[@for='tree-node-desktop']//preceding-sibling::button[@class='rct-collapse rct-collapse-btn']"));
        deskTopFolderToggleButton.click();
        WebElement commandsCheckbox=getDriver().findElement(By.xpath("//input[@id='tree-node-commands']//following-sibling::span[@class='rct-checkbox']"));
        commandsCheckbox.click();
        Thread.sleep(10000);
    }
    
    @Test(description = "Print Values of all elements in the WebTable",groups={"webtables"})
    public void webTablesPrintAllElements(){

        getDriver().navigate().to("https://demoqa.com/webtables");
        List<WebElement> oddRows=getDriver().findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-tr -odd']"));
        List<WebElement> allElementOfTable=getDriver().findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-tr -odd']//div[@class='rt-td']"));
        
        for(WebElement ele:allElementOfTable){
            System.out.println(ele.getText());
        }
        
    }
    
    @Test(description = "Print All the Headers of WebTable",groups = {"webtables"})
    public void webTablesPrintAllTheHeaders(){
        getDriver().navigate().to("https://demoqa.com/webtables");
        
        List<WebElement> webTableHeaders=getDriver().findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']//div[@class='rt-resizable-header-content']"));
        
        for(WebElement header: webTableHeaders){
            System.out.println(header.getText());
        }
        
    }
    
    @Test(description = "HandleCLick")
    public void handlDifferentTypesOfClicks() throws InterruptedException {
        
        getDriver().get("https://demoqa.com/buttons");
        Actions actions=new Actions(getDriver());
        WebElement doubleClickButton=getDriver().findElement(By.id("doubleClickBtn"));
        WebElement rightCLickMe=getDriver().findElement(By.id("rightClickBtn"));
        WebElement singleClick=getDriver().findElement(By.xpath("//button[text()='Click Me']"));
        actions.doubleClick(doubleClickButton).perform();
        Thread.sleep(5000);
        actions.contextClick(rightCLickMe).perform();
        Thread.sleep(5000);
        JavascriptExecutor js= (JavascriptExecutor)getDriver();
        js.executeScript("arguments[0].click();", singleClick);
        Thread.sleep(5000);
    }
    
    @Test
    public void handleLinks(){
        
        getDriver().get("https://demoqa.com/links");
        WebElement homeLink=getDriver().findElement(By.linkText("Home"));
        String parentWindow=getDriver().getWindowHandle();
        homeLink.click();
        Set<String> allWindow=getDriver().getWindowHandles();
        for(String currentWindow: allWindow){
            if(!currentWindow.equals(parentWindow)){
                getDriver().switchTo().window(currentWindow);
                System.out.println(getDriver().getTitle()+ " ULR:"+ getDriver().getCurrentUrl());
                
            }
        }
        
        
    }
    
    @Test
    public void checkLinksStatus(){
        getDriver().get("https://demoqa.com/links");
        WebElement notFoundLink=getDriver().findElement(By.linkText("Not Found"));
        notFoundLink.click();
        
    }
    
    @Test
    public void findBrokenImagesAndLInks() throws IOException, InterruptedException {
        getDriver().get("https://demoqa.com/broken");
        WebElement brokenImage=getDriver().findElement(By.xpath("//p[text()='Broken image']//following-sibling::img"));

//        HttpClientBuilder httpClients= HttpClientBuilder.create();
//        HttpGet getRequest=new HttpGet(brokenImage.getAttribute("src"));
//        CloseableHttpResponse httpResponse=httpClients.build().execute(getRequest);
//        int status=httpResponse.getCode();
//        System.out.println(status);
      //  System.out.println(brokenImage.getAttribute("naturalWidth"));
        
//      System.out.println(brokenImage.getAttribute("src"));
      int response=getResponseCode(brokenImage.getAttribute("src"));
        ElementInteraction elementInteraction=new ElementInteraction(getDriver());
        
      System.out.println(response);
      
      Thread.sleep(10000);
      
        
        
        
    }
    
    @Test
    public void findBrokenLinks() throws IOException {
        
        getDriver().get("https://demoqa.com/broken");
        List<WebElement> brokenLinks=getDriver().findElements(By.tagName("a"));
        int totalBrokenLinks=0;
        for(WebElement currentLink: brokenLinks){
        
        if(currentLink.getAttribute("href")!=null && !currentLink.getAttribute("href").isEmpty()){
            int getResponseCode=getResponseCode(currentLink.getAttribute("href"));
                    if (getResponseCode >= 400) {
                        totalBrokenLinks++;
                        System.out.println("Broken Links are " + currentLink.getText());
                        
                        
                       
                    }
                }
        
        }

        System.out.println("Total Broken links on the current page are " +totalBrokenLinks);
        }
        
        
        @Test(description = "Uplaing the file",groups = {"Uplaod File"})
        public void uploadFile() throws InterruptedException {
        getDriver().get("https://demoqa.com/upload-download");
        WebElement uploadFile= getDriver().findElement(By.xpath("//input[@id='uploadFile']"));
        ElementInteraction elementInteraction=new ElementInteraction(getDriver());
        elementInteraction.sendKeys(uploadFile,"C:\\Users\\saifsultan\\Downloads\\1a5c91c5-9276-11ee-8fb0-0050568a6305.pdf");
        Thread.sleep(10000);
        
    }
    
    @Test(description = "Upload File using Robot Class")
    public void uploadFileUsingRobot() throws AWTException, InterruptedException {
        getDriver().get("https://demoqa.com/upload-download");
        WebElement uploadFile= getDriver().findElement(By.id("uploadFile"));
        ElementInteraction elementInteraction=new ElementInteraction(getDriver());
        
        Actions actions=new Actions(getDriver());
        actions.moveToElement(uploadFile).click().perform();
        

        StringSelection selection = new StringSelection("C:\\Users\\saifsultan\\Downloads\\1a5c91c5-9276-11ee-8fb0-0050568a6305.pdf"); // Replace with the actual file path
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
       // elementInteraction.clickUsingJavaScriptExecutor(uploadFile);

        Robot robot = new Robot();
        robot.delay(1000); // Delay for clipboard to be set
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(10000);
        
    }
    
    @Test
    public void handleAlerts() throws InterruptedException {
        getDriver().get("https://demoqa.com/alerts");
        WebElement triggernormalAlert=getDriver().findElement(By.id("alertButton"));
        WebElement triggerDelayedAlert=getDriver().findElement(By.id("timerAlertButton"));
        WebElement confirmBoxAlert=getDriver().findElement(By.id("confirmButton"));
        ElementInteraction elementInteraction=new ElementInteraction(getDriver());
        SeleniumWaitManager seleniumWaitManager=new SeleniumWaitManager(getDriver());
        elementInteraction.click(triggernormalAlert);
        System.out.println("Testinngg");
        getDriver().switchTo().alert().accept();
        Thread.sleep(5000);
        elementInteraction.click(triggerDelayedAlert);
        seleniumWaitManager.waitForAlertToAppear(10);
        System.out.println("Testinngg");
        getDriver().switchTo().alert().accept();
        confirmBoxAlert.click();
        getDriver().switchTo().alert().dismiss();
        WebElement cancelConfirmationtext=getDriver().findElement(By.xpath("//span[contains(normalize-space(),'You selected Cancel')] "));
        String actualtext=cancelConfirmationtext.getText();
        Assert.assertEquals(actualtext,"You selected Cancel");
        System.out.println(actualtext);
        Thread.sleep(10000);
    }
    
    @Test
    public void handleFrames() throws InterruptedException {
        getDriver().get("https://demoqa.com/frames");
        getDriver().switchTo().frame("frame1");
        WebElement frameOneText=getDriver().findElement(By.xpath("//h1[text()='This is a sample page']"));
        System.out.println(frameOneText.getText());
        Thread.sleep(6000);
        getDriver().switchTo().parentFrame();
        WebElement frameTwo=getDriver().findElement(By.id("frame2"));
        getDriver().switchTo().frame(frameTwo);
        WebElement frameTwoText=getDriver().findElement(By.xpath("//h1[text()='This is a sample page']"));
        System.out.println(frameTwoText.getText());
    }
    @Test
    public void handleNestedFrames(){
        

    }   
    
    @Test()
    public void handleMenuBar() throws InterruptedException {
        getDriver().get("https://demoqa.com/menu#");
        WebElement mainMenuItemtwo=getDriver().findElement(By.xpath("//a[text()='Main Item 2']"));
        WebElement subsublist=getDriver().findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
        WebElement subsubitem=getDriver().findElement(By.xpath("//a[text()='Sub Sub Item 1']"));
        Actions actions=new Actions(getDriver());
        actions.moveToElement(mainMenuItemtwo).perform();
        Thread.sleep(5000);
        actions.moveToElement(subsublist).perform();
        actions.moveToElement(subsubitem).perform();
        Thread.sleep(5000);
       
    }
   
    @Test(description = "Handle Select class", enabled = true,groups = {"select class"})
    public void handleSlectDropDowns() throws InterruptedException {
        getDriver().get("https://demoqa.com/select-menu");
        //WebElement seletValue=getDriver().findElement(By.className(" css-1uccc91-singleValue"));
      //  WebElement selectValuexpath=getDriver().findElement(By.xpath("//div[@class=' css-1uccc91-singleValue']"));
        WebElement dropdownSelect=getDriver().findElement(By.xpath("//div[@class=' css-yk16xz-control']//div[@class=' css-1hwfws3']"));
        dropdownSelect.click();
        WebElement selectvalueOption=getDriver().findElement(By.id("react-select-2-option-0-1"));
        selectvalueOption.click();
        
        Thread.sleep(6000);
        
        WebElement selectOneDropDown=getDriver().findElement(By.xpath("//div[@id='selectOne']//div[@class=' css-yk16xz-control']"));
        selectOneDropDown.click();
        WebElement option=getDriver().findElement(By.id("react-select-3-option-0-5"));
        JavascriptExecutor javascriptExecutor= (JavascriptExecutor)getDriver();
        javascriptExecutor.executeScript("window.scrollBy(0,100)");
        option.click();
        
        WebElement selectDropDown=getDriver().findElement(By.id("oldSelectMenu"));
        Select select=new Select(selectDropDown);
        select.selectByVisibleText("Green");
        
        
        select.selectByVisibleText("Red");
//        select.selectByValue("3");
//        select.selectByIndex(2);

        WebElement selectDropDownmulti=getDriver().findElement(By.id("cars"));
        Select seconddropdown=new Select(selectDropDownmulti);
        seconddropdown.selectByVisibleText("Volvo");
        seconddropdown.selectByVisibleText("Audi");
        Thread.sleep(6000);
    }
    
    @Test
    public void handleResizableBox() throws InterruptedException {
        getDriver().get("https://demoqa.com/resizable");
        WebElement resisablebox=getDriver().findElement(By.xpath("//div[text()='Resizable']//following-sibling::span[@class='react-resizable-handle react-resizable-handle-se']"));
        Actions actions=new Actions(getDriver());
        JavascriptExecutor js= (JavascriptExecutor)getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        actions.dragAndDropBy(resisablebox,500,200).perform();
        Thread.sleep(9000);
        
    }
    
    @Test
    public void dragAndDrop() throws InterruptedException {
        getDriver().get("https://demoqa.com/droppable");
        WebElement sourceElement=getDriver().findElement(By.xpath("//div[text()='Drag me']"));
        WebElement targetElement= getDriver().findElement(By.xpath("//div[text()='Drag me']//following-sibling::div[@id='droppable']"));
        Actions actions=new Actions(getDriver());
        actions.dragAndDrop(sourceElement,targetElement).perform();
        String s=targetElement.getCssValue("background-color");
        System.out.println(s);
        Thread.sleep(9000);
    }
        
    
    private static int getResponseCode(String urlString) throws IOException { 
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            connection.disconnect();
            return responseCode;
    }
    
    
}


  
 