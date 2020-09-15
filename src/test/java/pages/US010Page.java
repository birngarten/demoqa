package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US010Page {
    public US010Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[3]")
    public WebElement alersFrameAndWindows;
    @FindBy(xpath = "//*[.='Browser Windows']")
    public WebElement browserWindows;
    @FindBy(xpath = "//div[@class='element-list collapse show']")
    public WebElement AlertsFrameWindows;
}
