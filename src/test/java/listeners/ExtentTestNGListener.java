package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import BaseTest.BaseTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.ExtentManager;
import utilities.ScreenshotUtility;

public class ExtentTestNGListener
        implements ITestListener {

    ExtentReports extent =
            ExtentManager.getInstance();

    ExtentTest test;

    @Override
    public void onTestStart(
            ITestResult result) {

        Object[] parameters =
                result.getParameters();

        if (parameters.length > 0) {

            test = extent.createTest(
                    result.getMethod()
                            .getMethodName()
                            + " - "
                            + parameters[0]);

        } else {

            test = extent.createTest(
                    result.getMethod()
                            .getMethodName());
        }
    }

    @Override
    public void onTestSuccess(
            ITestResult result) {

        test.pass("Test Passed");

        attachScreenshot(result);
    }

    @Override
    public void onTestFailure(
            ITestResult result) {

        test.fail(result.getThrowable());

        attachScreenshot(result);
    }

    private void attachScreenshot(
            ITestResult result) {

        try {

            String product =
                    (String) result.getAttribute(
                            "productName");

            String screenshotName;

            if (product != null
                    && !product.trim().isEmpty()) {

                String cleanedProduct =
                        product.replaceAll(
                                "[^a-zA-Z0-9]",
                                "");

                if (cleanedProduct.isEmpty()) {

                    screenshotName =
                            "Search_SpecialCharacters";

                } else {

                    screenshotName =
                            "Search_"
                                    + cleanedProduct;
                }

            } else {

                screenshotName =
                        result.getMethod()
                                .getMethodName();
            }

            String screenshotPath =
                    ScreenshotUtility
                            .captureScreenshot(
                                    BaseTest.driver,
                                    screenshotName);

            test.addScreenCaptureFromPath(
                    screenshotPath);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(
            ITestContext context) {

        extent.flush();
    }
}