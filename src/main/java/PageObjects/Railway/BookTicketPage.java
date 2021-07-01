package PageObjects.Railway;

import org.openqa.selenium.By;

public class BookTicketPage {
    //Locators
    private final By _tabSelected = By.xpath("//li[@class='selected']/a[contains(.,'Book ticket')]");
    private final By _formBookTicket = By.xpath("//form[contains(.,'Book ticket form')]");

    //Elements

    //Methods
    public boolean isBookTicketOpen() {
        if (GeneralPage.isElementExists(_tabSelected)) {
            return true;
        }
        else
            return false;
    }

    public boolean isBookTicketFormDisplay() {
        if (GeneralPage.isElementExists(_formBookTicket)) {
            return true;
        }
        else
            return false;
    }
}
