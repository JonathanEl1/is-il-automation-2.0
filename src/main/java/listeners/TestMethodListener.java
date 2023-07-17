package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestMethodListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        // This is not being used.
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // This is not being used.
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Throwable throwable = result.getThrowable();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // This is not being used.
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // This is not being used.
    }

    @Override
    public void onStart(ITestContext context) {
        // This is not being used.
    }

    @Override
    public void onFinish(ITestContext context) {
        // This is not being used.
    }
}
