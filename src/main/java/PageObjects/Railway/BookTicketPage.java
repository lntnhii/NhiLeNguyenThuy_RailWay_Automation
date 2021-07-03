package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;

public class BookTicketPage extends GeneralPage {
    //Locators
    private final By _tabSelected = By.xpath("//li[@class='selected']/a[contains(.,'Book ticket')]");
    private final By _formBookTicket = By.xpath("//form[contains(.,'Book ticket form')]");

    //Elements

    //Methods
    public boolean isBookTicketOpen() {
        return Constant.WEBDRIVER.getTitle().contains("Book Ticket");
    }

    public boolean isBookTicketFormDisplay() {
        return Utilities.isElementExists(_formBookTicket);
    }
}
