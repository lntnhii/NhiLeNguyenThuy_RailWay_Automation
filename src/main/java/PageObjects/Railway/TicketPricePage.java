package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends GeneralPage {
    //Locators
    private final By tableHeader = By.xpath("//tr[@class='TableSmallHeader']//th");
    private final By cellHs = By.xpath("//tr[contains(.,'Price')]//td[1]");
    private final By cellSs = By.xpath("//tr[contains(.,'Price')]//td[2]");
    private final By cellSsc = By.xpath("//tr[contains(.,'Price')]//td[3]");
    private final By cellHb = By.xpath("//tr[contains(.,'Price')]//td[4]");
    private final By cellSb = By.xpath("//tr[contains(.,'Price')]//td[5]");
    private final By cellSbc = By.xpath("//tr[contains(.,'Price')]//td[6]");

    //Elements
    protected WebElement getTableHeader() {
        return Constant.WEBDRIVER.findElement(tableHeader);
    }

    protected WebElement getCellHs() {
        return Constant.WEBDRIVER.findElement(cellHs);
    }

    protected WebElement getCellSs() {
        return Constant.WEBDRIVER.findElement(cellSs);
    }

    protected WebElement getCellSsc() {
        return Constant.WEBDRIVER.findElement(cellSsc);
    }

    protected WebElement getCellHb() {
        return Constant.WEBDRIVER.findElement(cellHb);
    }

    protected WebElement getCellSb() {
        return Constant.WEBDRIVER.findElement(cellSb);
    }

    protected WebElement getCellSbc() {
        return Constant.WEBDRIVER.findElement(cellSbc);
    }

    //Methods

    //Methods support checkpoint
    public String getHeaderTicketPrice() {
        return getTableHeader().getText();
    }

    public String getHsPrice() {
        return getCellHs().getText();
    }

    public String getSsPrice() {
        return getCellSs().getText();
    }

    public String getSscPrice() {
        return getCellSsc().getText();
    }

    public String getHbPrice() {
        return getCellHb().getText();
    }

    public String getSbPrice() {
        return getCellSb().getText();
    }

    public String getSbcPrice() {
        return getCellSbc().getText();
    }

}
