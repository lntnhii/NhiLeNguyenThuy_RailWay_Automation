package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends GeneralPage {
    //Locators
    private final By formBookTicket = By.xpath("//form[contains(.,'Book ticket form')]");

    //Elements
    public WebElement getFormBookTicket() {
        return Constant.WEBDRIVER.findElement(formBookTicket);
    }

    //Methods

    //Methods support checkpoint
    public boolean isBookTicketFormDisplayed() {
        return Utilities.isElementExist(getFormBookTicket());
    }
}
