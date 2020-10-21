package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_20_Page {
    public US_20_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[4]")
    public WebElement widgetsCard;

    @FindBy(xpath = "//*[.='Tabs']")
    public WebElement linkTabs;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement mainHeader;

    @FindBy(className = "mb-3")
    public WebElement subHeader;

    @FindBy(id = "demo-tab-what")
    public WebElement whatElement;

    @FindBy(id = "demo-tab-origin")
    public WebElement originElement;

    @FindBy(id = "demo-tab-use")
    public WebElement useElement;

    @FindBy(id = "demo-tab-more")
    public WebElement moreElement;

    @FindBy(xpath = "//p[@class='mt-3']")
    public List<WebElement> metinlerListesi;

    @FindBy(xpath = "//a[@role='tab']")
    public List<WebElement> tabLinkleriListesi;


}