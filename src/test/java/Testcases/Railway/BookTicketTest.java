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

    @Test(description = "TC04 - User is redirected to Book ticket page after logging in")
    public void TC04() {
        homePage.open();
        homePage.gotoBookTicketPage();

        Assert.assertTrue(Utilities.isPageOpened("Login"),"Login page is not displayed");

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        Assert.assertTrue(Utilities.isPageOpened("Book Ticket"), "Book ticket page is not displayed");
        Assert.assertTrue(bookTicketPage.isBookTicketFormDisplayed(),"Book ticket form is not displayed correctly");

        homePage.logout();
    }
}
