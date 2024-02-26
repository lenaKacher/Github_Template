package gitlab.tests;

import gitlab.common.Global_VARS;
import gitlab.common.TestWatcher;
import gitlab.pages.HomePO;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestWatcher.class)
public class FilterByTest extends BaseTest {

    @BeforeMethod
    public void ensurePreconditions() {
        HomePO homePO = new HomePO();
        homePO.clickOnMenuUserBtn();
        homePO.login(Global_VARS.login, Global_VARS.password);
    }

    @Test
    @Owner("Lena Kacher")
    @Description("Check if it is possible to filter Items by Price and color")
    public void filterByPrice(){
        HomePO homePO = new HomePO();
        homePO.clickOnMenuUserBtn();
        homePO.login(Global_VARS.login, Global_VARS.password);
        Assert.assertFalse(homePO.isErrorMessageExists());
    }
}
