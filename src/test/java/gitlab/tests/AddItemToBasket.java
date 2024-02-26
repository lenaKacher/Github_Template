package gitlab.tests;

import gitlab.common.Global_VARS;
import gitlab.common.TestWatcher;
import gitlab.pages.BasketPO;
import gitlab.pages.CataloguePO;
import gitlab.pages.HomePO;
import gitlab.pages.ProductPO;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestWatcher.class)
public class AddItemToBasket extends BaseTest {

    // credentials("Waters", "User135");
    @BeforeMethod
    public void ensurePreconditions() {
        HomePO homePO = new HomePO();
        homePO.clickOnMenuUserBtn();
        homePO.login("Waters", "User135");
    }

    @Test
    @Owner("Lena Kacher")
    @Description("Add Item Mouse to the Basket and check if the name of the Item in the Basket is equals to Item in the Catalogue")
    public void addItemToBasketPositiveTest(){
        CataloguePO cataloguePO = new CataloguePO();
        cataloguePO.chooseMice();
        cataloguePO.chooseItem(33);
        ProductPO productPO = new ProductPO();
        productPO.chooseColorAndQuantity("GRAY", "3");
        productPO.addToBasket();
        HomePO homePO = new HomePO();
        homePO.clickBasketBtn();
        BasketPO basketPO = new BasketPO();
        Assert.assertEquals(basketPO.getNameofItem1(), "HP Z800 BLUETOOTH MOUSE");
        Assert.assertEquals(basketPO.getNameofItem2(), "HP Z8000 BLUETOOTH MOUSE");
    }
}
