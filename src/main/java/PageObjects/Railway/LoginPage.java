package PageObjects.Railway;

import Common.Constant.Constant;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    //Locators
    private final By _txtUsername = By.id("username");
    private final By _txtPassword = By.id("password");
    private final By _btnLogin = By.xpath("//input[@value='Login']");
    private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By _selectedLogin = By.xpath("//li[@class='selected']//a[contains(.,'Login')]");
//tabselectedlogin
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

    public WebElement getSelectedLogin() {
        return Constant.WEBDRIVER.findElement(_selectedLogin);
    }

    //Methods
    public String getLoginErrorMessage() {
        return getLblLoginErrorMsg().getText();
    }

    public GeneralPage login(String username, String password) {
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
//        boolean isPresent = Constant.WEBDRIVER.findElement(_selectedLogin).isDisplayed();
//        if (isPresent)
//            return new LoginPage();
        if (isElementPresent(_selectedLogin)) {
            return new LoginPage();
        }
        return new HomePage();
    }

    public boolean isElementPresent(By locatorKey) {
        try {
            Constant.WEBDRIVER.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
