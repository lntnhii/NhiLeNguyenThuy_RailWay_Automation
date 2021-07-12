package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.WebDriverManager.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GeneralPage {
    //Locators
    private final By tabLogin = By.linkText("Login");
    private final By tabLogout = By.linkText("Log out");
    private final By tabBookTicket = By.linkText("Book ticket");
    private final By tabContact = By.linkText("Contact");
    private final By tabRegister = By.linkText("Register");
    private final By tabChangePassword = By.linkText("Change password");
    private final By tabTimeTable = By.linkText("Timetable");
    private final By tabMyTicket = By.linkText("My ticket");
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

    protected WebElement getTabTimetable() {
        return Constant.WEBDRIVER.findElement(tabTimeTable);
    }

    protected WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }

    protected WebElement getWelcomeUserElement() {
        return Constant.WEBDRIVER.findElement(lblWelcomeUser);
    }

    //Methods
    public String getWelcomeUser() {
        return this.getWelcomeUserElement().getText();
    }

    public void gotoLoginPage() {
        this.getTabLogin().click();
    }

    public void logout() {
        if (Utilities.isElementDisplayed(getTabLogout()))
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

    public void gotoTimetablePage() {
        this.getTabTimetable().click();
    }

    public void gotoMyTicketPage() {
        this.getTabMyTicket().click();
    }

    //Methods support checkpoint
    public boolean isLogoutTabDisplayed() {
        return Utilities.isElementDisplayed(getTabLogout());
    }
}
