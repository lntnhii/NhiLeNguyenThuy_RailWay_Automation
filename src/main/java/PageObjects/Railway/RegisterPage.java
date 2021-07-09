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
    private final By txtPID = By.id("pid");
    private final By btnRegister = By.xpath("//input[@value='Register']");
    private final By lblRegisterMsg = By.xpath("//div[@id='content']//p");
    private final By lblRegisterErrorMsg = By.xpath("//p[@class='message error']");
    private final By lblPasswordErrorMsg = By.xpath("//label[@for='password' and @class='validation-error']");
    private final By lblPidErrorMsg = By.xpath("//label[@for='pid' and @class='validation-error']");

    //Elements
    public WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    public WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    public WebElement getTxtPID() {
        return Constant.WEBDRIVER.findElement(txtPID);
    }

    public WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }

    public WebElement getLblRegisterMsg() {
        return Constant.WEBDRIVER.findElement(lblRegisterMsg);
    }

    public WebElement getLblRegisterErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblRegisterErrorMsg);
    }

    public WebElement getLblPasswordErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblPasswordErrorMsg);
    }

    public WebElement getLblPidErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblPidErrorMsg);
    }

    //Methods
    public void register(Account account) {
        this.getTxtEmail().sendKeys(account.getEmail());
        this.getTxtPassword().sendKeys(account.getPassword());
        this.getTxtConfirmPassword().sendKeys(account.getConfirmPassword());
        this.getTxtPID().sendKeys(account.getPid());

        Constant.WEBDRIVER.scrollIntoView(getBtnRegister());
        this.getBtnRegister().click();
    }

    public String getRegisterMsg() {
        return this.getLblRegisterMsg().getText();
    }

    public String getRegisterErrorMsg() {
        return this.getLblRegisterErrorMsg().getText();
    }

    public String getPasswordErrorMsg() {
        return this.getLblPasswordErrorMsg().getText();
    }

    public String getPidErrorMsg() {
        return this.getLblPidErrorMsg().getText();
    }

    //Methods support checkpoint
}
