package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US016Page {
    public US016Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[4]")
    public WebElement widgetsCard;
    @FindBy(xpath = "(//li[@class='btn btn-light '])[17]")
    public WebElement AutoCompleteLink;
    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement PageHeader;
    @FindBy(xpath = "//div[@id='autoCompleteMultiple']")
    public WebElement upperPartText;
    @FindBy(xpath = "//div[@id='autoCompleteMultipleContainer']")
    public WebElement upperPartTextBox;
    @FindBy(xpath = "//div[@id='autoCompleteSingle']")
    public WebElement downerPartText;
    @FindBy(xpath = "//div[@id='autoCompleteSingleContainer']")
    public WebElement dowerPartTextBox;
}
