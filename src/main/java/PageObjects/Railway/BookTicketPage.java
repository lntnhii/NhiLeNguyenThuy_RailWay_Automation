package PageObjects.Railway;

import Common.Common.Utilities;
import org.openqa.selenium.By;

public class BookTicketPage extends GeneralPage {
    //Locators
    private final By formBookTicket = By.xpath("//form[contains(.,'Book ticket form')]");

    //Elements

    //Methods

    //Methods support checkpoint
    public boolean isBookTicketFormDisplayed() {
        return Utilities.isElementExists(formBookTicket);
    }
}
