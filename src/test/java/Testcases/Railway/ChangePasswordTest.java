package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.ChangePasswordPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends BaseTest {
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test(description = "TC09 - User can't change password when \"New Password\" and \"Confirm Password\" are different")
    public void TC09() {
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        homePage.gotoChangePasswordPage();
        changePasswordPage.changePassword(Constant.PASSWORD, Constant.DATA_NEW_PASSWORD, Constant.DATA_CONFIRM_PASSWORD);

        String actualMsg = changePasswordPage.getConfirmPasswordError();
        String expectedMsg = Constant.MSG_CONFIRM_PASSWORD_ERROR;

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed correctly");
    }
}
