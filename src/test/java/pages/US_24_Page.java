package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_24_Page {
    public US_24_Page (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='card-up'])[5]")
    public WebElement interactionsMenucard;

    @FindBy(xpath = "(//li[@id='item-0'])[5]")
    public WebElement sortableMenuButton;

    @FindBy(xpath = "//a[@id='demo-tab-list']")
    public WebElement listBox;

    @FindBy(xpath = "//a[@id='demo-tab-grid']")
    public WebElement gridBox;

    @FindBy(xpath = "(//div[.='One'])[1]")
    public WebElement oneBox;
    @FindBy(xpath = "(//div[.='Two'])[1]")
    public WebElement twoBox;
    @FindBy(xpath = "(//div[.='Three'])[1]")
    public WebElement threeBox;
    @FindBy(xpath = "(//div[.='Four'])[1]")
    public WebElement fourBox;
    @FindBy(xpath = "(//div[.='Five'])[1]")
    public WebElement fiveBox;
    @FindBy(xpath = "(//div[.='Six'])[1]")
    public WebElement sixBox;

    @FindBy(xpath = "//div[@class='vertical-list-container mt-4']/div")
    public List<WebElement> listContainer;

    @FindBy(xpath = "(//div[.='One'])[2]")
    public WebElement oneBoxGrid;
    @FindBy(xpath = "(//div[.='Two'])[2]")
    public WebElement twoBoxGrid;
    @FindBy(xpath = "(//div[.='Three'])[2]")
    public WebElement threeBoxGrid;
    @FindBy(xpath = "(//div[.='Four'])[2]")
    public WebElement fourBoxGrid;
    @FindBy(xpath = "(//div[.='Five'])[2]")
    public WebElement fiveBoxGrid;
    @FindBy(xpath = "(//div[.='Six'])[2]")
    public WebElement sixBoxGrid;
    @FindBy(xpath = "//div[.='Seven']")
    public WebElement sevenBoxGrid;
    @FindBy(xpath = "//div[.='Eight']")
    public WebElement eightBoxGrid;
    @FindBy(xpath = "//div[.='Nine']")
    public WebElement nineBoxGrid;


}

