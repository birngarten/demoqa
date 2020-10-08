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
}
