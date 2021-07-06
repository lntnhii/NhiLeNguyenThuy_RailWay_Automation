package Common.Common;

import Common.Constant.Constant;
import org.openqa.selenium.*;

import java.util.Random;

public class Utilities {
    public static String getProjectPath() {
        return "src/main/resources/Webdriver/chromedriver.exe";
    }

    public static String randomString() {
        String alphanum = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int length = alphanum.length();

        Random generator = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int number = generator.nextInt(length);
            char ch = alphanum.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }

    // General functions
    public static boolean isElementExists(By locator) {
        try {
            return Constant.WEBDRIVER.findElement(locator).isDisplayed();
        }
        catch (NoSuchElementException ex){
            return false;
        }
    }

    public static boolean isPageOpened(String pageName) {
        if (pageName.equals("Home")) {
            By lblWelcome = By.cssSelector("h1");
            String getLblWelcome = Constant.WEBDRIVER.findElement(lblWelcome).getText();
            return getLblWelcome.contains("Welcome to Safe Railway");
        }
        return Constant.WEBDRIVER.getTitle().contains(pageName);
    }
}
