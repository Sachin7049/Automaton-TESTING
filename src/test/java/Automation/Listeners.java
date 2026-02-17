package Automation;

import Automation.testComponent.BaseTest;
import Framework.resources.Reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener {

    ExtentReports extentReports = Reports.getreportsobject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest(
                result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.get().fail(result.getThrowable());

        Object testInstance = result.getInstance();
        WebDriver driver = null;

        if (testInstance instanceof BaseTest) {
            driver = ((BaseTest) testInstance).getDriver();
        }

        if (driver != null) {
            try {
                String path = ((BaseTest) testInstance)
                        .takeScreenshot(
                                result.getMethod().getMethodName(),
                                driver);

                extentTest.get().addScreenCaptureFromPath(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            extentTest.get().warning("Driver is null, screenshot not captured");
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
