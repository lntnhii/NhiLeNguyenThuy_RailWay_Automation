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
    protected WebElement getFormBookTicket() {
        return Constant.WEBDRIVER.findElement(formBookTicket);
    }

    protected WebElement getDepartDateElement() {
        return Constant.WEBDRIVER.findElement(cbbDepartDate);
    }

    protected WebElement getDepartFromElement() {
        return Constant.WEBDRIVER.findElement(cbbDepartFrom);
    }

    protected WebElement getArriveAtElement() {
        return Constant.WEBDRIVER.findElement(cbbArriveAt);
    }

    protected WebElement getSeatTypeElement() {
        return Constant.WEBDRIVER.findElement(cbbSeatType);
    }

    protected WebElement getTicketAmountElement() {
        return Constant.WEBDRIVER.findElement(cbbTicketAmount);
    }

    protected WebElement getBookTicketElement() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    protected WebElement getBookedMsgElement() {
        return Constant.WEBDRIVER.findElement(lblBookedMsg);
    }

    protected WebElement getCellDepartDate() {
        return Constant.WEBDRIVER.findElement(cellDepartDate);
    }

    protected WebElement getCellDepartFrom() {
        return Constant.WEBDRIVER.findElement(cellDepartFrom);
    }

    protected WebElement getCellArriveAt() {
        return Constant.WEBDRIVER.findElement(cellArriveAt);
    }

    protected WebElement getCellSeatType() {
        return Constant.WEBDRIVER.findElement(cellSeatType);
    }

    protected WebElement getCellTicketAmount() {
        return Constant.WEBDRIVER.findElement(cellTicketAmount);
    }

    //Methods
    public void bookTicket(Ticket ticket, String ticketAmount) {
        Constant.WEBDRIVER.scrollIntoView(getBookTicketElement());

        if (ticket != null) {
            if (!ticket.getDepartDate().isEmpty())
                Utilities.selectCombobox(getDepartDateElement(), ticket.getDepartDate());
            if (!ticket.getDepartFrom().isEmpty())
                Utilities.selectCombobox(getDepartFromElement(), ticket.getDepartFrom());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!ticket.getArriveAt().isEmpty())
                Utilities.selectCombobox(getArriveAtElement(), ticket.getArriveAt());
            if (!ticket.getSeatType().isEmpty())
                Utilities.selectCombobox(getSeatTypeElement(), ticket.getSeatType());
        }
        if (!ticketAmount.isEmpty())
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

    public void bookTicketSeveralTimes(Ticket ticket, String amountTicketPerTime, int times) {
        for (int i=0; i< times; i++) {
            GeneralPage generalPage = new GeneralPage();
            generalPage.gotoBookTicketPage();

            ticket.setDepartDate(Utilities.plusDateFromToday(Constant.DATA_NUMBER_OF_DAYS_AFTER + i));
            bookTicket(ticket, amountTicketPerTime);
        }
    }

    //Methods support checkpoint
    public boolean isBookTicketFormDisplayed() {
        return Utilities.isElementDisplayed(getFormBookTicket());
    }

    /*
    * numberRowsSatisfyConditions stands for numbers of row which satisfy filter conditions before applying filter
    * numberRowsFilterTable stands for total numbers of row of ticket table after filter
    * numberRowsSatisfyConditionsFilterTable stands for numbers of row which satisfy filter conditions after applying filter
    * */
    public boolean isFilterCorrect(int numberRowsSatisfyConditions, int numberRowsFilterTable, int numberRowsSatisfyConditionsFilterTable) {
        // Table after filter must display all of satisfying-conditions rows exist on table before filter
        if (numberRowsSatisfyConditions != numberRowsFilterTable)
            return false;

        // All rows of filter table must be the satisfying-conditions row
        if (numberRowsFilterTable != numberRowsSatisfyConditionsFilterTable)
            return false;
        return true;
    }
}
