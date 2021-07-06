package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends GeneralPage {
    //Locators
    private final By txtEmail = By.id("email");
    private final By btnSendInstructions = By.xpath("//input[@value='Send Instructions']");

    //Elements
    public WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }
    public WebElement getBtnSendInstructions() {
        return Constant.WEBDRIVER.findElement(btnSendInstructions);
    }

    //Methods
    public void requestResetPassword(String email) {
        this.getTxtEmail().sendKeys(email);
        this.getBtnSendInstructions().click();
    }

    //Methods support checkpoint
}
