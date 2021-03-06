package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.GeneralPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    GeneralPage generalPage = new GeneralPage();

    @Test(description = "TC06 - User is redirected to Home page after logging out")
    public void TC06() {
        homePage.open();

        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        homePage.gotoContactPage();

        homePage.logout();

        Assert.assertTrue(Utilities.isPageOpened(Constant.HOME));
        Assert.assertTrue(!generalPage.isLogoutTabDisplayed(), "Log out tab is not disappeared");
    }
}
