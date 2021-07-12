package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {
    //Locators
    private By btnCancel = null;

    //Elements
    public WebElement getCancelElement() {
        return Constant.WEBDRIVER.findElement(btnCancel);
    }

    //Methods
    public void cancelTicket(String numberOfRow) {
        String xpathLink
                = String.format("//table[@class='MyTable']//td[1][.='%s']//following-sibling::td//input[@value='Cancel']", numberOfRow);
        btnCancel = By.xpath(xpathLink);

        Constant.WEBDRIVER.scrollIntoView(getCancelElement());
        Constant.DATA_CANCEL_ID = getTicketCancelId();
        getCancelElement().click();
        Utilities.confirmPopup();
    }

    public String getTicketCancelId() {
        return getCancelElement().getAttribute("onclick");
    }

    //Methods support checkpoint
    public boolean isTicketExist(String ticketCancelId) {
        String xpathLink = String.format("//input[@onclick='%s']", ticketCancelId);
        By btnCancel = By.xpath(xpathLink);
        WebElement element = Constant.WEBDRIVER.findElement(btnCancel);
        if (element == null)
            return false;
        return true;
    }
}
