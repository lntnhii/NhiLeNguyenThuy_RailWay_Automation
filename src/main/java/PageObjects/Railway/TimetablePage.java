package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends GeneralPage {
    //Locators
    private By linkCheckPrice = null;

    //Elements
    public WebElement getLinkCheckPrice() {
        return Constant.WEBDRIVER.findElement(linkCheckPrice);
    }

    //Methods
    public void checkPrice(String departStation, String arriveStation) {
        String xpathLink
                = String.format("//td[.='%s']//following-sibling::td[.='%s']//following-sibling::td//a[.='check price']"
                                , departStation
                                , arriveStation);
        linkCheckPrice = By.xpath(xpathLink);

        Constant.WEBDRIVER.scrollIntoView(getLinkCheckPrice());
        getLinkCheckPrice().click();
    }

    //Methods support checkpoint
}
