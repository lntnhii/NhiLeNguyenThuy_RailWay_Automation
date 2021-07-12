package PageObjects.Railway;

import Common.Constant.Constant;
import Model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    //Locators
    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("password");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By txtPid = By.id("pid");
    private final By btnRegister = By.xpath("//input[@value='Register']");
    private final By lblRegisterMsg = By.xpath("//div[@id='content']//p");
    private final By lblRegisterErrorMsg = By.xpath("//p[@class='message error']");
    private final By lblPasswordErrorMsg = By.xpath("//label[@for='password' and @class='validation-error']");
    private final By lblPidErrorMsg = By.xpath("//label[@for='pid' and @class='validation-error']");

    //Elements
    public WebElement getEmailElement() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    public WebElement getPasswordElement() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    public WebElement getConfirmPasswordElement() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    public WebElement getPidElement() {
        return Constant.WEBDRIVER.findElement(txtPid);
    }

    public WebElement getRegisterElement() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }

    public WebElement getRegisterMsgElement() {
        return Constant.WEBDRIVER.findElement(lblRegisterMsg);
    }

    public WebElement getRegisterErrorMsgElement() {
        return Constant.WEBDRIVER.findElement(lblRegisterErrorMsg);
    }

    public WebElement getPasswordErrorMsgElement() {
        return Constant.WEBDRIVER.findElement(lblPasswordErrorMsg);
    }

    public WebElement getPidErrorMsgElement() {
        return Constant.WEBDRIVER.findElement(lblPidErrorMsg);
    }

    //Methods
    public void register(Account account) {
        this.getEmailElement().sendKeys(account.getEmail());
        this.getPasswordElement().sendKeys(account.getPassword());
        this.getConfirmPasswordElement().sendKeys(account.getConfirmPassword());
        this.getPidElement().sendKeys(account.getPid());

        Constant.WEBDRIVER.scrollIntoView(getRegisterElement());
        this.getRegisterElement().click();
    }

    public String getRegisterMsg() {
        return this.getRegisterMsgElement().getText();
    }

    public String getRegisterErrorMsg() {
        return this.getRegisterErrorMsgElement().getText();
    }

    public String getPasswordErrorMsg() {
        return this.getPasswordErrorMsgElement().getText();
    }

    public String getPidErrorMsg() {
        return this.getPidErrorMsgElement().getText();
    }

    //Methods support checkpoint
}
