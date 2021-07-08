package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookTicketTest extends BaseTest {
    BookTicketPage bookTicketPage = new BookTicketPage();

    @BeforeMethod
    public void beforeMethod() {
        homePage.open();
    }

    @AfterMethod
    public void afterMethod() {
        homePage.logout();
    }

    @Test(description = "TC04 - User is redirected to Book ticket page after logging in")
    public void TC04() {
        homePage.gotoBookTicketPage();

        Assert.assertTrue(Utilities.isPageOpened(Constant.LOGIN),"Login page is not displayed");

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        Assert.assertTrue(Utilities.isPageOpened(Constant.BOOK_TICKET), "Book ticket page is not displayed");
        Assert.assertTrue(bookTicketPage.isBookTicketFormDisplayed(),"Book ticket form is not displayed correctly");
    }

    @Test(description = "TC14 - User can book 1 ticket at a time")
    public void TC14() {
        homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        homePage.gotoBookTicketPage();

        String departDate = bookTicketPage.setDepartDate(Constant.DATA_NUMBER_OF_DAYS_AFTER);
        bookTicketPage.bookTicket(departDate
                , Constant.DATA_DEPART_FROM
                , Constant.DATA_ARRIVE_AT
                , Constant.DATA_SEAT_TYPE
                , Constant.DATA_TICKET_AMOUNT);

        String actualMsg = bookTicketPage.getBookedMsg();
        String expectedMsg = Constant.MSG_BOOKED_SUCCESSFULLY;
        Assert.assertEquals(actualMsg,expectedMsg,"Booked tickets successfully message is not displayed correctly.");

        String actualDepartDate = bookTicketPage.getDepartDate();
        String expectedDepartDate = departDate;
        Assert.assertEquals(actualDepartDate,expectedDepartDate,"Depart date is not displayed correctly.");

        String actualDepartFrom = bookTicketPage.getDepartFrom();
        String expectedDepartFrom = Constant.DATA_DEPART_FROM;
        Assert.assertEquals(actualDepartFrom,expectedDepartFrom,"Depart station is not displayed correctly.");

        String actualArriveAt = bookTicketPage.getArriveAt();
        String expectedArriveAt = Constant.DATA_ARRIVE_AT;
        Assert.assertEquals(actualArriveAt,expectedArriveAt,"Arrive station is not displayed correctly.");

        String actualSeatType = bookTicketPage.getSeatType();
        String expectedSeatType = Constant.DATA_SEAT_TYPE;
        Assert.assertEquals(actualSeatType,expectedSeatType,"Seat type is not displayed correctly.");

        String actualTicketAmount = bookTicketPage.getTicketAmount();
        String expectedTicketAmount = Constant.DATA_TICKET_AMOUNT;
        Assert.assertEquals(actualTicketAmount,expectedTicketAmount,"Ticket amount is not displayed correctly.");
    }
}
