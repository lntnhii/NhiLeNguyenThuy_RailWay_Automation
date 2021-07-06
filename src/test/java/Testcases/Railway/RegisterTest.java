package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
    RegisterPage registerPage = new RegisterPage();

    @BeforeMethod
    public void beforeMethod() {
        homePage.open();
        homePage.gotoRegisterPage();
    }

    @Test(description = "TC07 - User can log into Railway with valid username and password")
    public void TC07() {
        registerPage.register(Constant.DATA_REGISTER_EMAIL
                , Constant.DATA_REGISTER_PASSWORD
                , Constant.DATA_REGISTER_CONFIRM_PASSWORD
                , Constant.DATA_REGISTER_PID);

        Assert.assertTrue(Utilities.isPageOpened("Registration Confirmation Page"), "Register failed");

        String actualMsg = registerPage.getRegisterMsg();
        String expectedMsg = Constant.MSG_THANK_YOU_REGISTER;
        Assert.assertEquals(actualMsg,expectedMsg,"Thank you for registering message is not displayed correctly.");
    }

    @Test(description = "TC10 - User can't create account with an already in-use email")
    public void TC10() {
        String newEmail = Constant.DATA_REGISTER_EMAIL;
        registerPage.register(newEmail
                , Constant.DATA_REGISTER_PASSWORD
                , Constant.DATA_REGISTER_CONFIRM_PASSWORD
                , Constant.DATA_REGISTER_PID);

        homePage.gotoRegisterPage();
        registerPage.register(newEmail
                , Constant.DATA_REGISTER_PASSWORD
                , Constant.DATA_REGISTER_CONFIRM_PASSWORD
                , Constant.DATA_REGISTER_PID);

        String actualMsg = registerPage.getRegisterErrorMsg();
        String expectedMsg = Constant.MSG_IN_USED_EMAIL;
        Assert.assertEquals(actualMsg,expectedMsg,"Error message is not displayed correctly.");
    }

    @Test(description = "TC11 - User can't create account while password and PID fields are empty")
    public void TC11() {
        registerPage.register(Constant.DATA_REGISTER_EMAIL
                , Constant.DATA_EMPTY_PASSWORD
                , Constant.DATA_EMPTY_CONFIRM_PASSWORD
                , Constant.DATA_EMPTY_PID);

        String actualRegisterMsg = registerPage.getRegisterErrorMsg();
        String expectedRegisterMsg = Constant.MSG_REGISTER_ERROR;
        Assert.assertEquals(actualRegisterMsg,expectedRegisterMsg,"Summary error message is not displayed correctly.");

        String actualPasswordMsg = registerPage.getPasswordErrorMsg();
        String expectedPasswordMsg = Constant.MSG_PASSWORD_ERROR;
        Assert.assertEquals(actualPasswordMsg,expectedPasswordMsg,"Password error message is not displayed correctly.");

        String actualPidMsg = registerPage.getPidErrorMsg();
        String expectedPidMsg = Constant.MSG_PID_ERROR;
        Assert.assertEquals(actualRegisterMsg,expectedRegisterMsg,"Pid error message is not displayed correctly.");
    }
}
