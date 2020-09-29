package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

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
    @FindBy(id = "autoCompleteSingle")
    public WebElement downerPartText;
    @FindBy(xpath = "//div[@id='autoCompleteSingleContainer']")
    public WebElement dowerPartTextBox;
    @FindBy(xpath = "//div[@class='css-xb97g8 auto-complete__multi-value__remove']")
    public WebElement upperColorDelete;
    @FindBy(xpath = "//div[@class='css-1rhbuit-multiValue auto-complete__multi-value']")
    public WebElement upperColorTextControl;
    @FindBy(xpath = "//div[@class='auto-complete__single-value css-1uccc91-singleValue']")
    public WebElement downerTextBoxResult;
}
