package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US012Page {
    public US012Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[3]")
    public WebElement alertsFrameWinwowsCard;
    @FindBy(xpath = "(//li[@id='item-2'])[2]")
    public WebElement framesPageLink;














}
