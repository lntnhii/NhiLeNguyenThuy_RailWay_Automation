package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @BeforeMethod
    public void beforeMethod() {
        homePage.open();
        homePage.gotoLoginPage();
    }

    @AfterMethod
    public void afterMethod() {
        homePage.logout();
    }

    @Test(description = "TC01 - User can log into Railway with valid username and password")
    public void TC01() {
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String actualMsg = homePage.getWelcomeUser();
        String expectedMsg = String.format(Constant.MSG_WELCOME_USER, Constant.USERNAME);

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome user message is not displayed correctly");
    }

    @Test(description = "TC02 - User can't login with blank \"Username\" textbox")
    public void TC02() {
        loginPage.login(Constant.DATA_EMPTY_USERNAME, Constant.PASSWORD);

        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = Constant.MSG_PROBLEM_USERNAME_PASSWORD;

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed correctly");
    }

    @Test(description = "TC03 - User cannot log into Railway with invalid password")
    public void TC03() {
        loginPage.login(Constant.USERNAME, Constant.DATA_INVALID_PASSWORD);

        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = Constant.MSG_INVALID_USERNAME_PASSWORD;

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed correctly");
    }

    @Test(description = "TC05 - System shows message when user enters wrong password several times")
    public void TC05() {
        loginPage.loginSeveralTimes(Constant.USERNAME, Constant.DATA_INVALID_PASSWORD, Constant.DATA_LOGIN_TIMES);

        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = Constant.MSG_RUN_OUT_OF_TRY_LOGIN;

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed correctly");
    }

    @Test(description = "TC08 - User can't login with an account hasn't been activated")
    public void TC08() {
        loginPage.gotoRegisterPage();
        String newEmail = Constant.DATA_REGISTER_EMAIL;

        RegisterPage registerPage = new RegisterPage();
        registerPage.register(newEmail
                , Constant.DATA_REGISTER_PASSWORD
                , Constant.DATA_REGISTER_CONFIRM_PASSWORD
                , Constant.DATA_REGISTER_PID);

        registerPage.gotoLoginPage();

        loginPage.login(newEmail, Constant.DATA_REGISTER_PASSWORD);

        Assert.assertTrue(Utilities.isPageOpened("Login"), "User can still login with unactivated account");

        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = Constant.MSG_INVALID_USERNAME_PASSWORD;
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed correctly");
    }
}
