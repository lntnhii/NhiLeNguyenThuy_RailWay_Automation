package Common.Common;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    public static String randomEmail() {
        return "lntnhii" + randomString() + "@gmail.com";
    }

    public static String plusDateFromToday(int numberOfDaysAfter) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, numberOfDaysAfter);
        dt = c.getTime();
        return dateFormat.format(dt);
    }

    public static boolean isElementDisplayed(WebElement element) {
        try {
            boolean res = element.isDisplayed();
            return res;
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public static boolean isPageOpened(String pageName) {
        if (pageName.equals(Constant.HOME)) {
            By lblWelcome = By.cssSelector("h1");
            String getLblWelcome = Constant.WEBDRIVER.findElement(lblWelcome).getText();
            return getLblWelcome.equals("Welcome to Safe Railway");
        }
        return Constant.WEBDRIVER.getTitle().contains(pageName);
    }

    public static void selectCombobox(WebElement element, String valueText) {
        Select combobox = new Select(element);
        combobox.selectByVisibleText(valueText);
    }

    public static void confirmPopup() {
        Constant.WEBDRIVER.switchToAlert().accept();
    }
}
