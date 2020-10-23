package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;
import java.util.Set;

public class US_30_Page {

    public US_30_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='card-up'])[6]")
    public WebElement bookStoreApplicationCard;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement bookStoreText;

    @FindBy(id = "searchBox")
    public WebElement searchBox;

    @FindBy(id = "login")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='rt-resizable-header-content']")
    public List <WebElement> firstRowElementList;

    @FindBy(xpath = "//div[@role='gridcell']")
    public List <WebElement> allData;

    @FindBy(xpath = "//span[@class='mr-2']/a")
    public WebElement bookNameSearchResult;

    @FindBy(xpath = "(//div[@role='gridcell'])[3]")
    public WebElement autorNameSearchResult;

    @FindBy(xpath = "(//div[@role='gridcell'])[4]")
    public WebElement publisherNameSearchResult;

    @FindBy(xpath = "//select[@aria-label='rows per page']")
    public WebElement rowSelectMenu;

    @FindBy(xpath = "//div[@class='rt-tr-group']")
    public List <WebElement> allRowsList;

    @FindBy(xpath = "//span[@class='mr-2']/a")
    public WebElement firstBookName;

    @FindBy(xpath = "//div[@class='col-md-3 col-sm-12']")
    public List <WebElement> bookLabelsList;

    @FindBy(xpath = "//div[@class='col-md-9 col-sm-12']")
    public List <WebElement> bookDatasList;

    @FindBy(xpath = "(//label[@id='userName-value'])[8]")
    public WebElement bookWebsiteLink;

    @FindBy(xpath = "//*[contains(text(),'index.html')]")
    public WebElement bookWebsiteLink2;

    @FindBy(id = "addNewRecordButton")
    public WebElement backToBookStoreButton;






















}
