package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_21_Page {
    public US_21_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[4]")
    public WebElement widgetsCard;

    @FindBy(xpath = "//*[.='Tool Tips']")
    public WebElement linkToolTips;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement mainHeader;

    @FindBy(xpath = "//*[.='Practice Tool Tips']")
    public WebElement subHeader;

    @FindBy(id = "toolTipButton")
    public WebElement buttonHover;

    @FindBy(id = "toolTipTextField")
    public WebElement bosTextBox;

    @FindBy(xpath = "//div[@class='tooltip-inner']")
    public WebElement hoverGizliText;

    @FindBy(id = "texToolTopContainer")
    public WebElement doluText;

}
