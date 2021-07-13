package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.WebDriverManager.WebDriverManager;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath());
        Constant.WEBDRIVER = new WebDriverManager();
        Constant.WEBDRIVER.maximize();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        Constant.WEBDRIVER.quit();
    }
}
