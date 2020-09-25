package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_14_Page {
    public US_14_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[3]")
    public WebElement alertsCard;
    @FindBy(xpath = "//*[.='Modal Dialogs']")
    public WebElement modalDialogsLink;
    @FindBy(id = "showSmallModal")
    public WebElement smalButton;
    @FindBy(id = "showLargeModal")
    public WebElement largeButton;
    @FindBy(xpath = "//div[@class='modal-body']")
    public WebElement smallModalBox;
    @FindBy(xpath = "//body[@class='']")
    public WebElement boxStatusCheck;
    @FindBy(id = "closeSmallModal")
    public WebElement smallBoxCloseButton;
    @FindBy(xpath = "//p")
    public WebElement largeText;
    @FindBy(id = "closeLargeModal")
    public WebElement closeLargeTextButton;


}


