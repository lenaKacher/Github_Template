package gitlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// page_url = https://www.advantageonlineshopping.com/#/
public class CataloguePO extends BasePO {
    @FindBy(id = "miceImg")
    public WebElement miceImg;

    @FindBy(id = "speakersImg")
    public WebElement speakersImg;

    public CataloguePO() {
        super();
    }

    public void chooseMice() {
        miceImg.click();
    }
    public void chooseSpekers() {
        speakersImg.click();
    }

    public void chooseItem(int number) {
        driver.findElement(By.xpath("//*[@id='" + number + "']")).click();
    }

}