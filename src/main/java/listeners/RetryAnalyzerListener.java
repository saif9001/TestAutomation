package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerListener implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int MAX_RETRY_COUNT = 3; // You can adjust the maximum retry count as needed

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < MAX_RETRY_COUNT) {
            System.out.println("Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) + " time(s).");
            retryCount++;
            return true;
        }
        return false;
    }

    private String getResultStatusName(int status) {
        switch (status) {
            case ITestResult.SUCCESS:
                return "SUCCESS";
            case ITestResult.FAILURE:
                return "FAILURE";
            case ITestResult.SKIP:
                return "SKIP";
            default:
                return "UNKNOWN";
        }
    }

    

}
