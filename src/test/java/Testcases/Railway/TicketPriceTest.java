package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.TicketPricePage;
import PageObjects.Railway.TimetablePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TicketPriceTest extends BaseTest {
    TimetablePage timetablePage = new TimetablePage();
    TicketPricePage ticketPricePage = new TicketPricePage();

    @Test(description = "TC15 - \"Ticket price\" page displays with ticket details after clicking on \"check price\" link in \"Train timetable\" page ")
    public void TC15() {
        homePage.open();
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

        homePage.logout();
    }
}
