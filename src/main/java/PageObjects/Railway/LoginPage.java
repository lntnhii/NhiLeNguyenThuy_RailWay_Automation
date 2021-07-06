package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    //Locators
    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//input[@value='Login']");
    private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By linkForgotPassword = By.xpath("//a[contains(.,'Forgot Password')]");

    //Elements
    public WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(txtUsername);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    public WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    public WebElement getLblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
    }

    public WebElement getLinkForgotPassword() {
        return Constant.WEBDRIVER.findElement(linkForgotPassword);
    }

    //Methods
    public String getLoginErrorMessage() {
        return getLblLoginErrorMsg().getText();
    }

    public void login(String username, String password) {
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
    }

    public void loginSeveralTimes(String username, String password, int times) {
        for (int i=0; i<times; i++) {
            login(username, password);
        }
    }

    public void gotoForgetPasswordPage() {
        this.getLinkForgotPassword().click();
    }

    //Methods support checkpoint
}
