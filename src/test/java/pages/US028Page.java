package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;

public class US028Page {
    public US028Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[.='Dragabble']")
    public WebElement draggbleLink;
    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement pageHeader;
    @FindBy(xpath = "//a[@role='tab']")
    public List<WebElement> mainTabs;
    @FindBy(id = "dragBox")
    public WebElement dragBox;
    @FindBy(id = "restrictedX")
    public WebElement restrictedX;
    @FindBy(id = "restrictedY")
    public WebElement restrictedY;
    @FindBy(xpath = "//div[@class='draggable ui-widget-content ui-draggable ui-draggable-handle']")
    public WebElement upperBox;
    @FindBy(xpath = "//span[@class='ui-widget-header ui-draggable ui-draggable-handle']")
    public WebElement downerBox;
    @FindBy(id = "cursorCenter")
    public WebElement box1;
    @FindBy(id = "cursorTopLeft")
    public WebElement box2;
    @FindBy(id = "cursorBottom")
    public WebElement box3;
}
