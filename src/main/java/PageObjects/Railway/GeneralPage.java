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
    private final By lblWelcomeUser = By.xpath("//div[@class='account']/strong");

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
        if (Utilities.isElementExists(tabLogout))
            this.getTabLogout().click();
    }

    public void gotoBookTicketPage() {
        this.getTabBookTicket().click();
    }
}
