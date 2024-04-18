import core.BaseTest;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import java.awt.*;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Listeners(listeners.Listenerss.class)

public class HeroKuAppTestingPractice extends BaseTest {
    
    
    @Test
    
    public void basicAuthTest() throws InterruptedException {
        //Format of  the url should be https://username:password@url
        String username="admin";
        String password="admin";
        String url="https://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth";
        getDriver().get(url);
        Thread.sleep(10000);
       System.out.println("test"+username);
    }
    
    
    @Test()
    public void findBrokenImages() throws IOException {
        
        getDriver().get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> images= getDriver().findElements(By.tagName("img"));
       
       for(WebElement img: images){

           CloseableHttpClient client = HttpClientBuilder.create().build();
           HttpGet request = new HttpGet(img.getAttribute("src"));
           HttpResponse response = client.execute(request);
           if(response.getCode()!=200){
               System.out.println("Broken Image"+img.getAttribute("outerHTML"));
           }
           
           
       }
       
    }
    
    @Test
    public void findBrokenImagesUsingSizeAttribute(){
        getDriver().get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> images= getDriver().findElements(By.tagName("img"));
        
        for(WebElement img: images){
            if(img.getAttribute("naturalWidth").equals("0")){
                
                System.out.println("Broken Image Details:" + img.getAttribute("outerHTML"));
            }
        }
    }
    
    @Test()
    public void handleCheckBox(){
        getDriver().get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkboxOne=getDriver().findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkboxTwo=getDriver().findElement(By.xpath("//input[@type='checkbox'][2]"));
        Assert.assertTrue(false);
        checkboxOne.click();
        Boolean b=checkboxOne.isSelected();
        System.out.println(b);
        checkboxTwo.click();
        Boolean c=checkboxTwo.isSelected();
        System.out.println(c);
        
    }
    
    @Test
    public void testContextMenu(){
        
        getDriver().navigate().to("https://the-internet.herokuapp.com/context_menu");
        WebElement contextElement=getDriver().findElement(By.id("hot-spot"));
        Actions actions=new Actions(getDriver());
        Assert.assertTrue(false);
        actions.contextClick(contextElement).build().perform();
        getDriver().switchTo().alert().accept();
        System.out.println("Testttt");
    }
    
    
    @Test
    public void handleDigestAuth(){
       //Note both the basic auth and digest auth can be handled in the same way
        //Credentials are passed in the url itself, format: https://username:password@url
       String username="admin";
       String password="admin";
       String url="https://"+username+":"+password+"@the-internet.herokuapp.com/digest_auth";
       getDriver().get(url);
       Assert.assertTrue(false);
       System.out.println("Testttt");
        
    }
    
    @Test()
    public void handleDisappearingElement(){
        getDriver().get("https://the-internet.herokuapp.com/disappearing_elements");
        
        WebDriverWait webDriverWait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//a[text()='Gallery']"))));
        }
        catch (Exception e){
            getDriver().navigate().refresh();
        }

        Assert.assertTrue(false);
         
            getDriver().findElement(By.xpath("//a[text()='Gallery']")).click();
            System.out.println("Testttt");
    }
    
    @Test
    public void handleDropDown(){
        
        getDriver().get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDown=getDriver().findElement(By.xpath("//select[@id='dropdown']"));
        Select selectdropdown=new Select(dropDown);
       // selectdropdown.selectByVisibleText("Option 1");
      // selectdropdown.selectByValue("2");
        selectdropdown.selectByIndex(2);
        System.out.println("Testtt");
    }
    
    @Test
    public void handleDynamicControls(){
        getDriver().get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement enableButton=getDriver().findElement(By.xpath("//*[text()='Enable']"));
        WebElement textfield=getDriver().findElement(By.xpath("//*[@type='text']"));
        enableButton.click();
        WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(20));
         wait.until(ExpectedConditions.elementToBeClickable(textfield));
        textfield.sendKeys("Handled Dynamic Element");
        
        System.out.println("Yestttt");
        
        WebElement checkBox=getDriver().findElement(By.xpath("//*[@id='checkbox']//input"));
        checkBox.click();
        WebElement removeButton=getDriver().findElement(By.xpath("//*[text()='Remove']"));
     //   removeButton.click();
        Boolean checkenabled=true;
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='checkbox']//input")));
        }
        catch (Exception e){
            checkenabled=false;
        }
        System.out.println("Button got disbaled");
        
    }
    
    
    @Test
    public void handleDynamicElementTwo(){
        
        getDriver().get("https://the-internet.herokuapp.com/dynamic_loading");
      // WebElement helloWorld=getDriver().findElement(By.xpath("//*[text()='Hello World!']"));
        WebElement linkTwo=getDriver().findElement(By.linkText("Example 1: Element on page that is hidden"));
        linkTwo.click();
        WebElement startButton=getDriver().findElement(By.xpath("//button[text()='Start']"));
        startButton.click();
        
       WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(20));
         WebElement helloWorld= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Hello World!']")));
        System.out.println(getDriver().findElement(By.xpath("//*[text()='Hello World!']")).getText());
        System.out.println("Testtttt");
        
    }
    
    @Test
    public void entryAdd(){
        getDriver().get("https://the-internet.herokuapp.com/entry_ad");
        WebElement closeButton=getDriver().findElement(By.xpath("//*[text()='Close']"));
        WebDriverWait  wait=new WebDriverWait(getDriver(),Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(closeButton));
        closeButton.click();
        System.out.println("Testttt");
        
    }
    
    @Test
    public void movetheCursorOutSideScreen() throws AWTException {
        getDriver().get("https://the-internet.herokuapp.com/exit_intent");
//        Actions actions=new Actions(getDriver());
//        actions.moveByOffset(600, -1).build().perform();
        Robot robot = new Robot();
        robot.mouseMove(600,0);
        System.out.println("Testttt");
    }
    
    @Test
    public void uploadFile(){
        getDriver().get("https://the-internet.herokuapp.com/upload");
        WebElement uploadFile=getDriver().findElement(By.xpath("//input[@id='file-upload']"));
        uploadFile.sendKeys("C:\\Users\\saifsultan\\Downloads\\image (7).png");
        System.out.println("Testttttt");
        WebElement uploadButton=getDriver().findElement(By.xpath("//input[@id='file-submit']"));
        uploadButton.click();
        System.out.println("Testttttt");
    }
    
    @Test
    public void handleiFrame(){
        getDriver().get("https://the-internet.herokuapp.com/iframe");
        
        getDriver().switchTo().frame("mce_0_ifr");
        
        WebElement textfield =getDriver().findElement(By.id("tinymce"));
        textfield.clear();
        textfield.sendKeys("Handle frame successfully");
        System.out.println("Tetstttt");
        
    }
    
    
    @Test
    public void handleNestedFrames(){
        getDriver().get("https://the-internet.herokuapp.com/nested_frames");
        getDriver().switchTo().frame("frame-top");
        getDriver().switchTo().frame("frame-left");
        WebElement findLeftText=getDriver().findElement(By.xpath("//body[normalize-space(text())='LEFT']"));
        System.out.println(findLeftText.getText());
        System.out.println("Yttttt");
        getDriver().switchTo().parentFrame();
        getDriver().switchTo().frame("frame-right");
        WebElement findRightText=getDriver().findElement(By.xpath("//body[normalize-space(text())='RIGHT']"));
        System.out.println(findRightText.getText());
        getDriver().switchTo().parentFrame();
        getDriver().switchTo().parentFrame();
        getDriver().switchTo().frame("frame-bottom");
        WebElement findBottomText=getDriver().findElement(By.xpath("//body[normalize-space(text())='BOTTOM']"));
        System.out.println(findBottomText.getText());
        System.out.println("Yttttt");
        Actions actions=new Actions(getDriver());
    }
    
    
    @Test
    public  void handleHorizontalSlider(){
        getDriver().get("https://the-internet.herokuapp.com/horizontal_slider");
        System.out.println("Testt");
       // WebElement location=getDriver().findElement(By.xpath("//span[text()='3']"));
      //  System.out.println(location.getLocation());
        WebElement sliderElement=getDriver().findElement(By.xpath("//div[@class='sliderContainer']//input"));
//        Actions actions=new Actions(getDriver());
//        actions.dragAndDropBy(sliderElement,320,166).perform();
//        System.out.println("Tetsttt");
        //sliderElement.click();
//         sliderElement.sendKeys(Keys.ARROW_RIGHT);
//         sliderElement.sendKeys(Keys.ARROW_RIGHT);
//         System.out.println("Testtt");
        Actions actions=new Actions(getDriver());
        actions.keyDown(sliderElement,Keys.ARROW_RIGHT).perform();
        System.out.println("Testtt");
        
    }
    
    @Test
    public void hoverActions(){
        getDriver().get("https://the-internet.herokuapp.com/hovers");
        WebElement firstImage=getDriver().findElement(By.xpath("//h5[text()='name: user1']//parent::div//preceding-sibling::img[@src='/img/avatar-blank.jpg']"));
        Actions actions=new Actions(getDriver());
        actions.moveToElement(firstImage).perform();
        WebElement viewProfileFirstImage=getDriver().findElement(By.xpath("//h5[text()='name: user1']//following-sibling::a[text()='View profile']"));
        viewProfileFirstImage.click();
        System.out.println("Testinng");
    }
    
    @Test
    public void handleInfiniteScroll() {
        getDriver().get("https://the-internet.herokuapp.com/infinite_scroll");
        int i = 1;
        while (i < 100000) {
            System.out.println("Test");
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            System.out.println("Testtttt");
            i++;
        }
    }
    
    @Test
    public void handleJqueryMenu(){
        getDriver().get("https://the-internet.herokuapp.com/jqueryui/menu#");
        WebElement enabled=getDriver().findElement(By.xpath("//a[contains(text(),'Enabled')]"));
         Actions actions=new Actions(getDriver());
         actions.moveToElement(enabled).perform();
         actions.release();
         System.out.println("Testtttt");
        WebElement download=getDriver().findElement(By.xpath("//a[contains(text(),'Downloads')]"));
       WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(download));
        actions.moveToElement(download).perform();
        actions.release();
        WebElement downloadPDF=getDriver().findElement(By.xpath("//a[contains(text(),'PDF')]"));
        wait.until(ExpectedConditions.elementToBeClickable(downloadPDF));
        actions.click(downloadPDF).perform();
        System.out.println("Testtttt");
    }
    
    
    @Test
    public void handleOnLoadJSEventError() throws IOException {
        getDriver().get("https://the-internet.herokuapp.com/javascript_error");
        System.out.println("Testtt");
//        Set<String> logtyp = getDriver().manage().logs().getAvailableLogTypes();
//        for (String s : logtyp) {
//            System.out.println(logtyp);
//        }
        LogEntries logEntries = getDriver().manage().logs().get(LogType.BROWSER);
        List<org.openqa.selenium.logging.LogEntry> lg = logEntries.getAll();
        for(LogEntry logEntry : lg) {
            System.out.println(logEntry);;
        }
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://the-internet.herokuapp.com/javascript_error");
        HttpResponse response = client.execute(request);
        if(response.getCode()!=200){
            System.out.println(response);
            
        }
        
        System.out.println("Testtt");
    }
    
    @Test
    public void keyPress(){
        getDriver().get("https://the-internet.herokuapp.com/key_presses");
        WebElement clickfield=getDriver().findElement(By.xpath("//form//input[@id='target']"));
        JavascriptExecutor js= (JavascriptExecutor)getDriver();
        js.executeScript("arguments[0].click();",clickfield);
//        clickfield.sendKeys("Testt");
//        System.out.println("Testt");
        Actions actions=new Actions(getDriver());
        actions.keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).perform();
        
        System.out.println("Testt");
        }
        
        
        @Test
      public void handleWebTable(){
        //Print all the rows
        
        getDriver().get("https://the-internet.herokuapp.com/large");
            List<WebElement> rows =getDriver().findElements(By.xpath("//th//span"));
        for(WebElement rowsOne:rows){
            System.out.println(rowsOne.getText()); 
        }
        
        
        }
        
        @Test
        public void printAllWebElement(){
            getDriver().get("https://the-internet.herokuapp.com/large");
            
            for(int i=1;i<=50;i++) {
               List<WebElement> elements = getDriver().findElements(By.xpath("//div[starts-with(@id,'sibling-"+ i +"." +"')]"));
               for (WebElement element: elements)
                System.out.println(element.getText());
            }
        }
        
        
        @Test
        public void handleMultipleWindows(){
        getDriver().navigate().to("https://the-internet.herokuapp.com/windows");
        WebElement windowLink=getDriver().findElement(By.linkText("Click Here"));
        
        String parentWindow=getDriver().getWindowHandle();
        JavascriptExecutor js=(JavascriptExecutor)getDriver();
        js.executeScript("arguments[0].click();",windowLink);
        System.out.println("Testt");
       Set<String> windows= getDriver().getWindowHandles();
        
        for(String currentWindowHandle: windows){
            if(!currentWindowHandle.equalsIgnoreCase(parentWindow)){
                getDriver().switchTo().window(currentWindowHandle);
               
            }
        }
        getDriver().switchTo().window(parentWindow);
        System.out.println("Yetststt");
        
        
        }
        
        @Test
        public void notificationMessages(){
        getDriver().navigate().to("https://the-internet.herokuapp.com/notification_message_rendered");
        WebElement link=getDriver().findElement(By.linkText("Click here"));
        link.click();
        WebElement notificationMessages=getDriver().findElement(By.xpath("//div[@id='flash-messages']//div"));
        System.out.println(notificationMessages.getText());
        System.out.println("Testttt");
        
        }
        
        @Test
        public void handleStatusCode() throws IOException {
            getDriver().get("https://the-internet.herokuapp.com/status_codes");
            WebElement two = getDriver().findElement(By.linkText("200"));
            WebElement four = getDriver().findElement(By.linkText("404"));
            WebElement five = getDriver().findElement(By.linkText("500"));
            two.click();

            CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(getDriver().getCurrentUrl());
            HttpResponse response = closeableHttpClient.execute(httpGet);
            System.out.println(response.getCode());
            System.out.println("Testt");
            LogEntries logEntries = getDriver().manage().logs().get(LogType.BROWSER);
            List<LogEntry> logs = logEntries.getAll();
            for (LogEntry logEntry : logs) {
                System.out.println(logEntry);
                HttpGet httpGet1 = new HttpGet(getDriver().getCurrentUrl());
                response = closeableHttpClient.execute(httpGet1);
//        if(!(response.getCode() ==200)){
//          logEntries =getDriver().manage().logs().get(LogType.BROWSER);
//          logs=logEntries.getAll();
//          for( logEntry:logs){
//              System.out.println(logEntry);
//          }
//        } 
            }
        }
    
    @Test
    public void testAutheticFileDownload(){
        String username="admin";
        String password="admin";
       String url="https://"+username+":"+password+"@the-internet.herokuapp.com/download_secure";
       getDriver().get(url);
       System.out.println("Testttt");
        
    }
    
    @Test
    public void handleShadowDom(){
        getDriver().navigate().to("https://the-internet.herokuapp.com/shadowdom");
        JavascriptExecutor js=(JavascriptExecutor)getDriver();
        WebElement firstext=(WebElement)js.executeScript("return document.querySelector(\"#content > my-paragraph:nth-child(4) > span\")");
       System.out.println(firstext.getText());
       System.out.println("Tetstttt");
       
       WebElement secondText= (WebElement)js.executeScript("return document.querySelector(\"#content > my-paragraph:nth-child(5) > ul > li:nth-child(2)\")");
       
        System.out.println(secondText.getText());

        System.out.println("Tetstttt");
    }
    
    @Test
    public void handleWebTables(){
       getDriver().get("https://the-internet.herokuapp.com/tables");
     List<WebElement> tableOneHeaders=getDriver().findElements(By.xpath("//table[@id='table1']//thead//tr//th"));
     List<String> actualHeaders=new ArrayList<>();
     List<String> expectedHeaders=new ArrayList<>();
        expectedHeaders.add("Last Name");
        expectedHeaders.add("First Name");
        expectedHeaders.add("Email");
        expectedHeaders.add("Due");
        expectedHeaders.add("Web Site");
        expectedHeaders.add("Action");
        for(WebElement webtableheaders: tableOneHeaders){
            actualHeaders.add(webtableheaders.getText());
        }
        System.out.println(actualHeaders);
        Assert.assertTrue(actualHeaders.equals(expectedHeaders));
        System.out.println("Tetstttt");
       
    }     
    
    @Test
    public void handlCSSValue(){
        getDriver().get("https://www.facebook.com/");
        WebElement facebookButton=getDriver().findElement(By.xpath("//button[@data-testid='royal_login_button']"));
        System.out.println(facebookButton.getCssValue("background-color"));
    }
}
    

