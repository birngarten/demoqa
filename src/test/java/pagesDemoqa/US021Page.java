package pagesDemoqa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US021Page {
    public US021Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement pageHeader;
    @FindBy(id = "buttonToolTopContainer")
    public WebElement buttonHeader;
    @FindBy(id = "toolTipButton")
    public WebElement hoverMeToSeeButton;
    @FindBy(xpath = "//div[@class='tooltip-inner']")
    public WebElement afterHoverText;
    @FindBy(id = "texToolTopContainer")
    public WebElement fullTextBox;


}
