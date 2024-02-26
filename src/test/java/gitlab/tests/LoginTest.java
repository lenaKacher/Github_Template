package gitlab.tests;

import gitlab.common.Global_VARS;
import gitlab.common.TestWatcher;
import gitlab.pages.HomePO;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestWatcher.class)
public class LoginTest extends BaseTest {

    @Test
    @Owner("Lena Kacher")
    @Description("Check if it is possible to log in with username and password")
    public void login(){
        HomePO homePO = new HomePO();
        homePO.clickOnMenuUserBtn();
        homePO.login(Global_VARS.login, Global_VARS.password);
        Assert.assertFalse(homePO.isErrorMessageExists());
    }
}
