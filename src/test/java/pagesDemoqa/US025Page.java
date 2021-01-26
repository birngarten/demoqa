package pagesDemoqa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US025Page {
    public US025Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[.='Selectable']")
    public WebElement selectableLink;
    @FindBy(id = "demo-tab-list")
    public WebElement listLink;
    @FindBy(id = "demo-tab-grid")
    public WebElement gridLink;
    @FindBy(xpath = "//li[@class='mt-2 list-group-item list-group-item-action']")
    public List<WebElement> verticalListContainer;
    @FindBy(xpath = "//li[@class='list-group-item list-group-item-action']")
    public List<WebElement> numbersListContainer;

}
