package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_22_Page {
    public US_22_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='card-up'])[4]")
    public WebElement widgetcard;

    @FindBy(xpath = "(//li[@id='item-7'])[2]")
    public WebElement menuLinki;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement menuHeadText;

    @FindBy(xpath = "//div[@class='col-12 mt-4 col-md-6']")
    public WebElement mainItem123;

    @FindBy(xpath = "//ul[@id='nav']/li")
    public List<WebElement> menuItems;

    @FindBy(xpath = "//ul[@id='nav']/li/a")
    public List<WebElement> beyazYaziTips;

    @FindBy(xpath = "(//ul[@id='nav']/li)[2]//a")
    public List<WebElement> mainItem2SublINKS;

    @FindBy(xpath = "(//ul[@id='nav']//li)[2]/ul/li")
    public List<WebElement> subILinks2;

    @FindBy(xpath = "//ul[@id='nav']/li[2]/ul/li")
    public List<WebElement> subText3;

    @FindBy(xpath = "(//ul[@id='nav']/li)[2]")
    public WebElement mainItems2;
    @FindBy(xpath = "//ul[@id='nav']//li[2]/ul/li/ul//li")
    public  List<WebElement>  subSubItems;
    //Resit beyin locate
    @FindBy(xpath = "(//ul[@id='nav']/li)[2]")
    public WebElement mainItemsResitbey;

    @FindBy(xpath = "(//ul[@id='nav']//li[2]/ul/li)[3]")
    public WebElement subSubList;

    @FindBy(xpath = "//ul[@id='nav']//li[2]/ul/li/ul/li")
    //  //ul[@id='nav']//li[2]/ul/li/ul/li
    public List<WebElement>  subSubtGreeColor;


}
