package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.WebDriverManager.WebDriverManager;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath());
        //Constant.driver = new ChromeDriver();
        //Constant.WEBDRIVER = WebDriverManager.getInstance();
        Constant.WEBDRIVER = new WebDriverManager();
        //webDriverManager = new WebDriverManager();
        //Constant.WEBDRIVER = webDriverManager;
        /*Constant.driver.navigate().to(Constant.RAILWAY_URL);
        Constant.driver.manage().window().maximize();*/
        Constant.WEBDRIVER.maximize();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        Constant.WEBDRIVER.quit();
    }
}
