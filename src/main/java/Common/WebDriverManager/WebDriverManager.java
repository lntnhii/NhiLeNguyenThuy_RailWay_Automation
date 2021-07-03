package Common.WebDriverManager;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
    ChromeDriver driver;
    private static WebDriverManager instance = null;

    private WebDriverManager() {
        driver = new ChromeDriver();
    }

    public static WebDriverManager getInstance() {
        if (instance == null)
            instance = new WebDriverManager();
        return instance;
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void navigate() {
        driver.navigate().to(Constant.RAILWAY_URL);
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void quit() {
        driver.quit();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
