package pagesDemoqa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US020Page {
    public US020Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement pageHeader;
    @FindBy(xpath = "//div[@class='mb-3']")
    public WebElement upperHeader;
    @FindBy(xpath = "//a")
    public List<WebElement> tabs;

}
