import core.BaseTest;
import listeners.RetryAnalyzerListener;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Month;
import java.util.List;
import java.util.Set;

public class PracticeSeleniumConceptTwo extends BaseTest {
    public int count = 0;

    @Test(retryAnalyzer = RetryAnalyzerListener.class)
    public void testFour() {
        getDriver().get("https://www.snapchat.com/");
        // getDriver().manage().window().fullscreen();

        if (count < 2) {
            count++;
            Assert.assertEquals(1, 2);
        }
    }


    @Test
    public void SingUponFacebook() {
        getDriver().get("https://www.facebook.com/campaign/landing.php?campaign_id=14884913640&extra_1=s%7Cc%7C550525805682%7Cb%7Cfb%20registration%7C&placement=&creative=550525805682&keyword=fb%20registration&partner_id=googlesem&extra_2=campaignid%3D14884913640%26adgroupid%3D128696221592%26matchtype%3Db%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-322833375554%26loc_physical_ms%3D9302611%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=Cj0KCQjwgNanBhDUARIsAAeIcAs_PZpnyxyQ3-v6uq9yruIqF3dAGG-zvWqx7SdljNzjAtd-WhkU_gkaAhN8EALw_wcB");
        WebElement firstname = getDriver().findElement(By.name("firstname"));
        firstname.sendKeys("Saif");
        WebElement lastname = getDriver().findElement(By.name("lastname"));
        lastname.sendKeys("Sultan");
        WebElement phoneNumber = getDriver().findElement(By.name("reg_email__"));
        phoneNumber.sendKeys("9599143122");
        WebElement password = getDriver().findElement(By.name("reg_passwd__"));
        password.sendKeys("Sheezan@100");
        // selectValueFromDropDown("day","8");

        getDriver().findElement(By.id("day")).click();
//        selectDropDownThroughLoopingWay("//select[@id='day']//child::option","9");
        // selectDropDownOption("15");
        //  selectDropDownthroughJavaScriptExecuter("21");
        selectDropDownThroughSendKeys("28");

        selectValueFromDropDown("month", "Jan");

        selectValueFromDropDown("year", "1995");
        WebElement selectGender = getDriver().findElement(By.xpath("//label[text()='Male']//following-sibling::input[@type='radio']"));
        selectGender.click();
        WebElement SingUp = getDriver().findElement(By.name("websubmit"));
        SingUp.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10)) {
        };
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector("div.xdj266r.x11i5rnm.xat24cr.x1mh8g0r.x1vvkbs"))));
        WebElement singUpConfirmationText = getDriver().findElement(By.cssSelector("div.xdj266r.x11i5rnm.xat24cr.x1mh8g0r.x1vvkbs"));
        String originalMessage = "We'll take you through a few steps to confirm your account on Facebook.";
        Assert.assertEquals(originalMessage, singUpConfirmationText.getText());
        System.out.println("Passed");

    }

    public void selectValueFromDropDown(String locator, String optionToBeSelected) {
        Select dropdown = new Select(getDriver().findElement(By.id(locator)));
        dropdown.selectByVisibleText(optionToBeSelected);

    }

    public void selectDropDownThroughLoopingWay(String locator, String optionToBeClicked) {
        List<WebElement> items = getDriver().findElements(By.xpath(locator));

        for (WebElement dropDownOption : items) {

            if (dropDownOption.getText().equals(optionToBeClicked)) {
                dropDownOption.click();
            }
        }
    }

    public void selectDropDownOption(String valueToBeSelected) {
        String locator = "//option[text()='" + valueToBeSelected + "']";
        getDriver().findElement(By.xpath(locator)).click();
    }

    public void selectDropDownThroughJavaScriptExecuter(String value) {

        WebElement dropdown = getDriver().findElement(By.xpath("//select[@id='day']"));

        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        js.executeScript("arguments[0].value='" + value + "'", dropdown);
    }

    public void selectDropDownThroughSendKeys(String valueToBeSelect) {

        getDriver().findElement(By.xpath("//select[@id='day']")).sendKeys(valueToBeSelect);

    }


    @Test
    public void switchingToFrame() {

        getDriver().get("https://www.hyrtutorials.com/p/frames-practice.html");
        getDriver().switchTo().frame("frm3");
        getDriver().findElement(By.xpath(" //input[@id='name']")).sendKeys("Inside frame 3");
        getDriver().switchTo().frame("frm1");
        selectValueFromDropDown("selectnav1", "Tutorials");
        getDriver().switchTo().parentFrame();
        getDriver().findElement(By.xpath(" //input[@id='name']")).clear();
        getDriver().switchTo().defaultContent();
        getDriver().findElement(By.xpath("//input[@class='frmTextBox']")).sendKeys("Flow is complete");
        System.out.println("Great");
    }


    @Test
    public void handlingFrames() {

        getDriver().navigate().to("https://www.hyrtutorials.com/p/add-padding-to-containers.html#");
        WebElement practiceDropdown = getDriver().findElement(By.xpath("//a[text()='Selenium Practice']"));

        Actions actions = new Actions(getDriver());
        actions.moveToElement(practiceDropdown).build().perform();

        WebElement windowHandles = getDriver().findElement(By.xpath("//a[text()='Window Handles']"));
        windowHandles.click();

        WebElement textBox = getDriver().findElement(By.xpath("//input[@class='whTextBox' and @id='name']"));
        textBox.sendKeys("Handling Drop Down");
        WebElement newWindow = getDriver().findElement(By.id("newWindowBtn"));
        String parentWindow = getDriver().getWindowHandle();
        newWindow.click();

        Set<String> listOfWindows = getDriver().getWindowHandles();


        for (String currentWindow : listOfWindows) {

            if (!currentWindow.equalsIgnoreCase(parentWindow)) {

                getDriver().switchTo().window(currentWindow);


                // getDriver().manage(
                // ).window().maximize();
                int width = 900;
                int height = 600;

                Dimension dimension = new Dimension(width, height);
                getDriver().manage().window().setSize(dimension);
            }
        }

        WebElement firsName = getDriver().findElement(By.xpath("//input[@id='firstName']"));

        firsName.sendKeys("Switched on new Window");

        System.out.println("Okay");
        getDriver().close();
        getDriver().switchTo().window(parentWindow);
        textBox.clear();

        System.out.println("Okay");
    }


    @Test
    public void handleTabs() {

        getDriver().navigate().to("https://www.hyrtutorials.com/p/add-padding-to-containers.html#");
        WebElement practiceDropdown = getDriver().findElement(By.xpath("//a[text()='Selenium Practice']"));

        Actions actions = new Actions(getDriver());
        actions.moveToElement(practiceDropdown).build().perform();

        WebElement windowHandles = getDriver().findElement(By.xpath("//a[text()='Window Handles']"));
        windowHandles.click();

        WebElement textBox = getDriver().findElement(By.xpath("//input[@class='whTextBox' and @id='name']"));
        textBox.sendKeys("Handling Drop Down");
        WebElement newWindow = getDriver().findElement(By.id("newTabBtn"));
        String parentWindow = getDriver().getWindowHandle();
        newWindow.click();

        Set<String> listOfWindows = getDriver().getWindowHandles();


        for (String currentWindow : listOfWindows) {

            if (!currentWindow.equalsIgnoreCase(parentWindow)) {

                getDriver().switchTo().window(currentWindow);
                getDriver().manage().window().maximize();
            }
        }

        //Accepting the alert
        WebElement alertBox = getDriver().findElement(By.id("alertBox"));
        alertBox.click();
        String alertText = getDriver().switchTo().alert().getText();
        System.out.println(alertText);
        getDriver().switchTo().alert().accept();
        System.out.println("First Action");


        // Dismissing the alert
        WebElement confirmBox = getDriver().findElement(By.id("confirmBox"));
        confirmBox.click();
        String confirmmBox = getDriver().switchTo().alert().getText();
        System.out.println(confirmmBox);
        getDriver().switchTo().alert().dismiss();
        System.out.println("First Action");


    }

    @Test
    public void handleCalendars() throws InterruptedException {
        getDriver().navigate().to("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        WebElement practiceDropdown = getDriver().findElement(By.xpath("//a[text()='Selenium Practice']"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(practiceDropdown).build().perform();
        WebElement calendarPractice = getDriver().findElement(By.xpath("//a[text()='Calendars Practice']"));
        calendarPractice.click();
        Actions act = new Actions(getDriver());
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,70)");
        WebElement firstCalendarPicker = getDriver().findElement(By.id("first_date_picker"));
        firstCalendarPicker.click();

        selectDate("2022", "January", "15");
        
    }


    public void selectDate(String Year, String Month, String Day) throws InterruptedException {
        WebElement currentYearOnCalendar = getDriver().findElement(By.cssSelector("span.ui-datepicker-year"));
        
        WebElement currentMonth = getDriver().findElement(By.cssSelector("span.ui-datepicker-month"));
        //WebElement previousButton=getDriver().findElement(By.cssSelector("span.ui-datepicker-prev ui-corner-all"));
        WebElement previousButton = getDriver().findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-w"));
        WebElement nextButton = getDriver().findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e"));
        WebElement selectDate=getDriver().findElement(By.xpath("//a[text()='"+Day+"']"));
        int currentYear = Integer.parseInt(currentYearOnCalendar.getText());
        
        int YearToBeSelected = Integer.parseInt(Year);

        //Select the Year
        if (YearToBeSelected < currentYear) {


            while (!getDriver().findElement(By.cssSelector("span.ui-datepicker-year")).getText().equalsIgnoreCase(Year)) {
                getDriver().findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-w")).click();

            }
        } 
        else {
            while (!getDriver().findElement(By.cssSelector("span.ui-datepicker-year")).getText().equalsIgnoreCase(Year)) {
               getDriver().findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();

            }
        } 
        //Select the Month
        int monthToBeSelected=getNumberFromMonthName(Month);
        int MonthOnCalendar=getNumberFromMonthName(getDriver().findElement(By.cssSelector("span.ui-datepicker-month")).getText());
        
        if(monthToBeSelected<MonthOnCalendar){
            
            while (!getDriver().findElement(By.cssSelector("span.ui-datepicker-month")).getText().equalsIgnoreCase(Month)){
                getDriver().findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-w")).click();
            
        }
        }
        else{
            while (!getDriver().findElement(By.cssSelector("span.ui-datepicker-month")).getText().equalsIgnoreCase(Month)){
                
              getDriver().findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();
            }
            }
        
        
        //Select the Date
      getDriver().findElement(By.xpath("//a[text()='"+Day+"']")).click();
        
        System.out.println("Text");
        
    }

    public static int getNumberFromMonthName(String monthName) {

        return Month.valueOf(monthName.toUpperCase()).getValue();

    }
    
    
    
}
        
       
           
       

