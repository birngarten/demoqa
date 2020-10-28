package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_33_Page {

    public US_33_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@class='card-up']")
    public WebElement elementsCard;

    @FindBy(xpath = "//span[.='Broken Links - Images']")
    public WebElement brokenLinksMenu;

    @FindBy(xpath = "//p")
    public List<WebElement> brokenLinkWebElementList;

    @FindBy(xpath = "(//img[@src='/images/Toolsqa.jpg'])[2]")
    public WebElement validImage;

    @FindBy(xpath = "//img[@src='/images/Toolsqa_1.jpg']")
    public WebElement brokenImage;

    @FindBy(xpath = "(//a)[2]")
    public WebElement validLink;





}
