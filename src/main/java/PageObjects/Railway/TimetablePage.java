package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends GeneralPage {
    //Locators

    //Elements

    //Methods
    public void checkPrice(String departStation, String arriveStation) {
        String xpathLink
                = String.format("//td[.='%s']//following-sibling::td[.='%s']//following-sibling::td//a[.='check price']"
                                , departStation
                                , arriveStation);
        By linkCheckPrice = By.xpath(xpathLink);
        WebElement getLinkCheckPrice = Constant.WEBDRIVER.findElement(linkCheckPrice);

        Constant.WEBDRIVER.scrollIntoView(getLinkCheckPrice);
        getLinkCheckPrice.click();
    }

    //Methods support checkpoint
}
