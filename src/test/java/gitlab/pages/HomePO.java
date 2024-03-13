package gitlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// page_url = https://www.advantageonlineshopping.com/#/
public class HomePO extends BasePO {

    @FindBy(xpath = "//*[@id='menuUser']")
    public WebElement menuUser;

    @FindBy(xpath = "//div[@class='rowSection']")
    public WebElement rowSection;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userNameField;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement userPasswordField;

    @FindBy(id = "sign_in_btn")
    public WebElement signInBtn;

    @FindBy(xpath = "//*[@id='menuCart']")
    public WebElement menuCart;

    @FindBy(xpath = "//div[@class='logo']")
    public WebElement homePage;

    @FindBy(xpath = "//*[@id='menuCart']")
    public WebElement svgMenuCart;

    @FindBy(xpath = "//*[@id='shoppingCartLink']")
    public WebElement linkShoppingCart2;

    @FindBy(css = "button[id$='btnundefined']")
    public WebElement buttonSenderSend;
    @FindBy(id = "signInResultMessage")
    public WebElement errorMessage;

    public HomePO() {
        super();
    }

    public void clickOnMenuUserBtn() {
        menuUser.click();
    }

    public void login(String userName, String password) {
        userNameField.sendKeys(userName);
        userPasswordField.sendKeys(password);
        waitForSelector(driver, By.id("sign_in_btn"), 10);
        signInBtn.click();
    }

    public void clickBasketBtn() {
        menuCart.click();
    }

    public void returnToHomePage() {
        homePage.click();
    }

    public boolean isErrorMessageExists() {
        pause(1000);
        if (errorMessage.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

}