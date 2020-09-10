package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_06_Page {
    public US_06_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "item-5")
    public WebElement linksMenuLink;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement linksHeaderText;

    @FindBy(id = "dynamicLink")
    public WebElement ikinciHomeLink;

    @FindBy(id = "moved")
    public WebElement movedLink;

    @FindBy(id = "linkResponse")
    public WebElement movedResponseText;


}
