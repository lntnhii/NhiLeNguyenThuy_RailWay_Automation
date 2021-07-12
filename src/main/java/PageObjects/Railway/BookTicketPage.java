package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Model.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends GeneralPage {
    //Locators
    private final By formBookTicket = By.xpath("//form[contains(.,'Book ticket form')]");
    private final By cbbDepartDate = By.name("Date");
    private final By cbbDepartFrom = By.name("DepartStation");
    private final By cbbArriveAt = By.name("ArriveStation");
    private final By cbbSeatType = By.name("SeatType");
    private final By cbbTicketAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");

    private final By lblBookedMsg = By.cssSelector("h1");
    private final By cellDepartDate = By.xpath("//table[@class='MyTable WideTable']//td[4]");
    private final By cellDepartFrom = By.xpath("//table[@class='MyTable WideTable']//td[1]");
    private final By cellArriveAt = By.xpath("//table[@class='MyTable WideTable']//td[2]");
    private final By cellSeatType = By.xpath("//table[@class='MyTable WideTable']//td[3]");
    private final By cellTicketAmount = By.xpath("//table[@class='MyTable WideTable']//td[7]");

    //Elements
    public WebElement getFormBookTicket() {
        return Constant.WEBDRIVER.findElement(formBookTicket);
    }

    public WebElement getDepartDateElement() {
        return Constant.WEBDRIVER.findElement(cbbDepartDate);
    }

    public WebElement getDepartFromElement() {
        return Constant.WEBDRIVER.findElement(cbbDepartFrom);
    }

    public WebElement getArriveAtElement() {
        return Constant.WEBDRIVER.findElement(cbbArriveAt);
    }

    public WebElement getSeatTypeElement() {
        return Constant.WEBDRIVER.findElement(cbbSeatType);
    }

    public WebElement getTicketAmountElement() {
        return Constant.WEBDRIVER.findElement(cbbTicketAmount);
    }

    public WebElement getBookTicketElement() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    public WebElement getBookedMsgElement() {
        return Constant.WEBDRIVER.findElement(lblBookedMsg);
    }

    public WebElement getCellDepartDate() {
        return Constant.WEBDRIVER.findElement(cellDepartDate);
    }

    public WebElement getCellDepartFrom() {
        return Constant.WEBDRIVER.findElement(cellDepartFrom);
    }

    public WebElement getCellArriveAt() {
        return Constant.WEBDRIVER.findElement(cellArriveAt);
    }

    public WebElement getCellSeatType() {
        return Constant.WEBDRIVER.findElement(cellSeatType);
    }

    public WebElement getCellTicketAmount() {
        return Constant.WEBDRIVER.findElement(cellTicketAmount);
    }

    //Methods
    public void bookTicket(Ticket ticket, String ticketAmount) {
        Constant.WEBDRIVER.scrollIntoView(getBookTicketElement());

        Utilities.selectCombobox(getDepartDateElement(), ticket.getDepartDate());
        Utilities.selectCombobox(getDepartFromElement(), ticket.getDepartFrom());
        Utilities.selectCombobox(getArriveAtElement(), ticket.getArriveAt());
        Utilities.selectCombobox(getSeatTypeElement(), ticket.getSeatType());
        Utilities.selectCombobox(getTicketAmountElement(), ticketAmount);
        this.getBookTicketElement().click();
    }

    public String getBookedMsg() {
        return this.getBookedMsgElement().getText();
    }

    public String getDepartDate() {
        return this.getCellDepartDate().getText();
    }

    public String getDepartFrom() {
        return this.getCellDepartFrom().getText();
    }

    public String getArriveAt() {
        return this.getCellArriveAt().getText();
    }

    public String getSeatType() {
        return this.getCellSeatType().getText();
    }

    public String getTicketAmount() {
        return this.getCellTicketAmount().getText();
    }

    //Methods support checkpoint
    public boolean isBookTicketFormDisplayed() {
        return Utilities.isElementDisplayed(getFormBookTicket());
    }
}
