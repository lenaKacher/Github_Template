package gitlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// page_url = https://www.advantageonlineshopping.com/#/
public class ProductPO extends BasePO{

    @FindBy(xpath = "//input[@name='quantity']")
    public WebElement inputQuantity;

    @FindBy(xpath = "//button[@name='save_to_cart']")
    public WebElement addToCartBtn;

    public ProductPO() {
        super();
    }
     public void chooseColorAndQuantity(String color, String quant){
        driver.findElement(By.xpath("//span[contains(@title, '" + color + "')]")).click();
        inputQuantity.sendKeys(Keys.BACK_SPACE);
        inputQuantity.sendKeys(quant);
     }

    public void addToBasket() {
        addToCartBtn.click();
    }
}