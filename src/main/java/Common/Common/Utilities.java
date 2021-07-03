package Common.Common;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class Utilities {
    public static String getProjectPath() {
        return "src/main/resources/Webdriver/chromedriver.exe";
    }

    public static boolean isElementExists(By locator) {
        try {
            return Constant.WEBDRIVER.findElement(locator).isDisplayed();
        }
        catch (NoSuchElementException ex){
            return false;
        }
    }
}
