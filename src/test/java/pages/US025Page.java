package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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
}
