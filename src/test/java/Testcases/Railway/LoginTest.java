package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.WebDriverManager.WebDriverManager;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath());
        WebDriverManager.getInstance().maximize();
    }

    @AfterClass
    public void afterClass() {
        Constant.WEBDRIVER.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        homePage.open();
    }

    @AfterMethod
    public void afterMethod() {
        homePage.logout();
    }

    @Test(description = "TC01 - User can log into Railway with valid username and password")
    public void TC01() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String actualMsg = homePage.getWelcomeUser();
        String expectedMsg = String.format(Constant.MSG_WELCOME_USER, Constant.USERNAME);

        Assert.assertEquals(actualMsg,expectedMsg,"Welcome user message is not displayed correctly");
    }

    @Test(description = "TC02 - User can't login with blank \"Username\" textbox")
    public void TC02() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.DATA_EMPTY_USERNAME, Constant.PASSWORD);

        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = Constant.MSG_PROBLEM_USERNAME_PASSWORD;

        Assert.assertEquals(actualMsg,expectedMsg,"Error message is not displayed correctly");
    }

    @Test(description = "TC03 - User cannot log into Railway with invalid password")
    public void TC03() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.DATA_INVALID_PASSWORD);

        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = Constant.MSG_INVALID_USERNAME_PASSWORD;

        Assert.assertEquals(actualMsg,expectedMsg,"Error message is not displayed correctly");
    }

    @Test(description = "TC04 - User is redirected to Book ticket page after logging in")
    public void TC04() {
        homePage.gotoBookTicketPage();
        Assert.assertTrue(loginPage.isLoginOpen(),"Login page is not displayed");

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        Assert.assertTrue(bookTicketPage.isBookTicketOpen(), "Book ticket page is not displayed");
        Assert.assertTrue(bookTicketPage.isBookTicketFormDisplay(),"Book ticket form is not displayed correctly");
    }

    @Test(description = "TC05 - System shows message when user enters wrong password several times")
    public void TC05() {
        homePage.gotoLoginPage();

        loginPage.loginSeveralTimes(Constant.USERNAME, Constant.DATA_INVALID_PASSWORD, 4);

        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = Constant.MSG_RUN_OUT_OF_TRY_LOGIN;

        Assert.assertEquals(actualMsg,expectedMsg,"Error message is not displayed correctly");
    }
}
