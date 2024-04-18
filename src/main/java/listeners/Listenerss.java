package listeners;

import core.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.CommonUtilities;

import java.io.File;
import java.io.IOException;

public class Listenerss extends BaseTest implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        
//        System.out.println("Listner on test start event"+result.getStatus());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Listner on test success event"+result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Listner on tets failure "+result.getMethod().getMethodName());
        
//        CommonUtilities.takeScreenshot(result, driver);
        Object currentInstance=result.getInstance();
        File screenshotFile = ((TakesScreenshot) ((BaseTest)currentInstance).getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile , new File("Everifile_Automation/screenshots/screen_shots"+result.getMethod().getMethodName()+".png"));
        } catch (IOException e) {
            e.printStackTrace();

//            File screenShot=((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Listner on test skipped event"+result.getStatus());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Listner on start event"+result.getStatus());
       
    }

    @Override
    public void onStart(ITestContext context) {

//        System.out.println("Listner on start event"+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
//        System.out.println("Listner on finish event"+context.getName());
        
    }
}
