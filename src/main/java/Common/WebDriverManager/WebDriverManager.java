package Common.WebDriverManager;

import Common.Constant.Constant;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
    ChromeDriver driver;

    public WebDriverManager() {
        driver = new ChromeDriver();
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void navigate() {
        driver.navigate().to(Constant.RAILWAY_URL);
    }

    public WebElement findElement(By locator) {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        } catch (StaleElementReferenceException ex) {
            System.out.println(ex.getMessage());
        }
        return element;
    }

    public void quit() {
        driver.quit();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public Alert switchToAlert() {
        return driver.switchTo().alert();
    }
}
