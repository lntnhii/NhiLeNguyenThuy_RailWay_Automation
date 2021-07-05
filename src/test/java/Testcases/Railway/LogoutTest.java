package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.GeneralPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    GeneralPage generalPage = new GeneralPage();

    @BeforeMethod
    public void beforeMethod() {
        homePage.open();
    }

    @Test(description = "TC06 - User is redirected to Home page after logging out")
    public void TC06() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        homePage.gotoContactPage();

        homePage.logout();

        Assert.assertTrue(Utilities.isPageOpened("Home"));
        Assert.assertTrue(!generalPage.isLogoutTabDisplayed(), "Log out tab is not disappeared");
    }
}
