package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.ForgotPasswordPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest {
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    @Test(description = "TC12 - Errors display when password reset token is blank")
    public void TC12() {
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.gotoForgetPasswordPage();

        forgotPasswordPage.requestResetPassword(Constant.USERNAME);
        Assert.assertTrue(!Utilities.isPageOpened("Mailbox unavailable"),"Password reset request is blocked");
    }
}
