package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    //Locators
    private final By _txtUsername = By.id("username");
    private final By _txtPassword = By.id("password");
    private final By _btnLogin = By.xpath("//input[@value='Login']");
    private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By _tabSelectedLogin = By.xpath("//li[@class='selected']/a[contains(.,'Login')]");

    //Elements
    public WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    public WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }

    public WebElement getLblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }

    public WebElement getTabSelectedLogin() {
        return Constant.WEBDRIVER.findElement(_tabSelectedLogin);
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

    public boolean isLoginOpen() {
        if (isElementExists(_tabSelectedLogin)) {
            return true;
        }
        else
            return false;
    }
}
