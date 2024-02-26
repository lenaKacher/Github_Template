package gitlab.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// page_url = https://www.advantageonlineshopping.com/#/shoppingCart
public class BasketPO extends BasePO{
    public BasketPO() {
        super();
    }

    @FindBy(xpath = "//a[@translate='REMOVE']")
    public WebElement removeProductBtn;
    
    @FindBy(css = ".productName")
    public WebElement name1;
    @FindBy(css = "label[class*='productName']")
    public WebElement name2;
    @FindBy(xpath = "/html/body/div[3]/section/article/div[2]/tool-tip-cart/div/table/tbody/tr/td[2]/a/h3")
    public WebElement name3;

    @FindBy(xpath = "//label[@class='roboto-bold ng-scope']")
    public WebElement labelYourShoppingCartEmpty;
    public String getNameofItem1() {
        return name1.getText();
    }
    public String getNameofItem2() {
        return name2.getText();
    }
    public String getNameofItem3() {
        return name3.getText();
    }

    public void removeItemsFromBasket(){
        removeProductBtn.click();
    }

    public boolean isShoppingCartEmpty() {
        return labelYourShoppingCartEmpty.isDisplayed();
    }
}