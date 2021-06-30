package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //Locators
    private final By tabLogin = By.linkText("Login");
    private final By tabLogout = By.linkText("Log out");
    private final By lblWelcomeUser = By.xpath("//div[@class='account']/strong");

    //Elements
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getLblWelcomeUser() {
        return Constant.WEBDRIVER.findElement(lblWelcomeUser);
    }

    //Methods
    public String getWelcomeUser() {
        return this.getLblWelcomeUser().getText();
    }

    public LoginPage gotoLoginPage() {
        this.getTabLogin().click();
        return new LoginPage();
    }

    public HomePage logout() {
        this.getTabLogout().click();
        return new HomePage();
    }
}
