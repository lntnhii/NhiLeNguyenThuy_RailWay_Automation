package PageObjects.Railway;

import Common.Constant.Constant;
import Common.WebDriverManager.WebDriverManager;

public class HomePage extends GeneralPage {
    //Locators

    //Elements

    //Methods
    public HomePage open() {
        Constant.WEBDRIVER.navigate();
        return this;
    }

    //Methods support checkpoint
}
