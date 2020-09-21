package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class US015Page {
    public US015Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[4]")
    public WebElement widgetsCard;
    @FindBy(xpath = "(//li[@class='btn btn-light '])[16]")
    public WebElement accordianLink;
    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement pageHeader;
    @FindBy(xpath = "//p")
    public WebElement textsOfOpenAccordion;
//    @FindBy(xpath = "//button[@class='btn btn-primary']")
//    public List<WebElement> clickMe;
    @FindBy(xpath = "//div[@id='section1Content']")
    public WebElement accordion1Text;
    @FindBy(xpath = "//div[@id='section2Content']")
    public WebElement accordion2Text;
    @FindBy(xpath = "//div[@id='section3Content']")
    public WebElement accordion3Text;


}
