package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
    RegisterPage registerPage = new RegisterPage();

    @BeforeMethod
    public void beforeMethod() {
        homePage.open();
        homePage.gotoRegisterPage();
    }

    @AfterMethod
    public void afterMethod() {
        homePage.logout();
    }

    @Test(description = "TC07 - User can log into Railway with valid username and password")
    public void TC07() {
        registerPage.register(Constant.DATA_REGISTER_EMAIL
                , Constant.DATA_REGISTER_PASSWORD
                , Constant.DATA_REGISTER_CONFIRM_PASSWORD
                , Constant.DATA_REGISTER_PID);

        Assert.assertTrue(Utilities.isPageOpened("Registration Confirmation Page"), "Register failed");

        String actualMsg = registerPage.getRegisterMessage();
        String expectedMsg = Constant.MSG_THANK_YOU_REGISTER;
        Assert.assertEquals(actualMsg,expectedMsg,"Thank you for registering message is not displayed correctly");
    }
}
