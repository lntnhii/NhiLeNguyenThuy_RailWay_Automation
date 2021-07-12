package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends GeneralPage {
    //Locators
    private final By txtEmail = By.id("email");
    private final By btnSendInstructions = By.xpath("//input[@value='Send Instructions']");
    private final By frmChangePassword = By.xpath("//form[contains(.,'Password Reset')]");

    //Elements
    public WebElement getEmailElement() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    public WebElement getSendInstructionsElement() {
        return Constant.WEBDRIVER.findElement(btnSendInstructions);
    }

    public WebElement getFrmChangePassword() {
        return Constant.WEBDRIVER.findElement(frmChangePassword);
    }

    //Methods
    public void requestResetPassword(String email) {
        this.getEmailElement().sendKeys(email);
        this.getSendInstructionsElement().click();
    }

    //Methods support checkpoint
    public boolean isChangePasswordFormDisplayed() {
        return Utilities.isElementDisplayed(getFrmChangePassword());
    }
}
