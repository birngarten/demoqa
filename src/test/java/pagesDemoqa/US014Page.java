package pagesDemoqa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US014Page {
    public US014Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[3]")
    public WebElement alertsFrameWinwowsCard;
    @FindBy(xpath = "//*[.='Modal Dialogs']")
    public WebElement modalDialogsLink;
    @FindBy(id = "showSmallModal")
    public WebElement smallModalButton;
    @FindBy(id = "showLargeModal")
    public WebElement largeModalButton;
    @FindBy(xpath = "//div[@class='modal-body']")
    public WebElement smallModalText;
    @FindBy(id = "closeSmallModal")
    public WebElement smallModalWindowCloseButton;
    @FindBy(xpath = "//p")
    public WebElement largeModalText;
    @FindBy(id = "closeLargeModal")
    public WebElement largeModalWindowCloseButton;
    @FindBy (xpath = "//body")
    public WebElement textAssertionTag;




}
