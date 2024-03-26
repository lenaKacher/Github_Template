package gitlab.tests;

import gitlab.common.CreateWebDriver;
import gitlab.common.Global_VARS;
import gitlab.pages.BasketPO;
import gitlab.pages.HomePO;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public abstract class BaseTest {
    @BeforeClass
    protected void setUp() {
        // Create the specific driver
        CreateWebDriver.getInstance().setWebDriver(Global_VARS.aDriverType);
        WebDriver aDriver = CreateWebDriver.getInstance().getWebDriver();
        aDriver.get(Global_VARS.url);
    }

    public File takeScreenshot(String methodName) throws IOException {
        WebDriver aDriver = CreateWebDriver.getInstance().getWebDriver();
        Date d = new Date();
        String timestamp = d.toString().replace(":", "_").replace(" ", "");
        File screenshotAs = ((TakesScreenshot) aDriver).getScreenshotAs(OutputType.FILE);
        return screenshotAs;
    }

    @AfterMethod
    public void afterMethod(ITestResult pResult) throws IOException {
        String aTestName = pResult.getMethod().getMethodName();
        System.out.println("===== Test name:   " + aTestName);
        System.out.print("      Test Status: ");
        switch (pResult.getStatus()) {
            case ITestResult.SUCCESS:
                System.out.println("PASS");
                break;

            case ITestResult.FAILURE:
                System.out.println("FAIL");
                File screenshot = takeScreenshot(pResult.getName());
                Allure.addAttachment("Test failed on step: " + pResult.getMethod().getMethodName(),
                        FileUtils.openInputStream(screenshot));
                break;

            case ITestResult.SKIP:
                System.out.println("SKIP BLOCKED");
                // my expected functionality here when passed
                break;

            default:
                throw new RuntimeException("Invalid status");
        }

        HomePO homePO = new HomePO();
        if (homePO.isErrorMessageExists() == false) {
            homePO.clickBasketBtn();
            BasketPO basketPO = new BasketPO();
            if (basketPO.isShoppingCartEmpty() == true) {
                homePO.returnToHomePage();
            } else {
                basketPO.removeItemsFromBasket();
            }
            homePO.returnToHomePage();
        }
    }
        @AfterMethod(alwaysRun = true)
        public void tearDown () {
            CreateWebDriver.getInstance().closeWebDriver();
        }
    }
