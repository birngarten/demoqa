package pagesDemoqa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US023Page {
    public US023Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[4]")
    public WebElement widgetsCard;
    @FindBy(xpath = "//*[.='Select Menu']")
    public WebElement selectMenuLink;
    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement pageHeader;
    @FindBy(id = "withOptGroup")
    public WebElement firstDropbox;
    @FindBy(id = "selectOne")
    public WebElement secondDropbox;
    @FindBy(xpath = "//div[@class=' css-1uccc91-singleValue']")
    public WebElement result;
    @FindBy(xpath = "//select[@id='oldSelectMenu']")
    public WebElement colorDropbox;
    @FindBy(xpath = "(//div[@class=' css-yk16xz-control'])[3]")
    public WebElement multiSelectBox;
    @FindBy(xpath = "//div[@style='overflow: hidden; white-space: nowrap; width: 69.4px;']")
    public WebElement multiSelectResult;
    @FindBy(xpath = "//b")
    public List<WebElement> multiAndStandartTitles;


}
