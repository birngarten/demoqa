package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_08_Page {
    public US_08_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "item-8")
    public WebElement dynamicPropertiesMenuLink;

    @FindBy(xpath = "//*[.='This text has random Id']")
    public WebElement randomText;

    @FindBy(id = "enableAfter")
    public  WebElement enableButton;

    @FindBy(id = "colorChange")
    public  WebElement colorChangeButton;

    @FindBy(id = "visibleAfter")
    public WebElement visibleButton;
}
