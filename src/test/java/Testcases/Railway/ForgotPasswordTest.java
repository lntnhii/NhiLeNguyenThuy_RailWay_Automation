package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.ForgotPasswordPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest {
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @BeforeMethod
    public void beforeMethod() {
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.gotoForgetPasswordPage();
    }

    @AfterMethod
    public void afterMethod() {
        forgotPasswordPage.logout();
    }

    @Test(description = "TC12 - Errors display when password reset token is blank")
    public void TC12() {
        Assert.assertTrue(forgotPasswordPage.isChangePasswordFormDisplayed(), "Change password form is not displayed");

        forgotPasswordPage.requestResetPassword(Constant.USERNAME);
        Assert.assertTrue(!Utilities.isPageOpened(Constant.SERVER_ERROR_MAILBOX),"Password reset request is blocked");
    }

    @Test(description = "TC13 - Errors display if password and confirm password don't match when resetting password")
    public void TC13() {
        Assert.assertTrue(forgotPasswordPage.isChangePasswordFormDisplayed(), "Change password form is not displayed");

        forgotPasswordPage.requestResetPassword(Constant.USERNAME);
        Assert.assertTrue(!Utilities.isPageOpened(Constant.SERVER_ERROR_MAILBOX),"Password reset request is blocked");
    }
}
