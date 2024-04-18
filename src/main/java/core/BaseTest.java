package core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.CommonUtilities;
import utilities.reporting.ExtentReporter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {
    
    public ExtentReporter extentReporter;
   // public static WebDriver driver;
    private  ThreadLocal<WebDriver> driverThreadLocal=new ThreadLocal<>();
    public void setDriver(WebDriver driver){
        
        this.driverThreadLocal.set(driver);
        
    }
    
    public WebDriver getDriver(){
        
        return this.driverThreadLocal.get();
    }
  
    @BeforeSuite(alwaysRun = true)
    public void loadApplicationConfig() throws IOException {
        ExtentReporter extentReporter = new ExtentReporter();
        Configuration.loadConfig();
        extentReporter.initializeReportEngine();
        CommonUtilities.cleanDirectory("Everifile_Automation/screenshots");
        
        
    }
    @Parameters({"browsers"})
    @BeforeMethod(alwaysRun = true)
    public void setup(Method method, @Optional() String browsers) {
        
        extentReporter =new ExtentReporter();
        extentReporter.createNewAndAssignTest(method.getName());
       // driver=browser.getDriver(browsers);
        Browser browser=new Browser();
//        setDriver(browser.getDriver(Configuration.getBrowser()));
        if(browsers==null || browser.equals("")){
            setDriver(browser.getDriver(Configuration.getBrowser()));
        }
        else {
            setDriver(browser.getDriver(browsers));
        }
        getDriver().manage().window().maximize();
        //threadLocaldriver.set(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void aftermethod(ITestResult iTestResult) {
        if(iTestResult.getStatus()==ITestResult.FAILURE){
//            CommonUtilities.takeScreenshot(iTestResult, driver);
            extentReporter.logFail("Failed");
            extentReporter.attachScreenshot("screenshots/screen_shots"+iTestResult.getMethod().getMethodName()+".png");
           
        }
        extentReporter.endOrCloseTest();
//        driver.close();
//        threadLocaldriver.remove();
    }
    
//    public static WebDriver getdriver(){
//        return threadLocaldriver.get();
//    }


//    public void takeScreenshot(ITestResult iTestResult){
//        
//        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(screenshotFile , new File("Everifile_Automation/screenshots/screen_shots"+iTestResult.getMethod().getMethodName()+".png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
 @DataProvider(name="testData")
  public static Object[][] SingInData(){

    Object[][] twitterdata=new Object[2][3];

    twitterdata[0][0]="username1@gmail.com";
// Enter data to row 0 column 1
    twitterdata[0][1]="Password1";
    
    twitterdata[0][2]="9599143041";
// Enter data to row 1 column 0
    twitterdata[1][0]="username2@gmail.com";
// Enter data to row 1 column 0
    twitterdata[1][1]="Password2";
// return arrayobject to testscript
    return twitterdata;
}

   @DataProvider(name="readDataFromSheet")
    public Object[][] readTestData(Method m) throws IOException {
        
        if(m.getName().equalsIgnoreCase("testOne")) {
            Object[][] testData = CommonUtilities.readDataFromSheet("src/main/resources/testData/testDataLogina.xls", "loginDate");
            return testData;
        }
        if(m.getName().equalsIgnoreCase("testTwo")){
            Object[][] testData = CommonUtilities.readDataFromSheet("src/main/resources/testData/testDataLogina.xls", "signUpDate");
            return testData;
        }
        return null;
        
    }
    
          }
  
   
   

   
