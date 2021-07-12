package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {
    //Locators
    private final By txtCurrentPassword = By.id("currentPassword");
    private final By txtNewPassword = By.id("newPassword");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By btnChangePassword = By.xpath("//input[@value='Change Password']");
    private final By lblConfirmPasswordError = By.xpath("//label[@for='confirmPassword' and @class='validation-error']");

    //Elements
    public WebElement getCurrentPasswordElement() {
        return Constant.WEBDRIVER.findElement(txtCurrentPassword);
    }

    public WebElement getNewPasswordElement() {
        return Constant.WEBDRIVER.findElement(txtNewPassword);
    }

    public WebElement getConfirmPasswordElement() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    public WebElement getChangePasswordElement() {
        return Constant.WEBDRIVER.findElement(btnChangePassword);
    }

    public WebElement getConfirmPasswordErrorElement() {
        return Constant.WEBDRIVER.findElement(lblConfirmPasswordError);
    }

    //Methods
    public String getConfirmPasswordError() {
        return getConfirmPasswordErrorElement().getText();
    }

    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        this.getCurrentPasswordElement().sendKeys(currentPassword);
        this.getNewPasswordElement().sendKeys(newPassword);
        this.getConfirmPasswordElement().sendKeys(confirmPassword);
        this.getChangePasswordElement().click();
    }

    //Methods support checkpoint
}
