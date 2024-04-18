package utilities.reporting;


import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import core.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;


import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExtentReporter {

    /** The HTML logger. */
    private static ExtentHtmlReporter extentHtmlReporter;

    /** The extent. */
    private static ExtentReports extent;

    /** The extent test. */
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    /** The Constant BROWSER. */
    private static final String BROWSER = "Browser";

    /** The Constant OS_DETAILS. */
    private static final String OS_DETAILS = "OS_Details";

    /** The Constant ENVIRONMENT. */
    private static final String ENVIRONMENT = "Environment";

    /** The Constant DEFAULT_BROWSER. */
    private static final String DEFAULT_BROWSER = "Chrome";

    /** The Constant VERSION. */
    private static final String VERSION = "Version";

    /**
     * Log pass.
     *
     * @param message the message
     */
    public void logPass(final String message) {
        extentTest.get().log(Status.PASS, message);
    }

    /**
     * Log fail.
     *
     * @param message the message
     */
    public void logFail(final String message) {
        extentTest.get().fail(new Throwable(message));
    }

    /**
     * Log fail with throwable.
     *
     * @param t the t
     */

    public void logFail(Throwable t) {
        
        extentTest.get().fail(t);
    }

    /**
     * Log info.
     *
     * @param message the message
     */
    public void logInfo(final String message) {
        
        extentTest.get().log(Status.INFO, message);
    }

    /**
     * Log skip.
     *
     * @param message the message
     */
    public void logSkip(final String message) {
        extentTest.get().skip(message);
    }

    /**
     * Initialize report engine.
     */
    public void initializeReportEngine() {
        final File outputPath = new File(Configuration.getProperty("report_location"));
        if (!outputPath.exists()) {
            outputPath.mkdir();
        }
        final File outputPathForScreenShot = new File(
                Configuration.getProperty("report_location") + File.separator + "screenshots" + File.separator);
        if (!outputPathForScreenShot.exists()) {
            outputPathForScreenShot.mkdir();
        }

        extentHtmlReporter = new ExtentHtmlReporter(
                outputPath + File.separator + Configuration.getProperty("report_html_name"));
        extentHtmlReporter.config().setDocumentTitle(Configuration.getProperty("report_document_title"));
        extentHtmlReporter.config().setReportName(Configuration.getProperty("report_location"));
        extentHtmlReporter.setAnalysisStrategy(AnalysisStrategy.TEST);
        extent = new ExtentReports();
        extent.attachReporter(extentHtmlReporter);
        extent.setSystemInfo(ENVIRONMENT, Configuration.getProperty("env"));

        if (StringUtils.isEmpty(System.getProperty("browser.type"))) {
            extent.setSystemInfo(BROWSER, DEFAULT_BROWSER);
        } else {
            extent.setSystemInfo(BROWSER, System.getProperty("browser.type"));
        }
        extent.setSystemInfo(OS_DETAILS, System.getProperty("os.name"));
    }

    /**
     * Creates the new and assign test.
     *
     * @param testName the test name
     */
    public void createNewAndAssignTest(final String testName) {
        extentTest.set(extent.createTest(testName));
    }

    /**
     * End or close test.
     */
    public void endOrCloseTest() {
        extent.flush();
    }

    /**
     * Close report engine.
     */
    public void closeReportEngine() {

    }

    /**
     * Take screenshot.
     *
     * @param stringPath the string path
     */
    public void attachScreenshot(final String stringPath) {
        try {
            extentTest.get().info("screenshots", MediaEntityBuilder
                    .createScreenCaptureFromPath(stringPath).build());
        } catch (final IOException e) {
            logError(e);
        }
    }

    /**
     * Log error.
     *
     * @param error the error
     */
    public static void logError(final Throwable error) {
        extentTest.get().error(error);
    }

    /**
     * Adds the categories.
     *
     * @param groups the groups
     */
    public void addCategories(final String[] groups) {
        extentTest.get().assignCategory(groups);
    }

    /**
     * Sets the version number.
     *
     * @param buildNumber the new version number
     */
    public void setVersionNumber(String buildNumber) {
        extent.setSystemInfo(VERSION, buildNumber);
    }
}


