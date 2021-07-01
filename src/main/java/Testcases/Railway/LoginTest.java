package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.GeneralPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import com.google.common.base.Verify;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath());
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        Constant.WEBDRIVER.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-conditions");
        homePage.open();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");


    }

    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");

        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String actualMsg = homePage.getWelcomeUser();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Verify.verify(actualMsg.equals(expectedMsg),"Welcome is not displayed as expected");

        GeneralPage generalPage = new GeneralPage();
        generalPage.logout();
    }

    @Test
    public void TC02() {
        System.out.println("TC02 - User can't login with blank \"Username\" textbox");

        homePage.gotoLoginPage();
        loginPage.login("", Constant.PASSWORD);

        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Verify.verify(actualMsg.equals(expectedMsg),"Message is not displayed as expected");
    }

    @Test
    public void TC03() {
        System.out.println("TC03 - User cannot log into Railway with invalid password");

        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, "");

        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Verify.verify(actualMsg.equals(expectedMsg),"Message is not displayed as expected");
    }

    @Test
    public void TC04() {
        System.out.println("TC04 - User is redirected to Book ticket page after logging in");

        homePage.gotoBookTicketPage();
        Verify.verify(loginPage.isLoginOpen(),"Page is not displayed as expected");

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        Verify.verify(bookTicketPage.isBookTicketOpen(),"Page is not displayed as expected");
        Verify.verify(bookTicketPage.isBookTicketFormDisplay(),"Form is not displayed as expected");
    }

    @Test
    public void TC05() {
        System.out.println("TC05 - System shows message when user enters wrong password several times");

        homePage.gotoLoginPage();

        for (int i=0; i<4; i++) {
            loginPage.login(Constant.USERNAME, "ahihidongoc");
        }

        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

        Verify.verify(actualMsg.equals(expectedMsg),"Message is not displayed as expected");
    }
}
