package Testcases.Railway;

import Common.Constant.Constant;
import Model.Account;
import Model.Ticket;
import PageObjects.Railway.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FinalTest extends BaseTest {
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    RegisterPage registerPage = new RegisterPage();

    @BeforeMethod
    public void beforeMethod() {
        homePage.open();
        homePage.gotoRegisterPage();
        Account account = new Account();
        registerPage.register(account);

        homePage.gotoLoginPage();
        loginPage.login(account.getEmail(), account.getPassword());
    }

    @AfterMethod
    public void afterMethod() {
        homePage.logout();
    }

    @Test(description = "Final Test - User can book 1 ticket at a time")
    public void FinalTest_TC01() {
        homePage.gotoBookTicketPage();
        Ticket ticket
                = new Ticket(Constant.DATA_FINAL_DEPART_DATE
                , Constant.DATA_FINAL_DEPART_FROM
                , Constant.DATA_FINAL_ARRIVE_AT
                , Constant.DATA_FINAL_SEAT_TYPE);
        bookTicketPage.bookTicket(ticket, Constant.DATA_FINAL_TICKET_AMOUNT);

        String actualSuccessMsg = bookTicketPage.getBookedMsg();
        String expectedSuccessMsg = Constant.MSG_BOOKED_SUCCESSFULLY;
        Assert.assertEquals(actualSuccessMsg,expectedSuccessMsg,"Booked tickets successfully message is not displayed correctly.");

        String actualDepartDate = bookTicketPage.getDepartDate();
        String expectedDepartDate = Constant.DATA_FINAL_DEPART_DATE;
        Assert.assertEquals(actualDepartDate,expectedDepartDate,"Depart date is not displayed correctly.");

        String actualDepartFrom = bookTicketPage.getDepartFrom();
        String expectedDepartFrom = Constant.DATA_FINAL_DEPART_FROM;
        Assert.assertEquals(actualDepartFrom,expectedDepartFrom,"Depart station is not displayed correctly.");

        String actualArriveAt = bookTicketPage.getArriveAt();
        String expectedArriveAt = Constant.DATA_FINAL_ARRIVE_AT;
        Assert.assertEquals(actualArriveAt,expectedArriveAt,"Arrive station is not displayed correctly.");

        String actualSeatType = bookTicketPage.getSeatType();
        String expectedSeatType = Constant.DATA_FINAL_SEAT_TYPE;
        Assert.assertEquals(actualSeatType,expectedSeatType,"Seat type is not displayed correctly.");

        String actualTicketAmount = bookTicketPage.getTicketAmount();
        String expectedTicketAmount = Constant.DATA_FINAL_TICKET_AMOUNT;
        Assert.assertEquals(actualTicketAmount,expectedTicketAmount,"Ticket amount is not displayed correctly.");
    }

    @Test(description = "Final Test - User can filter \"Manage ticket\" table with both Depart station and Depart date")
    public void FinalTest_TC02() {
        Ticket ticket = new Ticket();
        bookTicketPage.bookTicketSeveralTimes(ticket, Constant.DATA_TICKET_AMOUNT, Constant.DATA_BOOKED_TICKET_TIMES);

        bookTicketPage.gotoMyTicketPage();
        int numberRowsSatisfyConditions = myTicketPage.countRowsCondition(Constant.DATA_ARRIVE_AT, Constant.DATA_DEPART_DATE);

        myTicketPage.filter(Constant.DATA_ARRIVE_AT, Constant.DATA_DEPART_DATE);
        int numberRowsSatisfyConditionsFilterTable = myTicketPage.countRowsCondition(Constant.DATA_ARRIVE_AT, Constant.DATA_DEPART_DATE);
        int numberRowsFilterTable = myTicketPage.countAllRows();

        Assert.assertTrue(bookTicketPage.isFilterCorrect(numberRowsSatisfyConditions, numberRowsFilterTable, numberRowsSatisfyConditionsFilterTable)
                , "Manage ticket table filters incorrect tickets");
    }

    @Test(description = "Final Test - User can cancel all ticket")
    public void FinalTest_TC03() {
        Ticket ticket = new Ticket();
        bookTicketPage.bookTicketSeveralTimes(ticket, Constant.DATA_TICKET_AMOUNT, Constant.DATA_BOOKED_TICKET_TIMES);

        bookTicketPage.gotoMyTicketPage();
        myTicketPage.cancelAllTickets();

        String actualErrorMsg = myTicketPage.getErrorMessage();
        String expectedErrorMsg = Constant.MSG_ERROR_CANCEL;
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg,"Manage ticket page displays incorrect error message");

        String actualNoteMsg = myTicketPage.getNoteMessage();
        String expectedNoteMsg = Constant.MSG_NOTE_CANCEL;
        Assert.assertEquals(actualNoteMsg, expectedNoteMsg,"Note section displays incorrect message");
    }
}
