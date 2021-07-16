package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Model.Ticket;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.MyTicketPage;
import PageObjects.Railway.TicketPricePage;
import PageObjects.Railway.TimetablePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookTicketTest extends BaseTest {
    BookTicketPage bookTicketPage = new BookTicketPage();
    TimetablePage timetablePage = new TimetablePage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    MyTicketPage myTicketPage = new MyTicketPage();

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
        Ticket ticket = new Ticket();
        bookTicketPage.bookTicket(ticket, Constant.DATA_TICKET_AMOUNT);

        String actualMsg = bookTicketPage.getBookedMsg();
        String expectedMsg = Constant.MSG_BOOKED_SUCCESSFULLY;
        Assert.assertEquals(actualMsg,expectedMsg,"Booked tickets successfully message is not displayed correctly.");

        String actualDepartDate = bookTicketPage.getDepartDate();
        String expectedDepartDate = Constant.DATA_DEPART_DATE;
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

    @Test(description = "TC15 - \"Ticket price\" page displays with ticket details after clicking on \"check price\" link in \"Train timetable\" page")
    public void TC15() {
        homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        homePage.gotoTimetablePage();

        timetablePage.checkPrice(Constant.DATA_TIMETABLE_DEPART_FROM, Constant.DATA_TIMETABLE_ARRIVE_AT);

        Assert.assertTrue(Utilities.isPageOpened(Constant.TICKET_PRICE), "Ticket price page is not displayed");

        String actualHeader = ticketPricePage.getHeaderTicketPrice();
        String expectedHeader = Constant.DATA_HEADER_TICKET_PRICE;
        Assert.assertEquals(actualHeader, expectedHeader, "Header of ticket table is not displayed correctly");

        String actualHsPrice = ticketPricePage.getHsPrice();
        String expectedHsPrice = Constant.DATA_HS_PRICE;
        Assert.assertEquals(actualHsPrice, expectedHsPrice, "HS price is not displayed correctly");

        String actualSsPrice = ticketPricePage.getSsPrice();
        String expectedSsPrice = Constant.DATA_SS_PRICE;
        Assert.assertEquals(actualSsPrice, expectedSsPrice, "SS price is not displayed correctly");

        String actualSscPrice = ticketPricePage.getSscPrice();
        String expectedSscPrice = Constant.DATA_SSC_PRICE;
        Assert.assertEquals(actualSscPrice, expectedSscPrice, "SSC price is not displayed correctly");

        String actualHbPrice = ticketPricePage.getHbPrice();
        String expectedHbPrice = Constant.DATA_HB_PRICE;
        Assert.assertEquals(actualHbPrice, expectedHbPrice, "HB price is not displayed correctly");

        String actualSbPrice = ticketPricePage.getSbPrice();
        String expectedSbPrice = Constant.DATA_SB_PRICE;
        Assert.assertEquals(actualSbPrice, expectedSbPrice, "SB price is not displayed correctly");

        String actualSbcPrice = ticketPricePage.getSbcPrice();
        String expectedSbcPrice = Constant.DATA_SBC_PRICE;
        Assert.assertEquals(actualSbcPrice, expectedSbcPrice, "SBC price is not displayed correctly");
    }

    @Test(description = "TC16 - User can cancel a ticket")
    public void TC16() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        homePage.gotoBookTicketPage();
        Ticket ticket = new Ticket();
        bookTicketPage.bookTicket(ticket, Constant.DATA_TICKET_AMOUNT);

        bookTicketPage.gotoMyTicketPage();
        myTicketPage.cancelOneTicket(Constant.DATA_CANCEL_ROW);

        Assert.assertTrue(!myTicketPage.isTicketExist(Constant.DATA_CANCEL_ID), "Ticket still exist after cancel");
    }
}
