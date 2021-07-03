package PageObjects.Railway;

import Common.WebDriverManager.WebDriverManager;

public class HomePage extends GeneralPage {
    //Locators

    //Elements

    //Methods
    public HomePage open() {
        WebDriverManager.getInstance().navigate();
        return this;
    }
}
