package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US022Page {
    public US022Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[4]")
    public WebElement widgetsCard;
    @FindBy(xpath = "(//li[@id='item-7'])[2]")
    public WebElement MenuLink;
    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement pageHeader;
    @FindBy(partialLinkText = "Main")
    public List<WebElement> mainBoxesLinks;
    @FindBy(xpath = "(//div/ul/li)[34]")
    public WebElement greenBackGround;

}
