package gitlab.pages;

import gitlab.common.CreateWebDriver;
import gitlab.common.SynchronizationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


// page_url = https://www.advantageonlineshopping.com/#/
public class BasePO {
    protected WebDriver driver = CreateWebDriver.getInstance().getWebDriver();
    public BasePO() {
        SynchronizationUtils.waitForPageLoad();
        PageFactory.initElements(driver, this);
    }

    public void waitForVisibiblity(WebDriver driver, WebElement element, long timer) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timer));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
    }

    public void pause(long timer) {
        try {
            Thread.sleep(timer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitForClickable(WebDriver driver, WebElement element, long timer) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timer));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
    }

    public static void waitForSelector(WebDriver driver, By element, long timer) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timer));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    protected void executeJavaScript(String pScript, WebElement pWebElement) {
        JavascriptExecutor aExecutor = (JavascriptExecutor) driver;
        aExecutor.executeScript(pScript, pWebElement);
    }

}