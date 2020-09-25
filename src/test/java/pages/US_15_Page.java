package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_15_Page {

    public US_15_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='card-up'])[4]")
    public WebElement widgedsCard;

    @FindBy(xpath = "(//li[@id='item-0'])[4]")
    public WebElement accordianMenuLink;

    @FindBy(xpath = "//div[@class='card-header']")
    public List<WebElement> accordianHeader;

    @FindBy(xpath = "//p")
    public WebElement accordionText;

    @FindBy(xpath = "//div[@id='section1Content']")
    public WebElement firstText;


}
