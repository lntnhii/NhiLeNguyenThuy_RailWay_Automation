package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BookTicketPage extends GeneralPage {
    //Locators
    private final By formBookTicket = By.xpath("//form[contains(.,'Book ticket form')]");
    private final By cbbDepartDate = By.xpath("//select[@name='Date']");
    private final By cbbDepartFrom = By.xpath("//select[@name='DepartStation']");
    private final By cbbArriveAt = By.xpath("//select[@name='ArriveStation']");
    private final By cbbSeatType = By.xpath("//select[@name='SeatType']");
    private final By cbbTicketAmount = By.xpath("//select[@name='TicketAmount']");
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

    public WebElement getCbbDepartDate() {
        return Constant.WEBDRIVER.findElement(cbbDepartDate);
    }

    public WebElement getCbbDepartFrom() {
        return Constant.WEBDRIVER.findElement(cbbDepartFrom);
    }

    public WebElement getCbbArriveAt() {
        return Constant.WEBDRIVER.findElement(cbbArriveAt);
    }

    public WebElement getCbbSeatType() {
        return Constant.WEBDRIVER.findElement(cbbSeatType);
    }

    public WebElement getCbbTicketAmount() {
        return Constant.WEBDRIVER.findElement(cbbTicketAmount);
    }

    public WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    public WebElement getLblBookedMsg() {
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
    public void bookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        Constant.WEBDRIVER.scrollIntoView(getBtnBookTicket());

        Utilities.selectCombobox(getCbbDepartDate(), departDate);
        Utilities.selectCombobox(getCbbDepartFrom(), departFrom);
        Utilities.selectCombobox(getCbbArriveAt(), arriveAt);
        Utilities.selectCombobox(getCbbSeatType(), seatType);
        Utilities.selectCombobox(getCbbTicketAmount(), ticketAmount);
        this.getBtnBookTicket().click();
    }

    public String getBookedMsg() {
        return this.getLblBookedMsg().getText();
    }

    public String setDepartDate(int numberOfDaysAfter) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, numberOfDaysAfter);
        dt = c.getTime();
        return dateFormat.format(dt);
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
