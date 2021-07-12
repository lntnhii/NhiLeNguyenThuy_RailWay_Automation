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
    public WebElement getUsernameElement() {
        return Constant.WEBDRIVER.findElement(txtUsername);
    }

    public WebElement getPasswordElement() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    public WebElement getLoginElement() {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    public WebElement getLoginErrorMsgElement() {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
    }

    public WebElement getForgotPasswordElement() {
        return Constant.WEBDRIVER.findElement(linkForgotPassword);
    }

    //Methods
    public String getLoginErrorMessage() {
        return getLoginErrorMsgElement().getText();
    }

    public void login(String username, String password) {
        this.getUsernameElement().sendKeys(username);
        this.getPasswordElement().sendKeys(password);

        Constant.WEBDRIVER.scrollIntoView(getLoginElement());
        this.getLoginElement().click();
    }

    public void loginSeveralTimes(String username, String password, int times) {
        for (int i=0; i<times; i++) {
            login(username, password);
        }
    }

    public void gotoForgetPasswordPage() {
        this.getForgotPasswordElement().click();
    }

    //Methods support checkpoint
}
