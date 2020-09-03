package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DemogaWebTablesButtonsLinksPage {
    public DemogaWebTablesButtonsLinksPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href='https://demoqa.com']")
    public WebElement mainPage;
    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[1]")
    public WebElement elementsCard;
    @FindBy(id = "item-3")
    public WebElement webTables;

}
