package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //Locators
    private final By tabLogin = By.linkText("Login");
    private final By tabLogout = By.linkText("Log out");
    private final By tabBookTicket = By.linkText("Book ticket");
    private final By tabContact = By.linkText("Contact");
    private final By tabRegister = By.linkText("Register");
    private final By tabChangePassword = By.linkText("Change password");
    private final By lblWelcomeUser = By.xpath("//div[@class='account']//strong");

    //Elements
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    protected WebElement getTabContact() {
        return Constant.WEBDRIVER.findElement(tabContact);
    }

    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getTabChangePassword() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }

    protected WebElement getLblWelcomeUser() {
        return Constant.WEBDRIVER.findElement(lblWelcomeUser);
    }

    //Methods
    public String getWelcomeUser() {
        return this.getLblWelcomeUser().getText();
    }

    public void gotoLoginPage() {
        this.getTabLogin().click();
    }

    public void logout() {
        //if (Utilities.isElementExist(tabLogout))
        if (Utilities.isElementExist(getTabLogout()))
            this.getTabLogout().click();
    }

    public void gotoBookTicketPage() {
        this.getTabBookTicket().click();
    }

    public void gotoContactPage() {
        this.getTabContact().click();
    }

    public void gotoRegisterPage() {
        this.getTabRegister().click();
    }

    public void gotoChangePasswordPage() {
        this.getTabChangePassword().click();
    }

    //Methods support checkpoint
    public boolean isLogoutTabDisplayed() {
        //return Utilities.isElementExist(tabLogout);
        return Utilities.isElementExist(getTabLogout());
    }
}
