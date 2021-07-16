package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.WebDriverManager.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {
    //Locators
    private By btnCancel = By.xpath("//input[@value='Cancel']");
    private final By selArriveStation = By.name("FilterArStation");
    private final By txtDepartDate = By.name("FilterDpDate");
    private final By btnApplyFilter = By.xpath("//input[@value='Apply Filter']");
    private final By lblErrorMessage = By.xpath("//div[@class='error message']");
    private final By lblNoteMessage = By.xpath("//div[@class='message']//li");

    //Elements
    protected WebElement getCancelElement() {
        return Constant.WEBDRIVER.findElement(btnCancel);
    }

    protected WebElement getArriveStationElement() {
        return Constant.WEBDRIVER.findElement(selArriveStation);
    }

    protected WebElement getDepartDateElement() {
        return Constant.WEBDRIVER.findElement(txtDepartDate);
    }

    protected WebElement getApplyFilterElement() {
        return Constant.WEBDRIVER.findElement(btnApplyFilter);
    }

    protected WebElement getErrorMessageElement() {
        return Constant.WEBDRIVER.findElement(lblErrorMessage);
    }

    protected WebElement getNoteMessageElement() {
        return Constant.WEBDRIVER.findElement(lblNoteMessage);
    }

    //Methods
    public void cancelOneTicket(String numberOfRow) {
        String xpathLink
                = String.format("//table[@class='MyTable']//td[1][.='%s']//following-sibling::td//input[@value='Cancel']", numberOfRow);
        btnCancel = By.xpath(xpathLink);

        Constant.WEBDRIVER.scrollIntoView(getCancelElement());
        Constant.DATA_CANCEL_ID = getTicketCancelId();
        getCancelElement().click();
        Utilities.confirmPopup();
    }

    public void cancelAllTickets() {
        int numberOfRows = Utilities.countRowTable(btnCancel);
        for (int i=0; i<numberOfRows; i++) {
            Constant.WEBDRIVER.scrollIntoView(getCancelElement());
            getCancelElement().click();
            Utilities.confirmPopup();
        }
    }

    public String getTicketCancelId() {
        return getCancelElement().getAttribute("onclick");
    }

    public void filter(String arriveStation, String departDate) {
        Utilities.selectCombobox(getArriveStationElement(), arriveStation);
        getDepartDateElement().sendKeys(departDate);

        getApplyFilterElement().click();
    }

    public int countRowsCondition(String arriveStation, String departDate) {
        String xpathString
                = String.format("//table[@class='MyTable']//td[3][.='%s']//following-sibling::td[.='%s']//ancestor::tr"
                , arriveStation
                , departDate);
        By conditionRow = By.xpath(xpathString);
        return Utilities.countRowTable(conditionRow);
    }

    public int countAllRows() {
        String xpathString
                = String.format("//table[@class='MyTable']//tr");
        By row = By.xpath(xpathString);
        return Utilities.countRowTable(row) -1;
    }

    public String getErrorMessage() {
        return getErrorMessageElement().getText();
    }

    public String getNoteMessage() {
        return getNoteMessageElement().getText();
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
