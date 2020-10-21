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
    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[4]")
    public WebElement wigdedsCard;
    @FindBy(xpath = "//*[.='Accordian']")
    public WebElement accordianLink;
    @FindBy(xpath = "//div[@class='card-header']")
    public List<WebElement> accordionHeader;
    @FindBy(xpath = "(//div[@class='accordion'])[2]")
    public WebElement test;
    @FindBy(xpath = "//p")
    public WebElement AccordionText;
    @FindBy(id = "section1Content")
    public WebElement firstText;
    @FindBy(id = "section2Content")
    public WebElement secondText;
    @FindBy(id = "section3Content")
    public WebElement thirdText;
}


