package pagesDemoqa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US024Page {
    public US024Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[.='Sortable']")
    public WebElement sortableLink;
    @FindBy(id = "demo-tab-list")
    public WebElement listLink;
    @FindBy(id = "demo-tab-grid")
    public WebElement gridLink;
    @FindBy(xpath = "//div[@class='list-group-item list-group-item-action']")
    public List<WebElement> numbers;

}
